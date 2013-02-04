package com.baidu.tieba.account;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import java.util.Timer;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class RegisterActivity extends com.baidu.tieba.e {
    private EditText c = null;
    private EditText d = null;
    private EditText e = null;
    private Button f = null;
    private Button g = null;
    private View.OnClickListener h = null;
    private RelativeLayout i = null;
    private Button j = null;
    private Button k = null;
    private Button l = null;
    private String m = null;
    private String n = null;
    private String o = null;
    private int p = 1;
    private boolean q = true;
    private bk r = null;
    private com.baidu.tieba.b.g s = null;
    InputMethodManager b = null;
    private DialogInterface.OnCancelListener t = null;

    private void g() {
        this.b = (InputMethodManager) getSystemService("input_method");
        this.c = (EditText) findViewById(R.id.regist_edit_account);
        this.d = (EditText) findViewById(R.id.regist_edit_password);
        this.e = (EditText) findViewById(R.id.regist_edit_apassword);
        this.f = (Button) findViewById(R.id.regist_sex_male);
        this.g = (Button) findViewById(R.id.regist_sex_female);
        this.h = new bd(this);
        this.f.setOnClickListener(this.h);
        this.g.setOnClickListener(this.h);
        this.i = (RelativeLayout) findViewById(R.id.regist_protocol);
        this.i.setOnClickListener(new be(this));
        this.j = (Button) findViewById(R.id.regist_protocol_icon);
        this.j.setOnClickListener(new bf(this));
        this.k = (Button) findViewById(R.id.back);
        this.k.setOnClickListener(new bg(this));
        this.l = (Button) findViewById(R.id.regist_submit);
        this.l.setOnClickListener(new bh(this));
        this.t = new bi(this);
    }

    private void h() {
        new Timer().schedule(new bj(this), 200L);
    }

    private void i() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        this.m = this.c.getText().toString();
        String editable = this.d.getText().toString();
        this.n = com.baidu.tieba.c.ad.b(editable.getBytes());
        this.o = com.baidu.tieba.c.ad.b(this.e.getText().toString().getBytes());
        if (!com.baidu.tieba.c.ad.b(this.m)) {
            b(getText(R.string.account_err_account).toString());
        } else if (!com.baidu.tieba.c.ad.c(editable)) {
            b(getText(R.string.account_err_passwd).toString());
        } else if (!this.n.equals(this.o)) {
            b(getText(R.string.account_err_apasswd).toString());
        } else if (!this.q) {
            b(getText(R.string.account_err_protocol).toString());
        } else {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/s/reg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("un", this.m));
            arrayList.add(new BasicNameValuePair("passwd", this.n));
            arrayList.add(new BasicNameValuePair("sex", String.valueOf(this.p)));
            m();
            this.r = new bk(this, stringBuffer.toString(), arrayList);
            this.r.execute(stringBuffer.toString(), arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
        aVar.b(this.s.a().b());
        if (this.s.a().e() != null) {
            aVar.c(this.s.a().e());
        } else {
            aVar.c(this.n);
        }
        aVar.a(this.s.a().a());
        aVar.d(this.s.a().j());
        aVar.a(1);
        if (this.s.b() != null) {
            aVar.e(this.s.b().b());
        }
        com.baidu.tieba.c.k.a(aVar);
        TiebaApplication.b(aVar);
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.r != null) {
            this.r.a();
            this.r = null;
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case -1:
                i();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_register_activity);
        g();
        h();
        new ak("reg").start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        try {
            m();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        super.onDestroy();
    }
}
