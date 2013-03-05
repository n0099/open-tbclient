package com.baidu.tieba.account;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes.dex */
public class AccountVcodeActivity extends com.baidu.tieba.e {
    private int c = 1;
    private String d = null;
    private String e = null;
    private String f = null;
    private String g = null;
    private int h = 1;
    private h i = null;
    private com.baidu.tieba.b.g j = null;
    private ProgressBar k = null;
    private ProgressBar l = null;
    private Button m = null;
    private Button n = null;
    private ImageView o = null;
    private EditText p = null;
    private g q = null;
    private InputMethodManager r = null;

    public static void a(Activity activity, String str, String str2, int i, String str3, String str4) {
        Intent intent = new Intent(activity, AccountVcodeActivity.class);
        intent.putExtra("un", str);
        intent.putExtra("passwd", str2);
        intent.putExtra("vcode_md5", str3);
        intent.putExtra("vcode_pic_url", str4);
        intent.putExtra("sex", i);
        intent.putExtra("type", 2);
        intent.setFlags(524288);
        activity.startActivityForResult(intent, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.c = bundle.getInt("type", 0);
            this.d = bundle.getString("un");
            this.e = bundle.getString("passwd");
            this.f = bundle.getString("vcode_md5");
            this.g = bundle.getString("vcode_pic_url");
            this.h = bundle.getInt("sex", 1);
        } else {
            Intent intent = getIntent();
            this.c = intent.getIntExtra("type", 0);
            this.d = intent.getStringExtra("un");
            this.e = intent.getStringExtra("passwd");
            this.f = intent.getStringExtra("vcode_md5");
            this.g = intent.getStringExtra("vcode_pic_url");
            this.h = intent.getIntExtra("sex", 1);
        }
        setContentView(R.layout.account_vcode_activity);
        i();
        c(this.g);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("type", this.c);
        bundle.putString("un", this.d);
        bundle.putString("passwd", this.e);
        bundle.putString("vcode_md5", this.f);
        bundle.putString("vcode_pic_url", this.g);
        bundle.putInt("sex", this.h);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        try {
            k();
            this.k.setVisibility(8);
            this.l.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        super.onDestroy();
    }

    private void i() {
        this.r = (InputMethodManager) getSystemService("input_method");
        this.m = (Button) findViewById(R.id.back);
        this.m.setOnClickListener(new d(this));
        this.n = (Button) findViewById(R.id.submit);
        this.n.setOnClickListener(new e(this));
        if (this.c == 1) {
            this.n.setText(R.string.account_login);
        } else if (this.c == 2) {
            this.n.setText(R.string.account_regedit);
        }
        this.p = (EditText) findViewById(R.id.input);
        this.o = (ImageView) findViewById(R.id.vcode_image);
        this.o.setImageBitmap(null);
        this.o.setOnClickListener(new f(this));
        this.k = (ProgressBar) findViewById(R.id.progress);
        this.l = (ProgressBar) findViewById(R.id.login_progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        String editable = this.p.getText().toString();
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        if (this.c == 1) {
            stringBuffer.append("c/s/login");
        } else if (this.c == 2) {
            stringBuffer.append("c/s/reg");
        } else {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("un", this.d));
        arrayList.add(new BasicNameValuePair("passwd", this.e));
        arrayList.add(new BasicNameValuePair("vcode", editable));
        arrayList.add(new BasicNameValuePair("vcode_md5", this.f));
        if (this.c == 2) {
            arrayList.add(new BasicNameValuePair("sex", String.valueOf(this.h)));
        }
        k();
        this.i = new h(this, stringBuffer.toString(), arrayList);
        this.i.execute(stringBuffer.toString(), arrayList);
    }

    private void k() {
        if (this.i != null) {
            this.i.a();
            this.i = null;
        }
        if (this.q != null) {
            this.q.a();
            this.q = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
        aVar.b(this.j.a().b());
        if (this.j.a().e() != null) {
            aVar.c(this.j.a().e());
        } else {
            aVar.c(this.e);
        }
        aVar.a(this.j.a().a());
        aVar.d(this.j.a().j());
        aVar.a(1);
        if (this.j.b() != null) {
            aVar.e(this.j.b().b());
        }
        com.baidu.tieba.c.k.a(aVar);
        TiebaApplication.b(aVar);
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        k();
        this.q = new g(this, null);
        this.q.execute(str);
    }
}
