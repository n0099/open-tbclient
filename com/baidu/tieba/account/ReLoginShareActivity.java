package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.MotionEventCompat;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.GuideActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.UpdateDialog;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ReLoginShareActivity extends com.baidu.tieba.f {
    private static Activity l = null;
    private NavigationBar k;
    private Button b = null;
    private Button c = null;
    private TextView d = null;
    private ProgressBar e = null;
    private String f = null;
    private String g = null;
    private String h = null;
    private y i = null;
    LinearLayout a = null;
    private boolean j = false;
    private View.OnClickListener m = new bc(this);
    private az n = new bd(this);

    public static void a(Activity activity, String str, String str2, String str3, int i) {
        Intent intent = new Intent(activity, ReLoginShareActivity.class);
        l = activity;
        intent.putExtra("user_name", str);
        intent.putExtra("bduss", str2);
        intent.putExtra(SapiAccountManager.SESSION_PTOKEN, str3);
        intent.putExtra("locate_type", i);
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        Intent intent = getIntent();
        this.f = intent.getStringExtra("user_name");
        this.g = intent.getStringExtra("bduss");
        this.h = intent.getStringExtra(SapiAccountManager.SESSION_PTOKEN);
        this.k = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.k.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.b = (Button) findViewById(R.id.relogin_retry_button);
        this.b.setOnClickListener(this.m);
        this.c = (Button) findViewById(R.id.relogin_cacel_button);
        this.c.setOnClickListener(this.m);
        this.e = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.d = (TextView) findViewById(R.id.relogin_textview);
        this.a = (LinearLayout) findViewById(R.id.container);
        a();
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        a(0, this.f, null);
        this.k.b(i);
        com.baidu.tieba.util.bq.a((TextView) this.c, i);
        com.baidu.tieba.util.bq.a(this.a, i);
        com.baidu.tieba.util.bq.b(this.d, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str, AccountData accountData) {
        String str2;
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
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb((int) MotionEventCompat.ACTION_MASK, 47, 47)), indexOf, str.length() + indexOf, 33);
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
                SpannableString spannableString2 = new SpannableString(String.valueOf(str2) + str);
                int length = (String.valueOf(string2) + "\n\n").length();
                if (this.mSkinType == 1) {
                    spannableString2.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, length, 33);
                }
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb((int) MotionEventCompat.ACTION_MASK, 47, 47)), length, str.length() + length, 33);
                spannableString2.setSpan(new RelativeSizeSpan(0.9f), length, str.length() + length, 33);
                this.d.setText(spannableString2);
                return;
            case 2:
                if (this.i == null) {
                    this.i = new y(this);
                    this.i.a(new be(this));
                    this.i.b(new bf(this));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void c(ReLoginShareActivity reLoginShareActivity) {
        if (!TextUtils.isEmpty(TiebaApplication.v())) {
            DatabaseService.i();
            TiebaApplication.a((AccountData) null, reLoginShareActivity.getBaseContext());
        }
        reLoginShareActivity.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.g != null && this.h != null) {
            this.j = false;
            new ba(this.f, this.g, this.h, this.n, true, true).execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(ReLoginShareActivity reLoginShareActivity, AccountData accountData) {
        if (!reLoginShareActivity.j) {
            DatabaseService.a(accountData);
            TiebaApplication.a(accountData, reLoginShareActivity.getBaseContext());
        }
        TiebaApplication.g();
        TiebaApplication.u();
        if (l != null) {
            l.finish();
        }
        if (TiebaApplication.g().ax()) {
            GuideActivity.a(reLoginShareActivity, "from_logo_page");
        } else {
            int intExtra = reLoginShareActivity.getIntent().getIntExtra("locate_type", -1);
            com.baidu.tieba.mention.v.a().j();
            com.baidu.tieba.mention.v.a().h();
            if (com.baidu.tieba.mainentrance.d.a() == null) {
                com.baidu.tieba.mainentrance.d.a(new com.baidu.tieba.mainentrance.e());
            }
            com.baidu.tieba.mainentrance.d.a(reLoginShareActivity, intExtra, false);
        }
        if (TiebaApplication.g().aj() && TiebaApplication.g().al() != null) {
            UpdateDialog.a(TiebaApplication.g().b(), TiebaApplication.g().al(), TiebaApplication.g().ak());
        }
        reLoginShareActivity.finish();
    }
}
