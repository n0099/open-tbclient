package com.baidu.tieba.account;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends AsyncTask {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tieba.c.t b;

    private m(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(ActivationActivity activationActivity, m mVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.g doInBackground(String... strArr) {
        com.baidu.tieba.a.ao aoVar;
        com.baidu.tieba.a.ao aoVar2;
        com.baidu.tieba.a.ao aoVar3;
        com.baidu.tieba.a.ao aoVar4;
        com.baidu.tieba.a.ao aoVar5;
        EditText editText;
        com.baidu.tieba.a.ao aoVar6;
        com.baidu.tieba.a.ao aoVar7;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/regreal");
            com.baidu.tieba.c.t tVar = this.b;
            aoVar = this.a.q;
            tVar.a("un", aoVar.a());
            com.baidu.tieba.c.t tVar2 = this.b;
            aoVar2 = this.a.q;
            tVar2.a("phonenum", aoVar2.c());
            com.baidu.tieba.c.t tVar3 = this.b;
            aoVar3 = this.a.q;
            tVar3.a("passwd", aoVar3.b());
            aoVar4 = this.a.q;
            if (aoVar4.d() != null) {
                com.baidu.tieba.c.t tVar4 = this.b;
                aoVar7 = this.a.q;
                tVar4.a("vcode", aoVar7.d());
            }
            aoVar5 = this.a.q;
            if (aoVar5.e() != null) {
                com.baidu.tieba.c.t tVar5 = this.b;
                aoVar6 = this.a.q;
                tVar5.a("vcode_md5", aoVar6.e());
            }
            com.baidu.tieba.c.t tVar6 = this.b;
            editText = this.a.j;
            tVar6.a("smscode", editText.getText().toString());
            String i = this.b.i();
            if (this.b.b()) {
                com.baidu.tieba.b.g gVar = new com.baidu.tieba.b.g();
                gVar.a(i);
                return gVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
    }

    public void a() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.a.n = null;
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        z = this.a.o;
        if (z) {
            relativeLayout = this.a.l;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.g();
        }
        this.a.a(true);
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.g gVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.onPostExecute(gVar);
        progressBar = this.a.g;
        progressBar.setVisibility(8);
        this.a.n = null;
        this.a.a(true);
        z = this.a.o;
        if (z) {
            relativeLayout = this.a.l;
            relativeLayout.setEnabled(true);
        }
        if (gVar != null) {
            this.a.a(gVar);
            return;
        }
        String f = this.b.f();
        if (f != null && f.length() > 0) {
            textView = this.a.i;
            textView.setVisibility(0);
            textView2 = this.a.i;
            textView2.setText(f);
        }
        if (this.b.d() == 26) {
            this.a.u = 26;
            linearLayout = this.a.d;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.a.d;
            i = this.a.s;
            i2 = this.a.t;
            linearLayout2.setPadding(i, 0, i2, 0);
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        RelativeLayout relativeLayout;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        progressBar = this.a.g;
        progressBar.setVisibility(0);
        relativeLayout = this.a.l;
        relativeLayout.setEnabled(false);
        this.a.a(false);
        textView = this.a.i;
        textView.setVisibility(4);
        textView2 = this.a.i;
        textView2.setText((CharSequence) null);
        linearLayout = this.a.d;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.a.d;
        i = this.a.s;
        i2 = this.a.t;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }
}
