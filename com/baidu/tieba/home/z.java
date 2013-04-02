package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z extends AsyncTask {
    final /* synthetic */ HomeActivity a;
    private com.baidu.tieba.c.t b = null;
    private com.baidu.tieba.a.aa c;

    public z(HomeActivity homeActivity, com.baidu.tieba.a.aa aaVar) {
        this.a = homeActivity;
        this.c = null;
        this.c = aaVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public String doInBackground(com.baidu.tieba.a.aa... aaVarArr) {
        com.baidu.tieba.a.aa aaVar = this.c;
        if (aaVar != null) {
            try {
                if (aaVar.a() != null && aaVar.b() != null) {
                    this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/unfavo");
                    this.b.a("fid", aaVar.a());
                    this.b.a("kw", aaVar.b());
                    this.b.a("favo_type", String.valueOf(aaVar.g()));
                    this.b.d(true);
                    this.b.i();
                    return null;
                }
                return null;
            } catch (Exception e) {
                com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
                return null;
            }
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(String str) {
        ProgressBar progressBar;
        com.baidu.tieba.b.g gVar;
        f fVar;
        super.onPostExecute(str);
        this.a.o = null;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        if (this.b != null) {
            if (this.b.b()) {
                gVar = this.a.n;
                ArrayList c = gVar.c();
                if (c != null) {
                    c.remove(this.c);
                    fVar = this.a.l;
                    if (fVar != null) {
                        this.a.n();
                    }
                }
                if (!TiebaApplication.b().L()) {
                    TiebaApplication.b().g(true);
                    com.baidu.tieba.c.k.a();
                }
                this.a.b(this.a.getString(R.string.success));
                return;
            }
            this.a.b(this.b.f());
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.k;
        progressBar.setVisibility(0);
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        this.a.o = null;
        super.cancel(true);
    }
}
