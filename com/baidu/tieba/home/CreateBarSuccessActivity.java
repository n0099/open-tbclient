package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class CreateBarSuccessActivity extends com.baidu.tieba.e {
    private String b = null;
    private Button c = null;
    private TextView d = null;

    public static void a(Context context, String str) {
        if (str == null || str.length() <= 0) {
            return;
        }
        Intent intent = new Intent(context, CreateBarSuccessActivity.class);
        intent.putExtra("barname", str);
        context.startActivity(intent);
    }

    private void g() {
        this.b = getIntent().getStringExtra("barname");
        if (this.b == null) {
            this.b = "";
        }
    }

    private void h() {
        this.c = (Button) findViewById(R.id.back);
        this.c.setOnClickListener(new e(this));
        this.d = (TextView) findViewById(R.id.text);
        String string = getString(R.string.create_bar_info1);
        int length = string.length();
        SpannableString spannableString = new SpannableString(String.valueOf(string) + this.b + getString(R.string.create_bar_info2));
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), length, this.b.length() + length, 33);
        this.d.setText(spannableString);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_success_activity);
        g();
        h();
    }
}
