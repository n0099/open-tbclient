package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends AsyncTask {
    final /* synthetic */ HomeActivity a;
    private volatile com.baidu.tieba.c.t b = null;
    private volatile boolean c = false;
    private com.baidu.tieba.a.aa d;

    public w(HomeActivity homeActivity, com.baidu.tieba.a.aa aaVar) {
        this.a = homeActivity;
        this.d = null;
        this.d = aaVar;
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.k;
        progressBar.setVisibility(0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.aa doInBackground(Object... objArr) {
        String i;
        try {
            this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/c/forum/like");
            if (this.d.b() != null && this.d.b().length() > 0) {
                this.b.a("kw", this.d.b());
            }
            if (this.d.a() != null && this.d.a().length() > 0) {
                this.b.a("fid", this.d.a());
            }
            this.b.d(true);
            i = this.b.i();
        } catch (Exception e) {
            com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (this.b.c() && this.b.d() == 0 && i != null) {
            com.baidu.tieba.a.ab abVar = new com.baidu.tieba.a.ab();
            abVar.a(i);
            this.d.a(1);
            return abVar.a();
        }
        if (this.b.d() == 22) {
            this.c = true;
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.aa aaVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.g gVar;
        com.baidu.tieba.b.g gVar2;
        f fVar;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        this.a.s = null;
        gVar = this.a.n;
        ArrayList d = gVar.d();
        gVar2 = this.a.n;
        ArrayList c = gVar2.c();
        if (this.c) {
            this.a.b(this.b.f());
        } else if (aaVar != null) {
            if (d != null) {
                if (c != null) {
                    this.d.b(aaVar.f());
                    c.add(this.d);
                }
                d.remove(this.d);
                fVar = this.a.l;
                if (fVar != null) {
                    this.a.n();
                }
            }
            if (!TiebaApplication.b().L()) {
                TiebaApplication.b().g(true);
                com.baidu.tieba.c.k.a();
            }
            if (aaVar.e() == 1) {
                this.a.b(this.a.getString(R.string.like_success_and_addto_list));
            } else {
                this.a.b(this.a.getString(R.string.like_success_and_addto_list));
            }
        } else {
            this.a.b(this.b.f());
        }
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        this.a.s = null;
        super.cancel(true);
    }
}
