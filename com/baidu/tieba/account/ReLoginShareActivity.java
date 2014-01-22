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
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ReLoginShareActivity extends com.baidu.tieba.j {
    private NavigationBar k;
    private Button b = null;
    private Button c = null;
    private TextView d = null;
    private ProgressBar e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private x i = null;
    LinearLayout a = null;
    private boolean j = false;
    private View.OnClickListener l = new bj(this);
    private be m = new bk(this);

    public static void a(Activity activity, String str, String str2, String str3, int i) {
        Intent intent = new Intent(activity, ReLoginShareActivity.class);
        intent.putExtra("user_name", str);
        intent.putExtra("bduss", str2);
        intent.putExtra(SapiAccountManager.SESSION_PTOKEN, str3);
        intent.putExtra("locate_type", i);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        a();
        b();
        d();
    }

    private void a() {
        Intent intent = getIntent();
        this.f = intent.getStringExtra("user_name");
        this.g = intent.getStringExtra("bduss");
        this.h = intent.getStringExtra(SapiAccountManager.SESSION_PTOKEN);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f = bundle.getString("user_name");
        this.g = bundle.getString("bduss");
        this.h = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("user_name", this.f);
        bundle.putString("bduss", this.g);
        bundle.putString(SapiAccountManager.SESSION_PTOKEN, this.h);
    }

    private void b() {
        this.k = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b = (Button) findViewById(R.id.relogin_retry_button);
        this.b.setOnClickListener(this.l);
        this.c = (Button) findViewById(R.id.relogin_cacel_button);
        this.c.setOnClickListener(this.l);
        this.e = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.d = (TextView) findViewById(R.id.relogin_textview);
        this.a = (LinearLayout) findViewById(R.id.container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        a(0, this.f, null);
        this.k.c(i);
        com.baidu.tieba.util.bs.a((TextView) this.c, i);
        com.baidu.tieba.util.bs.a(this.a, i);
        com.baidu.tieba.util.bs.b(this.d, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, AccountData accountData) {
        if (str == null) {
            str = "";
        }
        switch (i) {
            case 0:
                this.b.setVisibility(8);
                this.e.setVisibility(0);
                String string = getString(R.string.relogin_statement);
                int indexOf = string.indexOf(63);
                String replace = string.replace("?", str);
                this.d.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.d.setText(replace);
                    return;
                }
                SpannableString spannableString = new SpannableString(replace);
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.d.setText(spannableString);
                return;
            case 1:
                this.b.setVisibility(0);
                this.e.setVisibility(8);
                String string2 = getString(R.string.relogin_fail);
                this.d.setTextSize(2, 16.0f);
                if (str.length() <= 0) {
                    this.d.setText(string2);
                    return;
                }
                String str2 = string2 + "\n\n";
                SpannableString spannableString2 = new SpannableString(str2 + str);
                int length = str2.length();
                if (this.mSkinType == 1) {
                    spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
                }
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), length, str.length() + length, 33);
                spannableString2.setSpan(new RelativeSizeSpan(0.9f), length, str.length() + length, 33);
                this.d.setText(spannableString2);
                return;
            case 2:
                if (this.i == null) {
                    this.i = new x(this);
                    this.i.a(new bh(this));
                    this.i.b(new bi(this));
                }
                this.i.e();
                this.i.a("");
                this.i.a(accountData);
                this.i.a();
                this.e.setVisibility(4);
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String A = TiebaApplication.A();
        if (A == null || A.length() <= 0) {
            MainTabActivity.a(this, 0);
            return;
        }
        DatabaseService.k();
        TiebaApplication.a((AccountData) null, getBaseContext());
        MainTabActivity.c(this, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.g != null && this.h != null) {
            this.j = false;
            bd.b(this.f, this.g, this.h, this.m, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountData accountData) {
        if (!this.j) {
            DatabaseService.a(accountData);
            TiebaApplication.a(accountData, getBaseContext());
        }
        MainTabActivity.c(this, getIntent().getIntExtra("locate_type", -1));
        if (TiebaApplication.h().aq() && TiebaApplication.h().as() != null) {
            UpdateDialog.a(TiebaApplication.h(), TiebaApplication.h().as(), TiebaApplication.h().ar());
        }
        if (TiebaApplication.h().aq() && TiebaApplication.h().as() != null) {
            UpdateDialog.a(TiebaApplication.h(), TiebaApplication.h().as(), TiebaApplication.h().ar());
        }
    }
}
