package com.baidu.tieba.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class CreateBarSuccessActivity extends com.baidu.tieba.e {
    private String f = null;
    private ImageView g = null;
    private TextView h = null;
    LinearLayout c = null;
    View d = null;
    TextView e = null;

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarSuccessActivity.class);
            intent.putExtra("barname", str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_success_activity);
        b();
        c();
    }

    private void b() {
        this.f = getIntent().getStringExtra("barname");
        if (this.f == null) {
            this.f = "";
        }
    }

    private void c() {
        this.c = (LinearLayout) findViewById(R.id.container);
        this.d = findViewById(R.id.title);
        this.e = (TextView) findViewById(R.id.title_text);
        this.g = (ImageView) findViewById(R.id.back);
        this.g.setOnClickListener(new e(this));
        this.h = (TextView) findViewById(R.id.text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        String string;
        super.b(i);
        com.baidu.tieba.d.ac.a(this.g, i);
        com.baidu.tieba.d.ac.a(this.c, i);
        com.baidu.tieba.d.ac.d(this.d, i);
        int length = getString(R.string.create_bar_info1).length();
        String str = String.valueOf(string) + this.f + getString(R.string.create_bar_info2);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), this.f.length() + length, str.length(), 33);
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), length, this.f.length() + length, 33);
        this.h.setText(spannableString);
    }
}
