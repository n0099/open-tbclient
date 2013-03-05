package com.baidu.tieba.account;

import android.os.AsyncTask;
import android.widget.ProgressBar;
import com.baidu.loginshare.Token;
import com.baidu.tieba.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends AsyncTask {
    final /* synthetic */ ReLoginShareActivity a;
    private volatile com.baidu.tieba.c.t b;

    private at(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ at(ReLoginShareActivity reLoginShareActivity, at atVar) {
        this(reLoginShareActivity);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        String str;
        ReLoginShareActivity reLoginShareActivity = this.a;
        str = this.a.k;
        reLoginShareActivity.a(0, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public com.baidu.tieba.b.g doInBackground(String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.b.g gVar = null;
        long nanoTime = System.nanoTime();
        this.b = new com.baidu.tieba.c.t("http://c.tieba.baidu.com/c/s/login");
        com.baidu.tieba.c.t tVar = this.b;
        str = this.a.l;
        StringBuilder append = new StringBuilder(String.valueOf(str)).append("|");
        str2 = this.a.m;
        tVar.a("bdusstoken", append.append(str2).toString());
        this.b.b(false);
        str3 = this.a.l;
        com.baidu.tieba.c.ag.e("", "mBDUSS = ", str3);
        str4 = this.a.m;
        com.baidu.tieba.c.ag.e("", "mPtoken = ", str4);
        String i = this.b.i();
        if (this.b.b()) {
            gVar = new com.baidu.tieba.b.g();
            gVar.a(i);
        } else {
            com.baidu.tieba.c.ag.e(getClass().getName(), "doInBackground", "relogin fail");
        }
        if (this.b.c() && this.b.d() == 1) {
            Token token = new Token();
            str5 = this.a.l;
            token.mBduss = str5;
            str6 = this.a.m;
            token.mPtoken = str6;
            a.a().a(token);
            a.a().e();
        }
        long nanoTime2 = 2000 - ((System.nanoTime() - nanoTime) / 1000000);
        if (nanoTime2 > 0 && nanoTime2 < 2000) {
            try {
                Thread.sleep(nanoTime2);
            } catch (InterruptedException e) {
            }
        }
        return gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(com.baidu.tieba.b.g gVar) {
        com.baidu.tieba.a.a aVar;
        com.baidu.tieba.a.a aVar2;
        com.baidu.tieba.a.a aVar3;
        com.baidu.tieba.a.a aVar4;
        com.baidu.tieba.a.a aVar5;
        com.baidu.tieba.a.a aVar6;
        o oVar;
        o oVar2;
        o oVar3;
        o oVar4;
        com.baidu.tieba.a.a aVar7;
        o oVar5;
        ProgressBar progressBar;
        o oVar6;
        o oVar7;
        com.baidu.tieba.a.a aVar8;
        String str;
        super.onPostExecute(gVar);
        this.a.e = null;
        if (gVar != null) {
            this.a.n = new com.baidu.tieba.a.a();
            aVar = this.a.n;
            aVar.b(gVar.a().b());
            aVar2 = this.a.n;
            aVar2.c("");
            aVar3 = this.a.n;
            aVar3.a(gVar.a().a());
            if (gVar.a().j() != null) {
                StringBuilder append = new StringBuilder(String.valueOf(gVar.a().j())).append("|");
                str = this.a.m;
                r0 = append.append(str).toString();
            }
            aVar4 = this.a.n;
            aVar4.d(r0);
            aVar5 = this.a.n;
            aVar5.a(1);
            if (gVar.b() != null) {
                aVar8 = this.a.n;
                aVar8.e(gVar.b().b());
            }
            aVar6 = this.a.n;
            if (aVar6.b() == null) {
                oVar = this.a.o;
                if (oVar == null) {
                    this.a.o = new o(this.a);
                    oVar6 = this.a.o;
                    oVar6.a(new au(this));
                    oVar7 = this.a.o;
                    oVar7.b(new av(this));
                }
                oVar2 = this.a.o;
                oVar2.e();
                oVar3 = this.a.o;
                oVar3.a("");
                oVar4 = this.a.o;
                aVar7 = this.a.n;
                oVar4.a(aVar7);
                oVar5 = this.a.o;
                oVar5.a();
                progressBar = this.a.j;
                progressBar.setVisibility(4);
                return;
            }
            this.a.m();
            return;
        }
        r0 = this.b != null ? this.b.f() : null;
        if (r0 == null) {
            r0 = this.a.getString(R.string.data_load_error);
        }
        this.a.a(1, r0);
    }

    public boolean a() {
        if (this.b != null) {
            this.b.g();
        }
        this.a.e = null;
        return super.cancel(true);
    }
}
