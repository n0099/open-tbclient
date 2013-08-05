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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class ReLoginActivity extends com.baidu.tieba.g {
    private an c = null;
    private Button d = null;
    private Button e = null;
    private ImageView f = null;
    private TextView g = null;
    private ProgressBar j = null;
    private boolean k = false;
    private boolean l = false;
    private AccountData m = null;
    private k n = null;
    private long o = 0;
    private String p = null;

    /* renamed from: a  reason: collision with root package name */
    LinearLayout f845a = null;
    LinearLayout b = null;
    private Handler q = null;
    private Runnable r = new ah(this);
    private View.OnClickListener s = new ai(this);

    public static void a(Activity activity, String str, int i, boolean z, AccountData accountData) {
        Intent intent = new Intent(activity, ReLoginActivity.class);
        intent.putExtra("goto_type", str);
        intent.putExtra("close", z);
        intent.putExtra("uname", accountData.getAccount());
        intent.putExtra("bduss", accountData.getBDUSS());
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        this.k = getIntent().getBooleanExtra("close", false);
        this.q = new Handler();
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.l) {
            String currentAccount = BaiduAccount.get(this).getCurrentAccount();
            com.baidu.tieba.util.aj.e(getClass().getName(), "onResume", "account=" + currentAccount);
            if (currentAccount == null || currentAccount.equals("BaiduUser")) {
                finish();
            } else {
                this.m.setAccount(currentAccount);
                b();
            }
        }
        this.l = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        if (this.c != null) {
            this.c.cancel();
        }
        if (this.n != null) {
            this.n.b();
        }
        super.onDestroy();
    }

    private void b() {
        new AccountProxy(this).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new aj(this));
    }

    private void c() {
        this.d = (Button) findViewById(R.id.relogin_retry_button);
        this.d.setOnClickListener(new ak(this));
        this.e = (Button) findViewById(R.id.relogin_cacel_button);
        this.e.setOnClickListener(this.s);
        this.f = (ImageView) findViewById(R.id.relogin_bt_back);
        this.f.setOnClickListener(this.s);
        this.j = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.g = (TextView) findViewById(R.id.relogin_textview);
        this.f845a = (LinearLayout) findViewById(R.id.container);
        this.b = (LinearLayout) findViewById(R.id.title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        a(0, getIntent().getStringExtra("uname"));
        com.baidu.tieba.util.ah.a((TextView) this.e, i);
        com.baidu.tieba.util.ah.a(this.f, i);
        com.baidu.tieba.util.ah.a(this.f845a, i);
        com.baidu.tieba.util.ah.d(this.b, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (TiebaApplication.n()) {
            String E = TiebaApplication.E();
            if (E == null || E.length() <= 0) {
                a(getIntent().getStringExtra("uname"), getIntent().getStringExtra("bduss"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.c == null) {
            this.c = new an(this, str, str2);
            this.c.setPriority(3);
            this.c.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AccountData accountData) {
        AccountData H = TiebaApplication.H();
        if (H == null) {
            TiebaApplication.a(accountData, getBaseContext());
            TiebaApplication.f().T();
        } else {
            H.setID(accountData.getID());
            H.setTbs(accountData.getTbs());
            H.setBDUSS(accountData.getBDUSS());
        }
        DatabaseService.a(TiebaApplication.H());
        Handler handler = TiebaApplication.f().c;
        if (TiebaApplication.f().S() > 0) {
            handler.sendMessage(handler.obtainMessage(2));
        } else {
            handler.sendMessage(handler.obtainMessage(3));
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        String string;
        str = (str == null || str.equals("BaiduUser")) ? "" : "";
        switch (i) {
            case 0:
                this.d.setVisibility(8);
                this.j.setVisibility(0);
                if (TiebaApplication.n()) {
                    string = getString(R.string.relogin_yi_statement);
                } else {
                    string = getString(R.string.relogin_statement);
                }
                int indexOf = string.indexOf(63);
                String replace = string.replace("?", str);
                SpannableString spannableString = new SpannableString(replace);
                if (this.i == 1) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, replace.length(), 33);
                }
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb((int) Util.MASK_8BIT, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.g.setTextSize(2, 16.0f);
                this.g.setText(spannableString);
                return;
            case 1:
                this.d.setVisibility(0);
                this.j.setVisibility(8);
                String str2 = String.valueOf(getString(R.string.relogin_fail)) + "\n";
                SpannableString spannableString2 = new SpannableString(String.valueOf(str2) + str);
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb((int) Util.MASK_8BIT, 47, 47)), str2.length(), str2.length() + str.length(), 33);
                this.g.setTextSize(2, 14.0f);
                this.g.setText(spannableString2);
                return;
            default:
                return;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void k() {
        if (this.k) {
            TiebaApplication.f().B();
            setResult(-1);
        } else {
            MainTabActivity.b(this, getIntent().getStringExtra("goto_type"));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        try {
            new AccountProxy(this).startFillNameActivity(false);
            this.l = true;
        } catch (ActivityNotFoundException e) {
            com.baidu.tieba.util.aj.a(getClass().getName(), "fillUserName", e.toString());
            if (this.n == null) {
                this.n = new k(this);
                this.n.a(new al(this));
                this.n.b(new am(this));
            }
            this.n.e();
            this.n.a(getString(R.string.default_username));
            this.n.a(this.m);
            this.n.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String m() {
        Cursor query = getContentResolver().query(Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo"), new String[]{"ptoken"}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return "";
        }
        return query.getString(query.getColumnIndex("ptoken"));
    }
}
