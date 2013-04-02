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
    private EditText d = null;
    private EditText e = null;
    private EditText f = null;
    private Button g = null;
    private Button h = null;
    private View.OnClickListener i = null;
    private RelativeLayout j = null;
    private Button k = null;
    private Button l = null;
    private Button m = null;
    private String n = null;
    private String o = null;
    private String p = null;
    private int q = 1;
    private boolean r = true;
    private bk s = null;
    private com.baidu.tieba.b.h t = null;
    InputMethodManager c = null;
    private DialogInterface.OnCancelListener u = null;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.account_register_activity);
        i();
        j();
        new ak("reg").start();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i2) {
            case -1:
                k();
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        try {
            o();
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        super.onDestroy();
    }

    private void i() {
        this.c = (InputMethodManager) getSystemService("input_method");
        this.d = (EditText) findViewById(R.id.regist_edit_account);
        this.e = (EditText) findViewById(R.id.regist_edit_password);
        this.f = (EditText) findViewById(R.id.regist_edit_apassword);
        this.g = (Button) findViewById(R.id.regist_sex_male);
        this.h = (Button) findViewById(R.id.regist_sex_female);
        this.i = new bd(this);
        this.g.setOnClickListener(this.i);
        this.h.setOnClickListener(this.i);
        this.j = (RelativeLayout) findViewById(R.id.regist_protocol);
        this.j.setOnClickListener(new be(this));
        this.k = (Button) findViewById(R.id.regist_protocol_icon);
        this.k.setOnClickListener(new bf(this));
        this.l = (Button) findViewById(R.id.back);
        this.l.setOnClickListener(new bg(this));
        this.m = (Button) findViewById(R.id.regist_submit);
        this.m.setOnClickListener(new bh(this));
        this.u = new bi(this);
    }

    private void j() {
        new Timer().schedule(new bj(this), 200L);
    }

    private void k() {
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        this.n = this.d.getText().toString();
        String editable = this.e.getText().toString();
        this.o = com.baidu.tieba.c.af.b(editable.getBytes());
        this.p = com.baidu.tieba.c.af.b(this.f.getText().toString().getBytes());
        if (!com.baidu.tieba.c.af.b(this.n)) {
            b(getText(R.string.account_err_account).toString());
        } else if (!com.baidu.tieba.c.af.c(editable)) {
            b(getText(R.string.account_err_passwd).toString());
        } else if (!this.o.equals(this.p)) {
            b(getText(R.string.account_err_apasswd).toString());
        } else if (!this.r) {
            b(getText(R.string.account_err_protocol).toString());
        } else {
            StringBuffer stringBuffer = new StringBuffer(30);
            stringBuffer.append("http://c.tieba.baidu.com/");
            stringBuffer.append("c/s/reg");
            ArrayList arrayList = new ArrayList();
            arrayList.add(new BasicNameValuePair("un", this.n));
            arrayList.add(new BasicNameValuePair("passwd", this.o));
            arrayList.add(new BasicNameValuePair("sex", String.valueOf(this.q)));
            o();
            this.s = new bk(this, stringBuffer.toString(), arrayList);
            this.s.execute(stringBuffer.toString(), arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
        aVar.b(this.t.a().b());
        if (this.t.a().e() != null) {
            aVar.c(this.t.a().e());
        } else {
            aVar.c(this.o);
        }
        aVar.a(this.t.a().a());
        aVar.d(this.t.a().j());
        aVar.a(1);
        if (this.t.b() != null) {
            aVar.e(this.t.b().b());
        }
        com.baidu.tieba.c.k.a(aVar);
        TiebaApplication.b(aVar);
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        if (this.s != null) {
            this.s.a();
            this.s = null;
        }
    }
}
