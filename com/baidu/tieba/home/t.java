package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends AsyncTask {
    final /* synthetic */ HomeActivity a;
    private com.baidu.tieba.c.t b = null;
    private com.baidu.tieba.a.ac c;

    public t(HomeActivity homeActivity, com.baidu.tieba.a.ac acVar) {
        this.a = homeActivity;
        this.c = null;
        this.c = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(com.baidu.tieba.a.ac... acVarArr) {
        com.baidu.tieba.a.ac acVar = this.c;
        if (acVar != null) {
            try {
                if (acVar.a() == null || acVar.b() == null) {
                    return null;
                }
                this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/unfavo");
                this.b.a("fid", acVar.a());
                this.b.a("kw", acVar.b());
                this.b.a("favo_type", String.valueOf(acVar.g()));
                this.b.d(true);
                this.b.i();
                return null;
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        this.a.i = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.b.f fVar;
        f fVar2;
        super.onPostExecute(str);
        this.a.i = null;
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (!this.b.b()) {
                this.a.b(this.b.f());
                return;
            }
            fVar = this.a.h;
            ArrayList c = fVar.c();
            if (c != null) {
                c.remove(this.c);
                fVar2 = this.a.f;
                if (fVar2 != null) {
                    this.a.k();
                }
            }
            if (!TiebaApplication.a().F()) {
                TiebaApplication.a().f(true);
                com.baidu.tieba.c.k.a();
            }
            this.a.b(this.a.getString(R.string.success));
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.e;
        progressBar.setVisibility(0);
    }
}
