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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ReLoginShareActivity extends com.baidu.tieba.g {
    private ao c = null;
    private Button d = null;
    private Button e = null;
    private ImageView f = null;
    private TextView g = null;
    private ProgressBar j = null;
    private String k = null;
    private String l = null;
    private String m = null;
    private AccountData n = null;
    private j o = null;

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f635a = null;
    LinearLayout b = null;
    private View.OnClickListener p = new an(this);

    public static void a(Activity activity, String str, String str2, String str3, String str4) {
        Intent intent = new Intent(activity, ReLoginShareActivity.class);
        intent.putExtra("user_name", str);
        intent.putExtra("bduss", str2);
        intent.putExtra("ptoken", str3);
        intent.putExtra("goto_type", str4);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        b();
        c();
        m();
    }

    private void b() {
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

    private void c() {
        this.d = (Button) findViewById(R.id.relogin_retry_button);
        this.d.setOnClickListener(this.p);
        this.e = (Button) findViewById(R.id.relogin_cacel_button);
        this.e.setOnClickListener(this.p);
        this.f = (ImageView) findViewById(R.id.relogin_bt_back);
        this.f.setOnClickListener(this.p);
        this.j = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.g = (TextView) findViewById(R.id.relogin_textview);
        this.f635a = (LinearLayout) findViewById(R.id.container);
        this.b = (LinearLayout) findViewById(R.id.title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        a(0, this.k);
        com.baidu.tieba.util.x.a((TextView) this.e, i);
        com.baidu.tieba.util.x.a(this.f, i);
        com.baidu.tieba.util.x.a(this.f635a, i);
        com.baidu.tieba.util.x.d(this.b, i);
        com.baidu.tieba.util.x.b(this.g, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        String str2;
        if (str == null) {
            str = "";
        }
        switch (i) {
            case 0:
                this.d.setVisibility(8);
                this.j.setVisibility(0);
                String string = getString(R.string.relogin_statement);
                int indexOf = string.indexOf(63);
                String replace = string.replace("?", str);
                this.g.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.g.setText(replace);
                    return;
                }
                SpannableString spannableString = new SpannableString(replace);
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.g.setText(spannableString);
                return;
            case 1:
                this.d.setVisibility(0);
                this.j.setVisibility(8);
                String string2 = getString(R.string.relogin_fail);
                this.g.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.g.setText(string2);
                    return;
                }
                SpannableString spannableString2 = new SpannableString(String.valueOf(str2) + str);
                int length = (String.valueOf(string2) + "\n\n").length();
                if (this.i == 1) {
                    spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
                }
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), length, str.length() + length, 33);
                spannableString2.setSpan(new RelativeSizeSpan(0.9f), length, str.length() + length, 33);
                this.g.setText(spannableString2);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        String E = TiebaApplication.E();
        if (E == null || E.length() <= 0) {
            MainTabActivity.a(this, "goto_recommend");
            return;
        }
        DatabaseService.m();
        TiebaApplication.b((AccountData) null);
        MainTabActivity.b(this, "goto_recommend");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.c != null) {
            this.c.cancel();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.c == null && this.l != null && this.m != null) {
            this.c = new ao(this, null);
            this.c.setPriority(3);
            this.c.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        String stringExtra = getIntent().getStringExtra("goto_type");
        DatabaseService.a(this.n);
        TiebaApplication.b(this.n);
        MainTabActivity.b(this, stringExtra);
        a.a().e();
    }
}
