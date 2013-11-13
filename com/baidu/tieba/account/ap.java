package com.baidu.tieba.account;

import android.widget.ProgressBar;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.model.be;
import com.baidu.tieba.util.bg;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap extends BdAsyncTask<String, Integer, be> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f1040a;
    private volatile com.baidu.tieba.util.ap b;

    private ap(ReLoginShareActivity reLoginShareActivity) {
        this.f1040a = reLoginShareActivity;
        this.b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ap(ReLoginShareActivity reLoginShareActivity, ao aoVar) {
        this(reLoginShareActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        String str;
        ReLoginShareActivity reLoginShareActivity = this.f1040a;
        str = this.f1040a.g;
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
        this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1196a + "c/s/login");
        com.baidu.tieba.util.ap apVar = this.b;
        StringBuilder sb = new StringBuilder();
        str = this.f1040a.h;
        StringBuilder append = sb.append(str).append("|");
        str2 = this.f1040a.i;
        apVar.a("bdusstoken", append.append(str2).toString());
        this.b.a("channel_id", TiebaApplication.g().ba());
        this.b.a("channel_uid", TiebaApplication.g().aZ());
        this.b.c(false);
        str3 = this.f1040a.h;
        bg.e("", "mBDUSS = ", str3);
        str4 = this.f1040a.i;
        bg.e("", "mPtoken = ", str4);
        String j = this.b.j();
        if (this.b.c()) {
            beVar = new be();
            beVar.a(j);
        } else {
            bg.e(getClass().getName(), "doInBackground", "relogin fail");
        }
        if (this.b.d() && this.b.e() == 1) {
            Token token = new Token();
            str5 = this.f1040a.h;
            token.mBduss = str5;
            str6 = this.f1040a.i;
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
        super.a((ap) beVar);
        this.f1040a.b = null;
        if (beVar != null) {
            this.f1040a.j = new AccountData();
            accountData = this.f1040a.j;
            accountData.setAccount(beVar.a().getName());
            accountData2 = this.f1040a.j;
            accountData2.setPassword("");
            accountData3 = this.f1040a.j;
            accountData3.setID(beVar.a().getId());
            if (beVar.a().getBDUSS() != null) {
                StringBuilder append = new StringBuilder().append(beVar.a().getBDUSS()).append("|");
                str = this.f1040a.i;
                r0 = append.append(str).toString();
            }
            accountData4 = this.f1040a.j;
            accountData4.setBDUSS(r0);
            accountData5 = this.f1040a.j;
            accountData5.setPortrait(beVar.a().getPortrait());
            accountData6 = this.f1040a.j;
            accountData6.setIsActive(1);
            if (beVar.b() != null) {
                accountData9 = this.f1040a.j;
                accountData9.setTbs(beVar.b().getTbs());
            }
            accountData7 = this.f1040a.j;
            if (accountData7.getAccount() != null) {
                this.f1040a.e();
                return;
            }
            lVar = this.f1040a.k;
            if (lVar == null) {
                this.f1040a.k = new l(this.f1040a);
                lVar6 = this.f1040a.k;
                lVar6.a(new aq(this));
                lVar7 = this.f1040a.k;
                lVar7.b(new ar(this));
            }
            lVar2 = this.f1040a.k;
            lVar2.e();
            lVar3 = this.f1040a.k;
            lVar3.a("");
            lVar4 = this.f1040a.k;
            accountData8 = this.f1040a.j;
            lVar4.a(accountData8);
            lVar5 = this.f1040a.k;
            lVar5.a();
            progressBar = this.f1040a.f;
            progressBar.setVisibility(4);
            return;
        }
        r0 = this.b != null ? this.b.g() : null;
        if (r0 == null) {
            r0 = this.f1040a.getString(R.string.data_load_error);
        }
        this.f1040a.a(1, r0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f1040a.b = null;
    }
}
