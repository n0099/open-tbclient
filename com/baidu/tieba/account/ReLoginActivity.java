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
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class ReLoginActivity extends com.baidu.tieba.e {
    private ar b = null;
    private Button c = null;
    private Button d = null;
    private Button e = null;
    private TextView f = null;
    private ProgressBar g = null;
    private boolean h = false;
    private boolean i = false;
    private com.baidu.tieba.a.a j = null;
    private o k = null;
    private long l = 0;
    private String m = null;
    private Handler n = null;
    private Runnable o = new al(this);
    private View.OnClickListener p = new am(this);

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, String str) {
        str = (str == null || str.equals("BaiduUser")) ? "" : "";
        switch (i) {
            case 0:
                this.c.setVisibility(8);
                this.g.setVisibility(0);
                String string = TiebaApplication.f() ? getString(R.string.relogin_yi_statement) : getString(R.string.relogin_statement);
                int indexOf = string.indexOf(63);
                SpannableString spannableString = new SpannableString(string.replace("?", str));
                spannableString.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), indexOf, str.length() + indexOf, 33);
                this.f.setTextSize(2, 16.0f);
                this.f.setText(spannableString);
                return;
            case 1:
                this.c.setVisibility(0);
                this.g.setVisibility(8);
                String str2 = String.valueOf(getString(R.string.relogin_fail)) + "\n";
                SpannableString spannableString2 = new SpannableString(String.valueOf(str2) + str);
                spannableString2.setSpan(new ForegroundColorSpan(Color.rgb(255, 47, 47)), str2.length(), str2.length() + str.length(), 33);
                this.f.setTextSize(2, 14.0f);
                this.f.setText(spannableString2);
                return;
            default:
                return;
        }
    }

    public static void a(Activity activity, String str, int i, boolean z, com.baidu.tieba.a.a aVar) {
        Intent intent = new Intent(activity, ReLoginActivity.class);
        intent.putExtra("goto_view", str);
        intent.putExtra("close", z);
        intent.putExtra("uname", aVar.b());
        intent.putExtra("bduss", aVar.d());
        activity.startActivityForResult(intent, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.a.a aVar) {
        com.baidu.tieba.a.a w = TiebaApplication.w();
        if (w == null) {
            TiebaApplication.a(aVar);
            TiebaApplication.a().H();
        } else {
            w.a(aVar.a());
            w.e(aVar.f());
            w.d(aVar.d());
        }
        com.baidu.tieba.c.k.a(TiebaApplication.w());
        Handler handler = TiebaApplication.a().c;
        if (TiebaApplication.a().G() > 0) {
            handler.sendMessage(handler.obtainMessage(2));
        } else {
            handler.sendMessage(handler.obtainMessage(3));
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.b != null) {
            return;
        }
        this.b = new ar(this, str, str2);
        this.b.execute(new String[0]);
    }

    private void g() {
        new AccountProxy(this).getTokenAsync(AccountProxy.BAIDUACCOUNT_TYPE, new an(this));
    }

    private void h() {
        this.c = (Button) findViewById(R.id.relogin_retry_button);
        this.c.setOnClickListener(new ao(this));
        this.d = (Button) findViewById(R.id.relogin_cacel_button);
        this.d.setOnClickListener(this.p);
        this.e = (Button) findViewById(R.id.relogin_bt_back);
        this.e.setOnClickListener(this.p);
        this.g = (ProgressBar) findViewById(R.id.relogin_progressbar);
        this.f = (TextView) findViewById(R.id.relogin_textview);
        a(0, getIntent().getStringExtra("uname"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (TiebaApplication.f()) {
            String u = TiebaApplication.u();
            if (u == null || u.length() <= 0) {
                a(getIntent().getStringExtra("uname"), getIntent().getStringExtra("bduss"));
            }
        }
    }

    private void j() {
        if (this.h) {
            TiebaApplication.a().p();
            setResult(-1);
        } else {
            MainTabActivity.b(this, getIntent().getStringExtra("goto_view"));
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        try {
            new AccountProxy(this).startFillNameActivity(false);
            this.i = true;
        } catch (ActivityNotFoundException e) {
            com.baidu.tieba.c.ae.a(getClass().getName(), "fillUserName", e.toString());
            if (this.k == null) {
                this.k = new o(this);
                this.k.a(new ap(this));
                this.k.b(new aq(this));
            }
            this.k.e();
            this.k.a(getString(R.string.default_username));
            this.k.a(this.j);
            this.k.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String l() {
        Cursor query = getContentResolver().query(Uri.parse("content://com.baidu.account.provider.AccountInfoProvider/accountInfo"), new String[]{"ptoken"}, null, null, null);
        return (query == null || !query.moveToFirst()) ? "" : query.getString(query.getColumnIndex("ptoken"));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.relogin_activity);
        this.h = getIntent().getBooleanExtra("close", false);
        this.n = new Handler();
        h();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        if (this.b != null) {
            this.b.a();
        }
        if (this.k != null) {
            this.k.b();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.i) {
            String currentAccount = BaiduAccount.get(this).getCurrentAccount();
            com.baidu.tieba.c.ae.c(getClass().getName(), "onResume", "account=" + currentAccount);
            if (currentAccount == null || currentAccount.equals("BaiduUser")) {
                finish();
            } else {
                this.j.b(currentAccount);
                g();
            }
        }
        this.i = false;
    }
}
