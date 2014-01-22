package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.loginshare.Token;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BdAsyncTask<String, Integer, AccountData> {
    private volatile com.baidu.tieba.util.ax a = null;
    private String b;
    private String c;
    private String d;
    private be e;
    private boolean f;
    private boolean g;

    public bf(String str, String str2, String str3, be beVar, boolean z, boolean z2) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f = z;
        this.g = z2;
        this.e = beVar == null ? new bg(this) : beVar;
        setPriority(3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void b() {
        this.e.a(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AccountData a(String... strArr) {
        AccountData accountData;
        Token a;
        long nanoTime = System.nanoTime();
        this.a = new com.baidu.tieba.util.ax(com.baidu.tieba.data.h.a + "c/s/login");
        this.a.a("bdusstoken", this.c + "|" + this.d);
        this.a.a("channel_id", TiebaApplication.h().bb());
        this.a.a("channel_uid", TiebaApplication.h().ba());
        this.a.c(false);
        String m = this.a.m();
        com.baidu.adp.lib.g.e.e("simon", "ReLoginModel", m);
        if (this.a.d()) {
            com.baidu.tieba.model.be beVar = new com.baidu.tieba.model.be();
            beVar.a(m);
            AccountData accountData2 = new AccountData();
            accountData2.setAccount(beVar.a().getName());
            accountData2.setPassword("");
            accountData2.setID(beVar.a().getId());
            String bduss = beVar.a().getBDUSS();
            if (this.g && (a = bw.a(a.a(bduss))) != null) {
                bduss = a.mBduss + "|" + a.mPtoken;
            }
            accountData2.setBDUSS(bduss);
            accountData2.setPortrait(beVar.a().getPortrait());
            accountData2.setIsActive(1);
            if (beVar.b() != null) {
                accountData2.setTbs(beVar.b().getTbs());
            }
            accountData = accountData2;
        } else {
            com.baidu.adp.lib.g.e.e(getClass().getName(), "doInBackground", "reLogin fail");
            accountData = null;
        }
        if (this.f) {
            long nanoTime2 = 2000 - ((System.nanoTime() - nanoTime) / 1000000);
            if (nanoTime2 > 0 && nanoTime2 < 2000) {
                try {
                    Thread.sleep(nanoTime2);
                } catch (InterruptedException e) {
                }
            }
        }
        return accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AccountData accountData) {
        super.a((bf) accountData);
        if (accountData != null) {
            this.e.a(accountData);
            return;
        }
        String str = null;
        if (this.a != null) {
            str = this.a.j();
        }
        if (str == null) {
            str = TiebaApplication.h().getResources().getString(R.string.data_load_error);
        }
        this.e.a(this.b, str);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.a != null) {
            this.a.k();
        }
    }
}
