package com.baidu.tieba.account;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.model.bd;
import com.baidu.tieba.util.be;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq extends BdAsyncTask<String, Integer, bd> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f1029a;
    private volatile com.baidu.tieba.util.ag b;

    private aq(ReLoginShareActivity reLoginShareActivity) {
        this.f1029a = reLoginShareActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aq(ReLoginShareActivity reLoginShareActivity, ap apVar) {
        this(reLoginShareActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        String str;
        ReLoginShareActivity reLoginShareActivity = this.f1029a;
        str = this.f1029a.k;
        reLoginShareActivity.a(0, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public bd a(String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        bd bdVar = null;
        long nanoTime = System.nanoTime();
        this.b = new com.baidu.tieba.util.ag(com.baidu.tieba.data.h.f1165a + "c/s/login");
        com.baidu.tieba.util.ag agVar = this.b;
        StringBuilder sb = new StringBuilder();
        str = this.f1029a.l;
        StringBuilder append = sb.append(str).append("|");
        str2 = this.f1029a.m;
        agVar.a("bdusstoken", append.append(str2).toString());
        this.b.a("channel_id", TiebaApplication.g().bg());
        this.b.a("channel_uid", TiebaApplication.g().bf());
        this.b.c(false);
        str3 = this.f1029a.l;
        be.e("", "mBDUSS = ", str3);
        str4 = this.f1029a.m;
        be.e("", "mPtoken = ", str4);
        String j = this.b.j();
        if (this.b.c()) {
            bdVar = new bd();
            bdVar.a(j);
        } else {
            be.e(getClass().getName(), "doInBackground", "relogin fail");
        }
        if (this.b.d() && this.b.e() == 1) {
            Token token = new Token();
            str5 = this.f1029a.l;
            token.mBduss = str5;
            str6 = this.f1029a.m;
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
        return bdVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(bd bdVar) {
        AccountData accountData;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        AccountData accountData5;
        AccountData accountData6;
        AccountData accountData7;
        l lVar;
        l lVar2;
        l lVar3;
        l lVar4;
        AccountData accountData8;
        l lVar5;
        ProgressBar progressBar;
        l lVar6;
        l lVar7;
        AccountData accountData9;
        String str;
        super.a((aq) bdVar);
        this.f1029a.c = null;
        if (bdVar != null) {
            this.f1029a.n = new AccountData();
            accountData = this.f1029a.n;
            accountData.setAccount(bdVar.a().getName());
            accountData2 = this.f1029a.n;
            accountData2.setPassword("");
            accountData3 = this.f1029a.n;
            accountData3.setID(bdVar.a().getId());
            if (bdVar.a().getBDUSS() != null) {
                StringBuilder append = new StringBuilder().append(bdVar.a().getBDUSS()).append("|");
                str = this.f1029a.m;
                r0 = append.append(str).toString();
            }
            accountData4 = this.f1029a.n;
            accountData4.setBDUSS(r0);
            accountData5 = this.f1029a.n;
            accountData5.setPortrait(bdVar.a().getPortrait());
            accountData6 = this.f1029a.n;
            accountData6.setIsActive(1);
            if (bdVar.b() != null) {
                accountData9 = this.f1029a.n;
                accountData9.setTbs(bdVar.b().getTbs());
            }
            accountData7 = this.f1029a.n;
            if (accountData7.getAccount() != null) {
                this.f1029a.f();
                return;
            }
            lVar = this.f1029a.o;
            if (lVar == null) {
                this.f1029a.o = new l(this.f1029a);
                lVar6 = this.f1029a.o;
                lVar6.a(new ar(this));
                lVar7 = this.f1029a.o;
                lVar7.b(new as(this));
            }
            lVar2 = this.f1029a.o;
            lVar2.e();
            lVar3 = this.f1029a.o;
            lVar3.a("");
            lVar4 = this.f1029a.o;
            accountData8 = this.f1029a.n;
            lVar4.a(accountData8);
            lVar5 = this.f1029a.o;
            lVar5.a();
            progressBar = this.f1029a.j;
            progressBar.setVisibility(4);
            return;
        }
        r0 = this.b != null ? this.b.g() : null;
        if (r0 == null) {
            r0 = this.f1029a.getString(R.string.data_load_error);
        }
        this.f1029a.a(1, r0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f1029a.c = null;
    }
}
