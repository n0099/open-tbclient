package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.ProgressBar;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends AsyncTask {
    final /* synthetic */ CreateBarActivity a;
    private String b;
    private String c;
    private com.baidu.tieba.c.t d = null;

    public void a() {
        ProgressBar progressBar;
        super.cancel(true);
        if (this.d != null) {
            this.d.g();
        }
        progressBar = this.a.o;
        progressBar.setVisibility(8);
        this.a.q = null;
    }

    public c(CreateBarActivity createBarActivity, String str, String str2) {
        this.a = createBarActivity;
        this.b = null;
        this.c = null;
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(String... strArr) {
        String str;
        try {
            this.d = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/create");
            this.d.d(true);
            this.d.a("kw", this.b);
            this.d.a("vcode", this.c);
            com.baidu.tieba.c.t tVar = this.d;
            str = this.a.u;
            tVar.a("vcode_md5", str);
            this.d.i();
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
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        super.onPostExecute(str);
        progressBar = this.a.o;
        progressBar.setVisibility(8);
        this.a.q = null;
        if (this.d.b()) {
            CreateBarSuccessActivity.a(this.a, this.b);
            this.a.finish();
            return;
        }
        this.a.b(this.d.f());
        if (this.d.c()) {
            this.a.k();
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.a.o;
        progressBar.setVisibility(0);
    }
}
