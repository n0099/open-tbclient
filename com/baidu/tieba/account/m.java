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
        com.baidu.tieba.a.an anVar;
        com.baidu.tieba.a.an anVar2;
        com.baidu.tieba.a.an anVar3;
        com.baidu.tieba.a.an anVar4;
        com.baidu.tieba.a.an anVar5;
        EditText editText;
        com.baidu.tieba.a.an anVar6;
        com.baidu.tieba.a.an anVar7;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/regreal");
            com.baidu.tieba.c.t tVar = this.b;
            anVar = this.a.r;
            tVar.a("un", anVar.a());
            com.baidu.tieba.c.t tVar2 = this.b;
            anVar2 = this.a.r;
            tVar2.a("phonenum", anVar2.c());
            com.baidu.tieba.c.t tVar3 = this.b;
            anVar3 = this.a.r;
            tVar3.a("passwd", anVar3.b());
            anVar4 = this.a.r;
            if (anVar4.d() != null) {
                com.baidu.tieba.c.t tVar4 = this.b;
                anVar7 = this.a.r;
                tVar4.a("vcode", anVar7.d());
            }
            anVar5 = this.a.r;
            if (anVar5.e() != null) {
                com.baidu.tieba.c.t tVar5 = this.b;
                anVar6 = this.a.r;
                tVar5.a("vcode_md5", anVar6.e());
            }
            com.baidu.tieba.c.t tVar6 = this.b;
            editText = this.a.k;
            tVar6.a("smscode", editText.getText().toString());
            String i = this.b.i();
            if (this.b.b()) {
                com.baidu.tieba.b.g gVar = new com.baidu.tieba.b.g();
                gVar.a(i);
                return gVar;
            }
            return null;
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
            return null;
        }
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
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        this.a.o = null;
        this.a.a(true);
        z = this.a.p;
        if (z) {
            relativeLayout = this.a.m;
            relativeLayout.setEnabled(true);
        }
        if (gVar != null) {
            this.a.a(gVar);
            return;
        }
        String f = this.b.f();
        if (f != null && f.length() > 0) {
            textView = this.a.j;
            textView.setVisibility(0);
            textView2 = this.a.j;
            textView2.setText(f);
        }
        if (this.b.d() == 26) {
            this.a.A = 26;
            linearLayout = this.a.e;
            linearLayout.setBackgroundResource(R.drawable.pass_input_wrong);
            linearLayout2 = this.a.e;
            i = this.a.y;
            i2 = this.a.z;
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
        progressBar = this.a.h;
        progressBar.setVisibility(0);
        relativeLayout = this.a.m;
        relativeLayout.setEnabled(false);
        this.a.a(false);
        textView = this.a.j;
        textView.setVisibility(4);
        textView2 = this.a.j;
        textView2.setText((CharSequence) null);
        linearLayout = this.a.e;
        linearLayout.setBackgroundResource(R.drawable.pass_input);
        linearLayout2 = this.a.e;
        i = this.a.y;
        i2 = this.a.z;
        linearLayout2.setPadding(i, 0, i2, 0);
        super.onPreExecute();
    }

    public void a() {
        ProgressBar progressBar;
        boolean z;
        RelativeLayout relativeLayout;
        this.a.o = null;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        z = this.a.p;
        if (z) {
            relativeLayout = this.a.m;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.g();
        }
        this.a.a(true);
        super.cancel(true);
    }
}
