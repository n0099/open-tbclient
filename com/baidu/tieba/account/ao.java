package com.baidu.tieba.account;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.loginshare.Token;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ao extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f652a;
    private volatile com.baidu.tieba.util.r b;

    private ao(ReLoginShareActivity reLoginShareActivity) {
        this.f652a = reLoginShareActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ao(ReLoginShareActivity reLoginShareActivity, ao aoVar) {
        this(reLoginShareActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        String str;
        ReLoginShareActivity reLoginShareActivity = this.f652a;
        str = this.f652a.k;
        reLoginShareActivity.a(0, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.al a(String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.model.al alVar = null;
        long nanoTime = System.nanoTime();
        this.b = new com.baidu.tieba.util.r(String.valueOf(com.baidu.tieba.data.g.f787a) + "c/s/login");
        com.baidu.tieba.util.r rVar = this.b;
        str = this.f652a.l;
        StringBuilder append = new StringBuilder(String.valueOf(str)).append("|");
        str2 = this.f652a.m;
        rVar.a("bdusstoken", append.append(str2).toString());
        this.b.b(false);
        str3 = this.f652a.l;
        com.baidu.tieba.util.z.e("", "mBDUSS = ", str3);
        str4 = this.f652a.m;
        com.baidu.tieba.util.z.e("", "mPtoken = ", str4);
        String j = this.b.j();
        if (this.b.c()) {
            alVar = new com.baidu.tieba.model.al();
            alVar.a(j);
        } else {
            com.baidu.tieba.util.z.e(getClass().getName(), "doInBackground", "relogin fail");
        }
        if (this.b.d() && this.b.e() == 1) {
            Token token = new Token();
            str5 = this.f652a.l;
            token.mBduss = str5;
            str6 = this.f652a.m;
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
        return alVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.al alVar) {
        AccountData accountData;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        AccountData accountData5;
        AccountData accountData6;
        j jVar;
        j jVar2;
        j jVar3;
        j jVar4;
        AccountData accountData7;
        j jVar5;
        ProgressBar progressBar;
        j jVar6;
        j jVar7;
        AccountData accountData8;
        String str;
        super.a((Object) alVar);
        this.f652a.c = null;
        if (alVar != null) {
            this.f652a.n = new AccountData();
            accountData = this.f652a.n;
            accountData.setAccount(alVar.a().getName());
            accountData2 = this.f652a.n;
            accountData2.setPassword("");
            accountData3 = this.f652a.n;
            accountData3.setID(alVar.a().getId());
            if (alVar.a().getBDUSS() != null) {
                StringBuilder append = new StringBuilder(String.valueOf(alVar.a().getBDUSS())).append("|");
                str = this.f652a.m;
                r0 = append.append(str).toString();
            }
            accountData4 = this.f652a.n;
            accountData4.setBDUSS(r0);
            accountData5 = this.f652a.n;
            accountData5.setIsActive(1);
            if (alVar.b() != null) {
                accountData8 = this.f652a.n;
                accountData8.setTbs(alVar.b().getTbs());
            }
            accountData6 = this.f652a.n;
            if (accountData6.getAccount() == null) {
                jVar = this.f652a.o;
                if (jVar == null) {
                    this.f652a.o = new j(this.f652a);
                    jVar6 = this.f652a.o;
                    jVar6.a(new ap(this));
                    jVar7 = this.f652a.o;
                    jVar7.b(new aq(this));
                }
                jVar2 = this.f652a.o;
                jVar2.e();
                jVar3 = this.f652a.o;
                jVar3.a("");
                jVar4 = this.f652a.o;
                accountData7 = this.f652a.n;
                jVar4.a(accountData7);
                jVar5 = this.f652a.o;
                jVar5.a();
                progressBar = this.f652a.j;
                progressBar.setVisibility(4);
                return;
            }
            this.f652a.n();
            return;
        }
        r0 = this.b != null ? this.b.g() : null;
        if (r0 == null) {
            r0 = this.f652a.getString(R.string.data_load_error);
        }
        this.f652a.a(1, r0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f652a.c = null;
    }
}
