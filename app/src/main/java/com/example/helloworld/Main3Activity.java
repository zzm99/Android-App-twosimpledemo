package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mImage;
    private TextView mText;
    private int num;
    private int index;
    private String[] title;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        initView();
        initData();
    }

    private void initData() {
        title = new String[]{"第一张图片", "第二张图片", "第三张图片", "第四张图片", "第五张图片"};
        images = new int[]{R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e};
        mImage.setImageResource(images[0]);
        mText.setText(title[0]);
        num = title.length;
        index = 0;
    }

    private void initView() {
        mImage = findViewById(R.id.iv_show);
        mText = findViewById(R.id.tv_show);
        findViewById(R.id.btn_previous).setOnClickListener(this);
        findViewById(R.id.btn_next).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_previous:
                if(index == 0) index=  title.length-1;
                else index--;
                break;
            case R.id.btn_next:
                if(index == title.length-1) index = 0;
                else index++;
                break;
        }
        updateImageAndTitle();
    }

    private void updateImageAndTitle() {
        mImage.setImageResource(images[index]);
        mText.setText(title[index]);
    }

}
