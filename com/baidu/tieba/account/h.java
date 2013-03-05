package com.baidu.tieba.account;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends AsyncTask {
    ArrayList a;
    final /* synthetic */ AccountVcodeActivity b;
    private String d;
    private com.baidu.tieba.c.t c = null;
    private String e = null;

    public h(AccountVcodeActivity accountVcodeActivity, String str, ArrayList arrayList) {
        this.b = accountVcodeActivity;
        this.d = null;
        this.a = null;
        this.d = str;
        this.a = arrayList;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.b.l;
        progressBar.setVisibility(0);
        com.baidu.tieba.c.ag.a("LoginAsyncTask", "doInBackground", "url: " + this.d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.g doInBackground(Object... objArr) {
        com.baidu.tieba.b.g gVar;
        Exception e;
        try {
            this.c = new com.baidu.tieba.c.t(this.d);
            this.c.a(this.a);
            this.e = this.c.i();
            if (this.e != null) {
                com.baidu.tieba.c.ag.a("LoginAsyncTask", "doInBackground", "data: " + this.e);
            }
            if (!this.c.b() || this.e == null) {
                return null;
            }
            gVar = new com.baidu.tieba.b.g();
            try {
                gVar.a(this.e);
                return gVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ag.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
                return gVar;
            }
        } catch (Exception e3) {
            gVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.g gVar) {
        ProgressBar progressBar;
        String str;
        progressBar = this.b.l;
        progressBar.setVisibility(8);
        if (gVar != null) {
            this.b.j = gVar;
            this.b.l();
        } else if (this.c != null) {
            this.b.b(this.c.f());
            if (this.c.c() && this.e != null) {
                if (this.c.d() == 2 || this.c.d() == 16 || this.c.d() == 17 || this.c.d() == 18 || this.c.d() == 19 || this.c.d() == 20) {
                    this.b.setResult(0);
                    this.b.finish();
                } else if (this.c.d() == 6 || this.c.d() == 5) {
                    com.baidu.tieba.a.aw awVar = new com.baidu.tieba.a.aw();
                    awVar.a(this.e);
                    this.b.f = awVar.a();
                    this.b.g = awVar.b();
                    AccountVcodeActivity accountVcodeActivity = this.b;
                    str = this.b.g;
                    accountVcodeActivity.c(str);
                }
            }
        }
        this.b.i = null;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.c != null) {
            this.c.g();
            this.c = null;
        }
        progressBar = this.b.l;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
