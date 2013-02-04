package com.baidu.tieba.account;

import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends AsyncTask {
    final /* synthetic */ ActivationActivity a;
    private com.baidu.tieba.c.t b;

    private n(ActivationActivity activationActivity) {
        this.a = activationActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ n(ActivationActivity activationActivity, n nVar) {
        this(activationActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Boolean doInBackground(String... strArr) {
        com.baidu.tieba.a.ao aoVar;
        boolean z = false;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/getsmscode");
            com.baidu.tieba.c.t tVar = this.b;
            aoVar = this.a.q;
            tVar.a("phonenum", aoVar.c());
            this.b.i();
            if (this.b.b()) {
                z = true;
            }
        } catch (Exception e) {
            com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        return Boolean.valueOf(z);
    }

    public void a() {
        ProgressBar progressBar;
        EditText editText;
        RelativeLayout relativeLayout;
        this.a.m = null;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        editText = this.a.j;
        if (editText.length() == 6) {
            relativeLayout = this.a.k;
            relativeLayout.setEnabled(true);
        }
        if (this.b != null) {
            this.b.g();
        }
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Boolean bool) {
        ProgressBar progressBar;
        EditText editText;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        super.onPostExecute(bool);
        this.a.m = null;
        progressBar = this.a.f;
        progressBar.setVisibility(8);
        editText = this.a.j;
        if (editText.length() == 6) {
            relativeLayout = this.a.k;
            relativeLayout.setEnabled(true);
        }
        if (bool.booleanValue()) {
            this.a.g();
            return;
        }
        String f = this.b.f();
        if (f == null || f.length() <= 0) {
            return;
        }
        textView = this.a.i;
        textView.setVisibility(0);
        textView2 = this.a.i;
        textView2.setText(f);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        TextView textView;
        TextView textView2;
        RelativeLayout relativeLayout;
        progressBar = this.a.f;
        progressBar.setVisibility(0);
        textView = this.a.i;
        textView.setVisibility(4);
        textView2 = this.a.i;
        textView2.setText((CharSequence) null);
        relativeLayout = this.a.k;
        relativeLayout.setEnabled(false);
        super.onPreExecute();
    }
}
