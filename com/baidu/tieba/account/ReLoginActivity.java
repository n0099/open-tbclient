package com.baidu.tieba.account;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.account.AccountProxy;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.NavigationBar;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class ReLoginActivity extends com.baidu.tieba.j {
    private NavigationBar m;
    private ap b = null;
    private Button c = null;
    private Button d = null;
    private TextView e = null;
    private ProgressBar f = null;
    private boolean g = false;
    private boolean h = false;
    private AccountData i = null;
    private n j = null;
    private long k = 0;
    private String l = null;

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f1033a = null;
    private Handler n = null;
    private Runnable o = new aj(this);
    private View.OnClickListener p = new am(this);

    public static void a(Activity activity, int i, int i2, boolean z, AccountData accountData) {
        Intent intent = new Intent(activity, ReLoginActivity.class);
        intent.putExtra("locate_type", i);
        intent.putExtra("close", z);
        intent.putExtra("uname", accountData.getAccount());
        intent.putExtra(SocialConstants.PARAM_BDUSS, accountData.getBDUSS());
        activity.startActivityForResult(intent, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        this.g = getIntent().getBooleanExtra("close", false);
        this.n = new Handler();
        b();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.h) {
            String currentAccount = BaiduAccount.get(this).getCurrentAccount();
            bd.e(getClass().getName(), "onResume", "account=" + currentAccount);
            if (currentAccount == null || currentAccount.equals("BaiduUser")) {
                finish();
            } else {
                this.i.setAccount(currentAccount);
                a();
            }
        }
        this.h = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        if (this.b != null) {
            this.b.cancel();
        }
        if (this.j != null) {
            this.j.b();
        }
        super.onDestroy();
    }

    private void a() {
        new AccountProxy(this).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new ak(this));
    }

    private void b() {
        this.m = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.m.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.c = (Button) findViewById(R.id.relogin_retry_button);
        this.c.setOnClickListener(new al(this));
        this.d = (Button) findViewById(R.id.relogin_cacel_button);
        this.d.setOnClickListener(this.p);
        this.f = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.e = (TextView) findViewById(R.id.relogin_textview);
        this.f1033a = (LinearLayout) findViewById(R.id.container);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        a(0, getIntent().getStringExtra("uname"));
        this.m.c(i);
        com.baidu.tieba.util.ba.a((TextView) this.d, i);
        com.baidu.tieba.util.ba.a(this.f1033a, i);
        com.baidu.tieba.util.ba.b(this.e, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (TiebaApplication.o()) {
            String B = TiebaApplication.B();
            if (B == null || B.length() <= 0) {
                a(getIntent().getStringExtra("uname"), getIntent().getStringExtra(SocialConstants.PARAM_BDUSS));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.b == null) {
            this.b = new ap(this, str, str2);
            this.b.setPriority(3);
            this.b.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountData accountData) {
        AccountData F = TiebaApplication.F();
        if (F == null) {
            TiebaApplication.a(accountData, getBaseContext());
            TiebaApplication.h().O();
        } else {
            F.setID(accountData.getID());
            F.setTbs(accountData.getTbs());
            F.setPortrait(accountData.getPortrait());
            TiebaApplication.l(accountData.getBDUSS());
        }
        DatabaseService.a(TiebaApplication.F());
        Handler handler = TiebaApplication.h().c;
        if (TiebaApplication.h().N() > 0) {
            handler.sendMessage(handler.obtainMessage(2));
        } else {
            handler.sendMessage(handler.obtainMessage(3));
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        String string;
        str = (str == null || str.equals("BaiduUser")) ? "" : "";
        switch (i) {
            case 0:
                this.c.setVisibility(8);
                this.f.setVisibility(0);
                if (TiebaApplication.o()) {
                    string = getString(R.string.relogin_yi_statement);
                } else {
                    string = getString(R.string.relogin_statement);
                }
                int indexOf = string.indexOf(63);
                String replace = string.replace("?", str);
                SpannableString spannableString = new SpannableString(replace);
                if (this.mSkinType == 1) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, replace.length(), 33);
                }
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb((int) Util.MASK_8BIT, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.e.setTextSize(2, 16.0f);
                this.e.setText(spannableString);
                return;
            case 1:
                this.c.setVisibility(0);
                this.f.setVisibility(8);
                String str2 = getString(R.string.relogin_fail) + "\n";
                SpannableString spannableString2 = new SpannableString(str2 + str);
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb((int) Util.MASK_8BIT, 47, 47)), str2.length(), str2.length() + str.length(), 33);
                this.e.setTextSize(2, 14.0f);
                this.e.setText(spannableString2);
                return;
            default:
                return;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void d() {
        if (this.g) {
            TiebaApplication.h().A();
            setResult(-1);
        } else {
            MainTabActivity.b(this, getIntent().getIntExtra("locate_type", -1));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            new AccountProxy(this).startFillNameActivity(false);
            this.h = true;
        } catch (ActivityNotFoundException e) {
            bd.a(getClass().getName(), "fillUserName", e.toString());
            if (this.j == null) {
                this.j = new n(this);
                this.j.a(new an(this));
                this.j.b(new ao(this));
            }
            this.j.e();
            this.j.a(getString(R.string.default_username));
            this.j.a(this.i);
            this.j.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String f() {
        Cursor query = getContentResolver().query(Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo"), new String[]{"ptoken"}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return "";
        }
        return query.getString(query.getColumnIndex("ptoken"));
    }
}
