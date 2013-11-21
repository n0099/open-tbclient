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
public class aq extends BdAsyncTask<String, Integer, be> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginShareActivity f1054a;
    private volatile com.baidu.tieba.util.ap b;

    private aq(ReLoginShareActivity reLoginShareActivity) {
        this.f1054a = reLoginShareActivity;
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
        ReLoginShareActivity reLoginShareActivity = this.f1054a;
        str = this.f1054a.g;
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
        this.b = new com.baidu.tieba.util.ap(com.baidu.tieba.data.h.f1201a + "c/s/login");
        com.baidu.tieba.util.ap apVar = this.b;
        StringBuilder sb = new StringBuilder();
        str = this.f1054a.h;
        StringBuilder append = sb.append(str).append("|");
        str2 = this.f1054a.i;
        apVar.a("bdusstoken", append.append(str2).toString());
        this.b.a("channel_id", TiebaApplication.g().bb());
        this.b.a("channel_uid", TiebaApplication.g().ba());
        this.b.c(false);
        str3 = this.f1054a.h;
        bg.e("", "mBDUSS = ", str3);
        str4 = this.f1054a.i;
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
            str5 = this.f1054a.h;
            token.mBduss = str5;
            str6 = this.f1054a.i;
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
        m mVar;
        m mVar2;
        m mVar3;
        m mVar4;
        AccountData accountData8;
        m mVar5;
        ProgressBar progressBar;
        m mVar6;
        m mVar7;
        AccountData accountData9;
        String str;
        super.a((aq) beVar);
        this.f1054a.b = null;
        if (beVar != null) {
            this.f1054a.j = new AccountData();
            accountData = this.f1054a.j;
            accountData.setAccount(beVar.a().getName());
            accountData2 = this.f1054a.j;
            accountData2.setPassword("");
            accountData3 = this.f1054a.j;
            accountData3.setID(beVar.a().getId());
            if (beVar.a().getBDUSS() != null) {
                StringBuilder append = new StringBuilder().append(beVar.a().getBDUSS()).append("|");
                str = this.f1054a.i;
                r0 = append.append(str).toString();
            }
            accountData4 = this.f1054a.j;
            accountData4.setBDUSS(r0);
            accountData5 = this.f1054a.j;
            accountData5.setPortrait(beVar.a().getPortrait());
            accountData6 = this.f1054a.j;
            accountData6.setIsActive(1);
            if (beVar.b() != null) {
                accountData9 = this.f1054a.j;
                accountData9.setTbs(beVar.b().getTbs());
            }
            accountData7 = this.f1054a.j;
            if (accountData7.getAccount() != null) {
                this.f1054a.e();
                return;
            }
            mVar = this.f1054a.k;
            if (mVar == null) {
                this.f1054a.k = new m(this.f1054a);
                mVar6 = this.f1054a.k;
                mVar6.a(new ar(this));
                mVar7 = this.f1054a.k;
                mVar7.b(new as(this));
            }
            mVar2 = this.f1054a.k;
            mVar2.e();
            mVar3 = this.f1054a.k;
            mVar3.a("");
            mVar4 = this.f1054a.k;
            accountData8 = this.f1054a.j;
            mVar4.a(accountData8);
            mVar5 = this.f1054a.k;
            mVar5.a();
            progressBar = this.f1054a.f;
            progressBar.setVisibility(4);
            return;
        }
        r0 = this.b != null ? this.b.g() : null;
        if (r0 == null) {
            r0 = this.f1054a.getString(R.string.data_load_error);
        }
        this.f1054a.a(1, r0);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.b != null) {
            this.b.h();
        }
        this.f1054a.b = null;
    }
}
