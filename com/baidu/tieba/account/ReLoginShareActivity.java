package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ReLoginShareActivity extends com.baidu.tieba.e {
    private at e = null;
    private Button f = null;
    private Button g = null;
    private Button h = null;
    private TextView i = null;
    private ProgressBar j = null;
    private String k = null;
    private String l = null;
    private String m = null;
    private com.baidu.tieba.a.a n = null;
    private o o = null;
    LinearLayout c = null;
    LinearLayout d = null;
    private View.OnClickListener p = new as(this);

    public static void a(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, ReLoginShareActivity.class);
        intent.putExtra("user_name", str);
        intent.putExtra("bduss", str2);
        intent.putExtra("ptoken", str3);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        i();
        j();
        l();
    }

    private void i() {
        Intent intent = getIntent();
        this.k = intent.getStringExtra("user_name");
        this.l = intent.getStringExtra("bduss");
        this.m = intent.getStringExtra("ptoken");
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.k = bundle.getString("user_name");
        this.l = bundle.getString("bduss");
        this.m = bundle.getString("ptoken");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("user_name", this.k);
        bundle.putString("bduss", this.l);
        bundle.putString("ptoken", this.m);
    }

    private void j() {
        this.f = (Button) findViewById(R.id.relogin_retry_button);
        this.f.setOnClickListener(this.p);
        this.g = (Button) findViewById(R.id.relogin_cacel_button);
        this.g.setOnClickListener(this.p);
        this.h = (Button) findViewById(R.id.relogin_bt_back);
        this.h.setOnClickListener(this.p);
        this.j = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.i = (TextView) findViewById(R.id.relogin_textview);
        this.c = (LinearLayout) findViewById(R.id.container);
        this.d = (LinearLayout) findViewById(R.id.title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        a(0, this.k);
        com.baidu.tieba.c.ad.c((TextView) this.h, i);
        com.baidu.tieba.c.ad.a((TextView) this.g, i);
        com.baidu.tieba.c.ad.e((TextView) this.h, i);
        com.baidu.tieba.c.ad.a(this.c, i);
        com.baidu.tieba.c.ad.c(this.d, i);
        com.baidu.tieba.c.ad.b(this.i, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        String str2;
        if (str == null) {
            str = "";
        }
        switch (i) {
            case 0:
                this.f.setVisibility(8);
                this.j.setVisibility(0);
                String string = getString(R.string.relogin_statement);
                int indexOf = string.indexOf(63);
                String replace = string.replace("?", str);
                this.i.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.i.setText(replace);
                    return;
                }
                SpannableString spannableString = new SpannableString(replace);
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.i.setText(spannableString);
                return;
            case 1:
                this.f.setVisibility(0);
                this.j.setVisibility(8);
                String string2 = getString(R.string.relogin_fail);
                this.i.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.i.setText(string2);
                    return;
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(str2) + str);
                int length = (String.valueOf(string2) + "\n\n").length();
                if (this.b == 1) {
                    spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
                }
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), length, str.length() + length, 33);
                spannableString2.setSpan(new RelativeSizeSpan(0.9f), length, str.length() + length, 33);
                this.i.setText(spannableString2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        String w = TiebaApplication.w();
        if (w == null || w.length() <= 0) {
            MainTabActivity.a(this, "goto_recommend");
            return;
        }
        com.baidu.tieba.c.k.i();
        TiebaApplication.b((com.baidu.tieba.a.a) null);
        MainTabActivity.b(this, "goto_recommend");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.a();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.e == null && this.l != null && this.m != null) {
            this.e = new at(this, null);
            this.e.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.baidu.tieba.c.k.a(this.n);
        TiebaApplication.b(this.n);
        MainTabActivity.b(this, "goto_home");
        a.a().e();
    }
}
