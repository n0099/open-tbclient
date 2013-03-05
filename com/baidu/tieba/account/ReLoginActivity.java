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
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ReLoginActivity extends com.baidu.tieba.e {
    private ar e = null;
    private Button f = null;
    private Button g = null;
    private Button h = null;
    private TextView i = null;
    private ProgressBar j = null;
    private boolean k = false;
    private boolean l = false;
    private com.baidu.tieba.a.a m = null;
    private o n = null;
    private long o = 0;
    private String p = null;
    LinearLayout c = null;
    LinearLayout d = null;
    private Handler q = null;
    private Runnable r = new al(this);
    private View.OnClickListener s = new am(this);

    public static void a(Activity activity, String str, int i, boolean z, com.baidu.tieba.a.a aVar) {
        Intent intent = new Intent(activity, ReLoginActivity.class);
        intent.putExtra("goto_view", str);
        intent.putExtra("close", z);
        intent.putExtra("uname", aVar.b());
        intent.putExtra("bduss", aVar.d());
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        this.k = getIntent().getBooleanExtra("close", false);
        this.q = new Handler();
        j();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.l) {
            String currentAccount = BaiduAccount.get(this).getCurrentAccount();
            com.baidu.tieba.c.ag.e(getClass().getName(), "onResume", "account=" + currentAccount);
            if (currentAccount == null || currentAccount.equals("BaiduUser")) {
                finish();
            } else {
                this.m.b(currentAccount);
                i();
            }
        }
        this.l = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.a();
        }
        if (this.n != null) {
            this.n.b();
        }
        super.onDestroy();
    }

    private void i() {
        new AccountProxy(this).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new an(this));
    }

    private void j() {
        this.f = (Button) findViewById(R.id.relogin_retry_button);
        this.f.setOnClickListener(new ao(this));
        this.g = (Button) findViewById(R.id.relogin_cacel_button);
        this.g.setOnClickListener(this.s);
        this.h = (Button) findViewById(R.id.relogin_bt_back);
        this.h.setOnClickListener(this.s);
        this.j = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.i = (TextView) findViewById(R.id.relogin_textview);
        this.c = (LinearLayout) findViewById(R.id.container);
        this.d = (LinearLayout) findViewById(R.id.title);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        a(0, getIntent().getStringExtra("uname"));
        com.baidu.tieba.c.ae.c((TextView) this.h, i);
        com.baidu.tieba.c.ae.a((TextView) this.g, i);
        com.baidu.tieba.c.ae.e((TextView) this.h, i);
        com.baidu.tieba.c.ae.a(this.c, i);
        com.baidu.tieba.c.ae.c(this.d, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (TiebaApplication.g()) {
            String x = TiebaApplication.x();
            if (x == null || x.length() <= 0) {
                a(getIntent().getStringExtra("uname"), getIntent().getStringExtra("bduss"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.e == null) {
            this.e = new ar(this, str, str2);
            this.e.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.a aVar) {
        com.baidu.tieba.a.a A = TiebaApplication.A();
        if (A == null) {
            TiebaApplication.a(aVar);
            TiebaApplication.b().M();
        } else {
            A.a(aVar.a());
            A.e(aVar.f());
            A.d(aVar.d());
        }
        com.baidu.tieba.c.k.a(TiebaApplication.A());
        Handler handler = TiebaApplication.b().c;
        if (TiebaApplication.b().L() > 0) {
            handler.sendMessage(handler.obtainMessage(2));
        } else {
            handler.sendMessage(handler.obtainMessage(3));
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        String string;
        str = (str == null || str.equals("BaiduUser")) ? "" : "";
        switch (i) {
            case 0:
                this.f.setVisibility(8);
                this.j.setVisibility(0);
                if (TiebaApplication.g()) {
                    string = getString(R.string.relogin_yi_statement);
                } else {
                    string = getString(R.string.relogin_statement);
                }
                int indexOf = string.indexOf(63);
                String replace = string.replace("?", str);
                SpannableString spannableString = new SpannableString(replace);
                if (this.b == 1) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.skin_1_common_color)), 0, replace.length(), 33);
                }
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.i.setTextSize(2, 16.0f);
                this.i.setText(spannableString);
                return;
            case 1:
                this.f.setVisibility(0);
                this.j.setVisibility(8);
                String str2 = String.valueOf(getString(R.string.relogin_fail)) + "\n";
                SpannableString spannableString2 = new SpannableString(String.valueOf(str2) + str);
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), str2.length(), str2.length() + str.length(), 33);
                this.i.setTextSize(2, 14.0f);
                this.i.setText(spannableString2);
                return;
            default:
                return;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    private void l() {
        if (this.k) {
            TiebaApplication.b().r();
            setResult(-1);
        } else {
            MainTabActivity.b(this, getIntent().getStringExtra("goto_view"));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        try {
            new AccountProxy(this).startFillNameActivity(false);
            this.l = true;
        } catch (ActivityNotFoundException e) {
            com.baidu.tieba.c.ag.a(getClass().getName(), "fillUserName", e.toString());
            if (this.n == null) {
                this.n = new o(this);
                this.n.a(new ap(this));
                this.n.b(new aq(this));
            }
            this.n.e();
            this.n.a(getString(R.string.default_username));
            this.n.a(this.m);
            this.n.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n() {
        Cursor query = getContentResolver().query(Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo"), new String[]{"ptoken"}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return "";
        }
        return query.getString(query.getColumnIndex("ptoken"));
    }
}
