package com.baidu.tieba.account;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.model.be;
import com.baidu.tieba.util.bd;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar extends BdAsyncTask<String, Integer, be> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f1065a;
    private volatile com.baidu.tieba.util.am b;

    private ar(ReLoginShareActivity reLoginShareActivity) {
        this.f1065a = reLoginShareActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(ReLoginShareActivity reLoginShareActivity, aq aqVar) {
        this(reLoginShareActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        String str;
        ReLoginShareActivity reLoginShareActivity = this.f1065a;
        str = this.f1065a.g;
        reLoginShareActivity.a(0, str);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public be a(String... strArr) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        be beVar = null;
        long nanoTime = System.nanoTime();
        this.b = new com.baidu.tieba.util.am(com.baidu.tieba.data.h.f1248a + "c/s/login");
        com.baidu.tieba.util.am amVar = this.b;
        StringBuilder sb = new StringBuilder();
        str = this.f1065a.h;
        StringBuilder append = sb.append(str).append("|");
        str2 = this.f1065a.i;
        amVar.a("bdusstoken", append.append(str2).toString());
        this.b.a("channel_id", TiebaApplication.h().bc());
        this.b.a("channel_uid", TiebaApplication.h().bb());
        this.b.c(false);
        str3 = this.f1065a.h;
        bd.e("", "mBDUSS = ", str3);
        str4 = this.f1065a.i;
        bd.e("", "mPtoken = ", str4);
        String l = this.b.l();
        if (this.b.c()) {
            beVar = new be();
            beVar.a(l);
        } else {
            bd.e(getClass().getName(), "doInBackground", "relogin fail");
        }
        if (this.b.d() && this.b.e() == 1) {
            Token token = new Token();
            str5 = this.f1065a.h;
            token.mBduss = str5;
            str6 = this.f1065a.i;
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
        return beVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(be beVar) {
        AccountData accountData;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        AccountData accountData5;
        AccountData accountData6;
        AccountData accountData7;
        n nVar;
        n nVar2;
        n nVar3;
        n nVar4;
        AccountData accountData8;
        n nVar5;
        ProgressBar progressBar;
        n nVar6;
        n nVar7;
        AccountData accountData9;
        String str;
        super.a((ar) beVar);
        this.f1065a.b = null;
        if (beVar != null) {
            this.f1065a.j = new AccountData();
            accountData = this.f1065a.j;
            accountData.setAccount(beVar.a().getName());
            accountData2 = this.f1065a.j;
            accountData2.setPassword("");
            accountData3 = this.f1065a.j;
            accountData3.setID(beVar.a().getId());
            if (beVar.a().getBDUSS() != null) {
                StringBuilder append = new StringBuilder().append(beVar.a().getBDUSS()).append("|");
                str = this.f1065a.i;
                r0 = append.append(str).toString();
            }
            accountData4 = this.f1065a.j;
            accountData4.setBDUSS(r0);
            accountData5 = this.f1065a.j;
            accountData5.setPortrait(beVar.a().getPortrait());
            accountData6 = this.f1065a.j;
            accountData6.setIsActive(1);
            if (beVar.b() != null) {
                accountData9 = this.f1065a.j;
                accountData9.setTbs(beVar.b().getTbs());
            }
            accountData7 = this.f1065a.j;
            if (accountData7.getAccount() != null) {
                this.f1065a.e();
                return;
            }
            nVar = this.f1065a.k;
            if (nVar == null) {
                this.f1065a.k = new n(this.f1065a);
                nVar6 = this.f1065a.k;
                nVar6.a(new as(this));
                nVar7 = this.f1065a.k;
                nVar7.b(new at(this));
            }
            nVar2 = this.f1065a.k;
            nVar2.e();
            nVar3 = this.f1065a.k;
            nVar3.a("");
            nVar4 = this.f1065a.k;
            accountData8 = this.f1065a.j;
            nVar4.a(accountData8);
            nVar5 = this.f1065a.k;
            nVar5.a();
            progressBar = this.f1065a.f;
            progressBar.setVisibility(4);
            return;
        }
        r0 = this.b != null ? this.b.i() : null;
        if (r0 == null) {
            r0 = this.f1065a.getString(R.string.data_load_error);
        }
        this.f1065a.a(1, r0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.j();
        }
        this.f1065a.b = null;
    }
}
