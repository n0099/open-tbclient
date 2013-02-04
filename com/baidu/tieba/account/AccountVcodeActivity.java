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
    private int b = 1;
    private String c = null;
    private String d = null;
    private String e = null;
    private String f = null;
    private int g = 1;
    private h h = null;
    private com.baidu.tieba.b.g i = null;
    private ProgressBar j = null;
    private ProgressBar k = null;
    private Button l = null;
    private Button m = null;
    private ImageView n = null;
    private EditText o = null;
    private g p = null;
    private InputMethodManager q = null;

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

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        i();
        this.p = new g(this, null);
        this.p.execute(str);
    }

    private void g() {
        this.q = (InputMethodManager) getSystemService("input_method");
        this.l = (Button) findViewById(R.id.back);
        this.l.setOnClickListener(new d(this));
        this.m = (Button) findViewById(R.id.submit);
        this.m.setOnClickListener(new e(this));
        if (this.b == 1) {
            this.m.setText(R.string.account_login);
        } else if (this.b == 2) {
            this.m.setText(R.string.account_regedit);
        }
        this.o = (EditText) findViewById(R.id.input);
        this.n = (ImageView) findViewById(R.id.vcode_image);
        this.n.setImageBitmap(null);
        this.n.setOnClickListener(new f(this));
        this.j = (ProgressBar) findViewById(R.id.progress);
        this.k = (ProgressBar) findViewById(R.id.login_progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        String editable = this.o.getText().toString();
        StringBuffer stringBuffer = new StringBuffer(30);
        stringBuffer.append("http://c.tieba.baidu.com/");
        if (this.b == 1) {
            stringBuffer.append("c/s/login");
        } else if (this.b != 2) {
            return;
        } else {
            stringBuffer.append("c/s/reg");
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair("un", this.c));
        arrayList.add(new BasicNameValuePair("passwd", this.d));
        arrayList.add(new BasicNameValuePair("vcode", editable));
        arrayList.add(new BasicNameValuePair("vcode_md5", this.e));
        if (this.b == 2) {
            arrayList.add(new BasicNameValuePair("sex", String.valueOf(this.g)));
        }
        i();
        this.h = new h(this, stringBuffer.toString(), arrayList);
        this.h.execute(stringBuffer.toString(), arrayList);
    }

    private void i() {
        if (this.h != null) {
            this.h.a();
            this.h = null;
        }
        if (this.p != null) {
            this.p.a();
            this.p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        com.baidu.tieba.a.a aVar = new com.baidu.tieba.a.a();
        aVar.b(this.i.a().b());
        if (this.i.a().e() != null) {
            aVar.c(this.i.a().e());
        } else {
            aVar.c(this.d);
        }
        aVar.a(this.i.a().a());
        aVar.d(this.i.a().j());
        aVar.a(1);
        if (this.i.b() != null) {
            aVar.e(this.i.b().b());
        }
        com.baidu.tieba.c.k.a(aVar);
        TiebaApplication.b(aVar);
        setResult(-1);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.b = bundle.getInt("type", 0);
            this.c = bundle.getString("un");
            this.d = bundle.getString("passwd");
            this.e = bundle.getString("vcode_md5");
            this.f = bundle.getString("vcode_pic_url");
            this.g = bundle.getInt("sex", 1);
        } else {
            Intent intent = getIntent();
            this.b = intent.getIntExtra("type", 0);
            this.c = intent.getStringExtra("un");
            this.d = intent.getStringExtra("passwd");
            this.e = intent.getStringExtra("vcode_md5");
            this.f = intent.getStringExtra("vcode_pic_url");
            this.g = intent.getIntExtra("sex", 1);
        }
        setContentView(R.layout.account_vcode_activity);
        g();
        c(this.f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        try {
            i();
            this.j.setVisibility(8);
            this.k.setVisibility(8);
            System.gc();
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "onDestroy", e.getMessage());
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("type", this.b);
        bundle.putString("un", this.c);
        bundle.putString("passwd", this.d);
        bundle.putString("vcode_md5", this.e);
        bundle.putString("vcode_pic_url", this.f);
        bundle.putInt("sex", this.g);
    }
}
