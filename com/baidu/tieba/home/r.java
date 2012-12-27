package com.baidu.tieba.home;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends AsyncTask {
    final /* synthetic */ HomeActivity a;
    private volatile com.baidu.tieba.c.t b = null;
    private volatile boolean c = false;
    private com.baidu.tieba.a.ac d;

    public r(HomeActivity homeActivity, com.baidu.tieba.a.ac acVar) {
        this.a = homeActivity;
        this.d = null;
        this.d = acVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.a.ac doInBackground(Object... objArr) {
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
            com.baidu.tieba.c.ae.b(getClass().getName(), "doInBackground", e.getMessage());
        }
        if (!this.b.c() || this.b.d() != 0 || i == null) {
            if (this.b.d() == 22) {
                this.c = true;
            }
            return null;
        }
        com.baidu.tieba.a.ad adVar = new com.baidu.tieba.a.ad();
        adVar.a(i);
        this.d.a(1);
        return adVar.a();
    }

    public void a() {
        ProgressBar progressBar;
        if (this.b != null) {
            this.b.g();
            this.b = null;
        }
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        this.a.m = null;
        super.cancel(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.a.ac acVar) {
        ProgressBar progressBar;
        com.baidu.tieba.b.f fVar;
        com.baidu.tieba.b.f fVar2;
        f fVar3;
        progressBar = this.a.e;
        progressBar.setVisibility(8);
        this.a.m = null;
        fVar = this.a.h;
        ArrayList d = fVar.d();
        fVar2 = this.a.h;
        ArrayList c = fVar2.c();
        if (this.c) {
            this.a.b(this.b.f());
        } else if (acVar == null) {
            this.a.b(this.b.f());
        } else {
            if (d != null) {
                if (c != null) {
                    this.d.b(acVar.f());
                    c.add(this.d);
                }
                d.remove(this.d);
                fVar3 = this.a.f;
                if (fVar3 != null) {
                    this.a.k();
                }
            }
            if (!TiebaApplication.a().F()) {
                TiebaApplication.a().f(true);
                com.baidu.tieba.c.k.a();
            }
            if (acVar.e() == 1) {
                this.a.b(this.a.getString(R.string.like_success_and_addto_list));
            } else {
                this.a.b(this.a.getString(R.string.like_success_and_addto_list));
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        progressBar = this.a.e;
        progressBar.setVisibility(0);
    }
}
