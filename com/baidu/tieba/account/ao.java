package com.baidu.tieba.account;

import android.widget.ProgressBar;
import com.baidu.loginshare.Token;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends com.baidu.adp.lib.a.a {
    final /* synthetic */ ReLoginShareActivity a;
    private volatile com.baidu.tieba.d.t b;

    private ao(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ao(ReLoginShareActivity reLoginShareActivity, ao aoVar) {
        this(reLoginShareActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void b() {
        String str;
        ReLoginShareActivity reLoginShareActivity = this.a;
        str = this.a.k;
        reLoginShareActivity.a(0, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public com.baidu.tieba.c.af a(String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.c.af afVar = null;
        long nanoTime = System.nanoTime();
        this.b = new com.baidu.tieba.d.t(String.valueOf(com.baidu.tieba.a.i.e) + "c/s/login");
        com.baidu.tieba.d.t tVar = this.b;
        str = this.a.l;
        StringBuilder append = new StringBuilder(String.valueOf(str)).append("|");
        str2 = this.a.m;
        tVar.a("bdusstoken", append.append(str2).toString());
        this.b.b(false);
        str3 = this.a.l;
        com.baidu.tieba.d.ae.e("", "mBDUSS = ", str3);
        str4 = this.a.m;
        com.baidu.tieba.d.ae.e("", "mPtoken = ", str4);
        String i = this.b.i();
        if (this.b.b()) {
            afVar = new com.baidu.tieba.c.af();
            afVar.a(i);
        } else {
            com.baidu.tieba.d.ae.e(getClass().getName(), "doInBackground", "relogin fail");
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
        return afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.a.a
    public void a(com.baidu.tieba.c.af afVar) {
        com.baidu.tieba.a.a aVar;
        com.baidu.tieba.a.a aVar2;
        com.baidu.tieba.a.a aVar3;
        com.baidu.tieba.a.a aVar4;
        com.baidu.tieba.a.a aVar5;
        com.baidu.tieba.a.a aVar6;
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        com.baidu.tieba.a.a aVar7;
        j jVar5;
        ProgressBar progressBar;
        j jVar6;
        j jVar7;
        com.baidu.tieba.a.a aVar8;
        String str;
        super.a((Object) afVar);
        this.a.e = null;
        if (afVar != null) {
            this.a.n = new com.baidu.tieba.a.a();
            aVar = this.a.n;
            aVar.b(afVar.a().c());
            aVar2 = this.a.n;
            aVar2.c("");
            aVar3 = this.a.n;
            aVar3.a(afVar.a().a());
            if (afVar.a().j() != null) {
                StringBuilder append = new StringBuilder(String.valueOf(afVar.a().j())).append("|");
                str = this.a.m;
                r0 = append.append(str).toString();
            }
            aVar4 = this.a.n;
            aVar4.d(r0);
            aVar5 = this.a.n;
            aVar5.a(1);
            if (afVar.b() != null) {
                aVar8 = this.a.n;
                aVar8.e(afVar.b().b());
            }
            aVar6 = this.a.n;
            if (aVar6.b() == null) {
                jVar = this.a.o;
                if (jVar == null) {
                    this.a.o = new j(this.a);
                    jVar6 = this.a.o;
                    jVar6.a(new ap(this));
                    jVar7 = this.a.o;
                    jVar7.b(new aq(this));
                }
                jVar2 = this.a.o;
                jVar2.e();
                jVar3 = this.a.o;
                jVar3.a("");
                jVar4 = this.a.o;
                aVar7 = this.a.n;
                jVar4.a(aVar7);
                jVar5 = this.a.o;
                jVar5.a();
                progressBar = this.a.j;
                progressBar.setVisibility(4);
                return;
            }
            this.a.n();
            return;
        }
        r0 = this.b != null ? this.b.f() : null;
        if (r0 == null) {
            r0 = this.a.getString(R.string.data_load_error);
        }
        this.a.a(1, r0);
    }

    @Override // com.baidu.adp.lib.a.a
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.g();
        }
        this.a.e = null;
    }
}
