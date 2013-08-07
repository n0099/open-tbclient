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
public class CreateBarSuccessActivity extends com.baidu.tieba.g {
    private String d = null;
    private ImageView e = null;
    private TextView f = null;

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f1104a = null;
    View b = null;
    TextView c = null;

    public static void a(Context context, String str) {
        if (str != null && str.length() > 0) {
            Intent intent = new Intent(context, CreateBarSuccessActivity.class);
            intent.putExtra("barname", str);
            context.startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.create_bar_success_activity);
        b();
        c();
    }

    private void b() {
        this.d = getIntent().getStringExtra("barname");
        if (this.d == null) {
            this.d = "";
        }
    }

    private void c() {
        this.f1104a = (LinearLayout) findViewById(R.id.container);
        this.b = findViewById(R.id.title);
        this.c = (TextView) findViewById(R.id.title_text);
        this.e = (ImageView) findViewById(R.id.back);
        this.e.setOnClickListener(new e(this));
        this.f = (TextView) findViewById(R.id.text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        String string;
        super.a(i);
        com.baidu.tieba.util.ah.a(this.e, i);
        com.baidu.tieba.util.ah.a(this.f1104a, i);
        com.baidu.tieba.util.ah.d(this.b, i);
        int length = getString(R.string.create_bar_info1).length();
        String str = String.valueOf(string) + this.d + getString(R.string.create_bar_info2);
        SpannableString spannableString = new SpannableString(str);
        if (i == 1) {
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), this.d.length() + length, str.length(), 33);
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.rgb(229, 4, 0)), length, this.d.length() + length, 33);
        this.f.setText(spannableString);
    }
}
