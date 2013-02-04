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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ReLoginShareActivity extends com.baidu.tieba.e {
    private at b = null;
    private Button c = null;
    private Button d = null;
    private Button e = null;
    private TextView f = null;
    private ProgressBar g = null;
    private String h = null;
    private String i = null;
    private String j = null;
    private com.baidu.tieba.a.a k = null;
    private o l = null;
    private View.OnClickListener m = new as(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        String str2;
        if (str == null) {
            str = "";
        }
        switch (i) {
            case 0:
                this.c.setVisibility(8);
                this.g.setVisibility(0);
                String string = getString(R.string.relogin_statement);
                int indexOf = string.indexOf(63);
                String replace = string.replace("?", str);
                this.f.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.f.setText(replace);
                    return;
                }
                SpannableString spannableString = new SpannableString(replace);
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.f.setText(spannableString);
                return;
            case 1:
                this.c.setVisibility(0);
                this.g.setVisibility(8);
                String string2 = getString(R.string.relogin_fail);
                this.f.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.f.setText(string2);
                    return;
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(str2) + str);
                int length = (String.valueOf(string2) + "\n\n").length();
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), length, str.length() + length, 33);
                spannableString2.setSpan(new RelativeSizeSpan(0.9f), length, str.length() + length, 33);
                this.f.setText(spannableString2);
                return;
            default:
                return;
        }
    }

    public static void a(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, ReLoginShareActivity.class);
        intent.putExtra("user_name", str);
        intent.putExtra("bduss", str2);
        intent.putExtra("ptoken", str3);
        activity.startActivity(intent);
    }

    private void g() {
        Intent intent = getIntent();
        this.h = intent.getStringExtra("user_name");
        this.i = intent.getStringExtra("bduss");
        this.j = intent.getStringExtra("ptoken");
    }

    private void h() {
        this.c = (Button) findViewById(R.id.relogin_retry_button);
        this.c.setOnClickListener(this.m);
        this.d = (Button) findViewById(R.id.relogin_cacel_button);
        this.d.setOnClickListener(this.m);
        this.e = (Button) findViewById(R.id.relogin_bt_back);
        this.e.setOnClickListener(this.m);
        this.g = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.f = (TextView) findViewById(R.id.relogin_textview);
        a(0, this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        String u = TiebaApplication.u();
        if (u == null || u.length() <= 0) {
            MainTabActivity.a(this, "goto_recommend");
            return;
        }
        com.baidu.tieba.c.k.i();
        TiebaApplication.b((com.baidu.tieba.a.a) null);
        MainTabActivity.b(this, "goto_recommend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.b != null || this.i == null || this.j == null) {
            return;
        }
        this.b = new at(this, null);
        this.b.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.baidu.tieba.c.k.a(this.k);
        TiebaApplication.b(this.k);
        MainTabActivity.b(this, TiebaApplication.a().ad() >= 3 ? "goto_home" : "goto_recommend");
        a.a().e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        g();
        h();
        j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.b != null) {
            this.b.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.h = bundle.getString("user_name");
        this.i = bundle.getString("bduss");
        this.j = bundle.getString("ptoken");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("user_name", this.h);
        bundle.putString("bduss", this.i);
        bundle.putString("ptoken", this.j);
    }
}
