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
    public com.baidu.tieba.b.h doInBackground(String... strArr) {
        com.baidu.tieba.a.ap apVar;
        com.baidu.tieba.a.ap apVar2;
        com.baidu.tieba.a.ap apVar3;
        com.baidu.tieba.a.ap apVar4;
        com.baidu.tieba.a.ap apVar5;
        EditText editText;
        com.baidu.tieba.a.ap apVar6;
        com.baidu.tieba.a.ap apVar7;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/regreal");
            com.baidu.tieba.c.t tVar = this.b;
            apVar = this.a.r;
            tVar.a("un", apVar.a());
            com.baidu.tieba.c.t tVar2 = this.b;
            apVar2 = this.a.r;
            tVar2.a("phonenum", apVar2.c());
            com.baidu.tieba.c.t tVar3 = this.b;
            apVar3 = this.a.r;
            tVar3.a("passwd", apVar3.b());
            apVar4 = this.a.r;
            if (apVar4.d() != null) {
                com.baidu.tieba.c.t tVar4 = this.b;
                apVar7 = this.a.r;
                tVar4.a("vcode", apVar7.d());
            }
            apVar5 = this.a.r;
            if (apVar5.e() != null) {
                com.baidu.tieba.c.t tVar5 = this.b;
                apVar6 = this.a.r;
                tVar5.a("vcode_md5", apVar6.e());
            }
            com.baidu.tieba.c.t tVar6 = this.b;
            editText = this.a.k;
            tVar6.a("smscode", editText.getText().toString());
            String i = this.b.i();
            if (this.b.b()) {
                com.baidu.tieba.b.h hVar = new com.baidu.tieba.b.h();
                hVar.a(i);
                return hVar;
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
    public void onPostExecute(com.baidu.tieba.b.h hVar) {
        ProgressBar progressBar;
        boolean z;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        int i;
        int i2;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.onPostExecute(hVar);
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        this.a.o = null;
        this.a.a(true);
        z = this.a.p;
        if (z) {
            relativeLayout = this.a.m;
            relativeLayout.setEnabled(true);
        }
        if (hVar != null) {
            this.a.a(hVar);
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
