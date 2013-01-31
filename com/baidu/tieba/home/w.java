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
    private com.baidu.tieba.a.ad d;

    public w(HomeActivity homeActivity, com.baidu.tieba.a.ad adVar) {
        this.a = homeActivity;
        this.d = null;
        this.d = adVar;
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
    public com.baidu.tieba.a.ad doInBackground(Object... objArr) {
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
            com.baidu.tieba.c.af.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (this.b.c() && this.b.d() == 0 && i != null) {
            com.baidu.tieba.a.ae aeVar = new com.baidu.tieba.a.ae();
            aeVar.a(i);
            this.d.a(1);
            return aeVar.a();
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
    public void onPostExecute(com.baidu.tieba.a.ad adVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.f fVar;
        com.baidu.tieba.b.f fVar2;
        f fVar3;
        progressBar = this.a.k;
        progressBar.setVisibility(8);
        this.a.s = null;
        fVar = this.a.n;
        ArrayList d = fVar.d();
        fVar2 = this.a.n;
        ArrayList c = fVar2.c();
        if (this.c) {
            this.a.b(this.b.f());
        } else if (adVar != null) {
            if (d != null) {
                if (c != null) {
                    this.d.b(adVar.f());
                    c.add(this.d);
                }
                d.remove(this.d);
                fVar3 = this.a.l;
                if (fVar3 != null) {
                    this.a.n();
                }
            }
            if (!TiebaApplication.b().J()) {
                TiebaApplication.b().g(true);
                com.baidu.tieba.c.k.a();
            }
            if (adVar.e() == 1) {
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
