package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CreateBarSuccessActivity extends BaseActivity {
    private static final String BAR_NAME_STRING = "barname";
    private String mBarName = null;
    private Button mBack = null;
    private TextView mTextView = null;

    public static void startActivity(Context context, String bar_name) {
        if (bar_name != null && bar_name.length() > 0) {
            Intent intent = new Intent(context, CreateBarSuccessActivity.class);
            intent.putExtra(BAR_NAME_STRING, bar_name);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_bar_success_activity);
        initData();
        initUi();
    }

    private void initData() {
        Intent intent = getIntent();
        this.mBarName = intent.getStringExtra(BAR_NAME_STRING);
        if (this.mBarName == null) {
            this.mBarName = "";
        }
    }

    private void initUi() {
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.CreateBarSuccessActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                CreateBarSuccessActivity.this.finish();
            }
        });
        this.mTextView = (TextView) findViewById(R.id.text);
        String str = getString(R.string.create_bar_info1);
        int start = str.length();
        SpannableString info = new SpannableString(String.valueOf(str) + this.mBarName + getString(R.string.create_bar_info2));
        info.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), start, this.mBarName.length() + start, 33);
        this.mTextView.setText(info);
    }
}
