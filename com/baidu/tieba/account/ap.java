package com.baidu.tieba.account;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f864a;
    private volatile com.baidu.tieba.util.u b;

    private ap(ReLoginShareActivity reLoginShareActivity) {
        this.f864a = reLoginShareActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ap(ReLoginShareActivity reLoginShareActivity, ap apVar) {
        this(reLoginShareActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        String str;
        ReLoginShareActivity reLoginShareActivity = this.f864a;
        str = this.f864a.k;
        reLoginShareActivity.a(0, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public com.baidu.tieba.model.at a(String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        com.baidu.tieba.model.at atVar = null;
        long nanoTime = System.nanoTime();
        this.b = new com.baidu.tieba.util.u(String.valueOf(com.baidu.tieba.data.g.f1013a) + "c/s/login");
        com.baidu.tieba.util.u uVar = this.b;
        str = this.f864a.l;
        StringBuilder append = new StringBuilder(String.valueOf(str)).append("|");
        str2 = this.f864a.m;
        uVar.a("bdusstoken", append.append(str2).toString());
        this.b.a("channel_id", TiebaApplication.f().bj());
        this.b.c(false);
        str3 = this.f864a.l;
        com.baidu.tieba.util.aj.e("", "mBDUSS = ", str3);
        str4 = this.f864a.m;
        com.baidu.tieba.util.aj.e("", "mPtoken = ", str4);
        String k = this.b.k();
        if (this.b.d()) {
            atVar = new com.baidu.tieba.model.at();
            atVar.a(k);
        } else {
            com.baidu.tieba.util.aj.e(getClass().getName(), "doInBackground", "relogin fail");
        }
        if (this.b.e() && this.b.f() == 1) {
            Token token = new Token();
            str5 = this.f864a.l;
            token.mBduss = str5;
            str6 = this.f864a.m;
            token.mPtoken = str6;
            a.a().a(token);
            a.a().d();
        }
        long nanoTime2 = 2000 - ((System.nanoTime() - nanoTime) / 1000000);
        if (nanoTime2 > 0 && nanoTime2 < 2000) {
            try {
                Thread.sleep(nanoTime2);
            } catch (InterruptedException e) {
            }
        }
        return atVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.at atVar) {
        AccountData accountData;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        AccountData accountData5;
        AccountData accountData6;
        k kVar;
        k kVar2;
        k kVar3;
        k kVar4;
        AccountData accountData7;
        k kVar5;
        ProgressBar progressBar;
        k kVar6;
        k kVar7;
        AccountData accountData8;
        String str;
        super.a((Object) atVar);
        this.f864a.c = null;
        if (atVar != null) {
            this.f864a.n = new AccountData();
            accountData = this.f864a.n;
            accountData.setAccount(atVar.a().getName());
            accountData2 = this.f864a.n;
            accountData2.setPassword("");
            accountData3 = this.f864a.n;
            accountData3.setID(atVar.a().getId());
            if (atVar.a().getBDUSS() != null) {
                StringBuilder append = new StringBuilder(String.valueOf(atVar.a().getBDUSS())).append("|");
                str = this.f864a.m;
                r0 = append.append(str).toString();
            }
            accountData4 = this.f864a.n;
            accountData4.setBDUSS(r0);
            accountData5 = this.f864a.n;
            accountData5.setIsActive(1);
            if (atVar.b() != null) {
                accountData8 = this.f864a.n;
                accountData8.setTbs(atVar.b().getTbs());
            }
            accountData6 = this.f864a.n;
            if (accountData6.getAccount() == null) {
                kVar = this.f864a.o;
                if (kVar == null) {
                    this.f864a.o = new k(this.f864a);
                    kVar6 = this.f864a.o;
                    kVar6.a(new aq(this));
                    kVar7 = this.f864a.o;
                    kVar7.b(new ar(this));
                }
                kVar2 = this.f864a.o;
                kVar2.e();
                kVar3 = this.f864a.o;
                kVar3.a("");
                kVar4 = this.f864a.o;
                accountData7 = this.f864a.n;
                kVar4.a(accountData7);
                kVar5 = this.f864a.o;
                kVar5.a();
                progressBar = this.f864a.j;
                progressBar.setVisibility(4);
                return;
            }
            this.f864a.l();
            return;
        }
        r0 = this.b != null ? this.b.h() : null;
        if (r0 == null) {
            r0 = this.f864a.getString(R.string.data_load_error);
        }
        this.f864a.a(1, r0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.i();
        }
        this.f864a.c = null;
    }
}
