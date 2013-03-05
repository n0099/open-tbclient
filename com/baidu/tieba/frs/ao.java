package com.baidu.tieba.frs;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.WaterFallView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends AsyncTask {
    final /* synthetic */ FrsImageActivity a;
    private int b;
    private com.baidu.tieba.c.t c = null;

    public ao(FrsImageActivity frsImageActivity, int i) {
        this.a = frsImageActivity;
        this.b = 0;
        this.b = i;
        if (this.b < 1) {
            this.b = 1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.d doInBackground(Object... objArr) {
        com.baidu.tieba.b.d dVar;
        Exception e;
        String str;
        String str2;
        int i;
        String str3;
        try {
            this.c = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/f/frs/photolist");
            str = this.a.B;
            if (str != null) {
                com.baidu.tieba.c.t tVar = this.c;
                str3 = this.a.B;
                tVar.a("st_type", str3);
            }
            com.baidu.tieba.c.t tVar2 = this.c;
            str2 = this.a.e;
            tVar2.a("kw", str2);
            this.c.a("bs", String.valueOf(this.b));
            this.c.a("be", String.valueOf((this.b + 240) - 1));
            this.c.a("an", String.valueOf(30));
            String i2 = this.c.i();
            if (!this.c.b()) {
                return null;
            }
            dVar = new com.baidu.tieba.b.d();
            try {
                dVar.a(i2);
                i = this.a.C;
                if (i == 1) {
                    com.baidu.tieba.c.k.j(dVar.a().c());
                    return dVar;
                }
                return dVar;
            } catch (Exception e2) {
                e = e2;
                com.baidu.tieba.c.ag.b(getClass().getName(), "doInBackground", e.getMessage());
                return dVar;
            }
        } catch (Exception e3) {
            dVar = null;
            e = e3;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.d dVar) {
        ProgressBar progressBar;
        WaterFallView waterFallView;
        com.baidu.tieba.b.d dVar2;
        WaterFallView waterFallView2;
        int i;
        int i2;
        com.baidu.tieba.b.d dVar3;
        String str;
        super.onPostExecute(dVar);
        this.a.f = null;
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        if (dVar != null) {
            this.a.q = dVar;
            waterFallView = this.a.d;
            waterFallView.b();
            this.a.a(dVar.b());
            this.a.u = 30;
            dVar2 = this.a.q;
            if (dVar2.c().size() > 30) {
                this.a.a(an.NORMAL);
            } else {
                if (this.b == 1) {
                    dVar3 = this.a.q;
                    if (dVar3.c().size() == 0) {
                        this.a.a(an.NO_ITEM);
                    }
                }
                this.a.a(an.LAST);
            }
            waterFallView2 = this.a.d;
            waterFallView2.scrollTo(0, 0);
            this.a.v = this.b;
            i = this.a.v;
            if (i > 1) {
                this.a.n();
            } else {
                this.a.o();
            }
            i2 = this.a.C;
            if (i2 == 1) {
                this.a.C = 0;
                this.a.getIntent().putExtra("add_search", 0);
            }
        } else if (this.c != null) {
            this.a.b(this.c.f());
            if (this.c.c() && this.c.d() == 2000) {
                TiebaApplication b = TiebaApplication.b();
                str = this.a.e;
                b.d(str);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        ProgressBar progressBar;
        super.onPreExecute();
        progressBar = this.a.h;
        progressBar.setVisibility(0);
    }

    public void a() {
        ProgressBar progressBar;
        this.a.f = null;
        if (this.c != null) {
            this.c.g();
        }
        progressBar = this.a.h;
        progressBar.setVisibility(8);
        super.cancel(true);
    }
}
