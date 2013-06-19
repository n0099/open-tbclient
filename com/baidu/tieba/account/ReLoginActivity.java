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
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class ReLoginActivity extends com.baidu.tieba.e {
    private am e = null;
    private Button f = null;
    private Button g = null;
    private ImageView h = null;
    private TextView i = null;
    private ProgressBar j = null;
    private boolean k = false;
    private boolean l = false;
    private com.baidu.tieba.a.a m = null;
    private j n = null;
    private long o = 0;
    private String p = null;
    LinearLayout c = null;
    LinearLayout d = null;
    private Handler q = null;
    private Runnable r = new ag(this);
    private View.OnClickListener s = new ah(this);

    public static void a(Activity activity, String str, int i, boolean z, com.baidu.tieba.a.a aVar) {
        Intent intent = new Intent(activity, ReLoginActivity.class);
        intent.putExtra("goto_type", str);
        intent.putExtra("close", z);
        intent.putExtra("uname", aVar.b());
        intent.putExtra("bduss", aVar.d());
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        this.k = getIntent().getBooleanExtra("close", false);
        this.q = new Handler();
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.l) {
            String currentAccount = BaiduAccount.get(this).getCurrentAccount();
            com.baidu.tieba.d.ae.e(getClass().getName(), "onResume", "account=" + currentAccount);
            if (currentAccount == null || currentAccount.equals("BaiduUser")) {
                finish();
            } else {
                this.m.b(currentAccount);
                b();
            }
        }
        this.l = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.e != null) {
            this.e.cancel();
        }
        if (this.n != null) {
            this.n.b();
        }
        super.onDestroy();
    }

    private void b() {
        new AccountProxy(this).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new ai(this));
    }

    private void c() {
        this.f = (Button) findViewById(R.id.relogin_retry_button);
        this.f.setOnClickListener(new aj(this));
        this.g = (Button) findViewById(R.id.relogin_cacel_button);
        this.g.setOnClickListener(this.s);
        this.h = (ImageView) findViewById(R.id.relogin_bt_back);
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
        com.baidu.tieba.d.ac.a((TextView) this.g, i);
        com.baidu.tieba.d.ac.a(this.h, i);
        com.baidu.tieba.d.ac.a(this.c, i);
        com.baidu.tieba.d.ac.d(this.d, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (TiebaApplication.j()) {
            String C = TiebaApplication.C();
            if (C == null || C.length() <= 0) {
                a(getIntent().getStringExtra("uname"), getIntent().getStringExtra("bduss"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.e == null) {
            this.e = new am(this, str, str2);
            this.e.setPriority(3);
            this.e.execute(new String[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.a aVar) {
        com.baidu.tieba.a.a F = TiebaApplication.F();
        if (F == null) {
            TiebaApplication.a(aVar);
            TiebaApplication.e().R();
        } else {
            F.a(aVar.a());
            F.e(aVar.f());
            F.d(aVar.d());
        }
        com.baidu.tieba.d.k.a(TiebaApplication.F());
        Handler handler = TiebaApplication.e().c;
        if (TiebaApplication.e().Q() > 0) {
            handler.sendMessage(handler.obtainMessage(2));
        } else {
            handler.sendMessage(handler.obtainMessage(3));
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        String string;
        str = (str == null || str.equals("BaiduUser")) ? "" : "";
        switch (i) {
            case 0:
                this.f.setVisibility(8);
                this.j.setVisibility(0);
                if (TiebaApplication.j()) {
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

    private void m() {
        if (this.k) {
            TiebaApplication.e().x();
            setResult(-1);
        } else {
            MainTabActivity.b(this, getIntent().getStringExtra("goto_type"));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        try {
            new AccountProxy(this).startFillNameActivity(false);
            this.l = true;
        } catch (ActivityNotFoundException e) {
            com.baidu.tieba.d.ae.a(getClass().getName(), "fillUserName", e.toString());
            if (this.n == null) {
                this.n = new j(this);
                this.n.a(new ak(this));
                this.n.b(new al(this));
            }
            this.n.e();
            this.n.a(getString(R.string.default_username));
            this.n.a(this.m);
            this.n.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String o() {
        Cursor query = getContentResolver().query(Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo"), new String[]{"ptoken"}, null, null, null);
        if (query == null || !query.moveToFirst()) {
            return "";
        }
        return query.getString(query.getColumnIndex("ptoken"));
    }
}
