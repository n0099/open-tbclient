package com.baidu.tieba.account;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends AsyncTask {
    final /* synthetic */ o a;
    private com.baidu.tieba.c.t b = null;
    private String c;
    private String d;

    public u(o oVar, String str, String str2) {
        this.a = oVar;
        this.c = null;
        this.d = null;
        this.c = str;
        this.d = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.d doInBackground(String... strArr) {
        this.b = new com.baidu.tieba.c.t(this.c);
        this.b.a("un", this.d);
        String i = this.b.i();
        if (this.b.c() && this.b.d() == 36) {
            com.baidu.tieba.a.d dVar = new com.baidu.tieba.a.d();
            dVar.a(i);
            return dVar;
        }
        return null;
    }

    public void a() {
        ProgressBar progressBar;
        Button button;
        super.cancel(true);
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        this.a.m = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.d dVar) {
        ProgressBar progressBar;
        Button button;
        com.baidu.tieba.e eVar;
        super.onPostExecute(dVar);
        this.a.m = null;
        progressBar = this.a.p;
        progressBar.setVisibility(8);
        button = this.a.k;
        button.setEnabled(true);
        if (!this.b.c()) {
            this.a.b(this.b.f());
        } else if (this.b.d() == 0) {
            o oVar = this.a;
            eVar = this.a.j;
            oVar.b(eVar.getString(R.string.name_not_use));
        } else if (this.b.d() != 36) {
            this.a.b(this.b.f());
        } else {
            this.a.b(this.b.f());
            if (dVar != null) {
                this.a.a(dVar.b());
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        Button button;
        progressBar = this.a.p;
        progressBar.setVisibility(0);
        button = this.a.k;
        button.setEnabled(false);
        this.a.b((String) null);
        this.a.d();
        super.onPreExecute();
    }
}
