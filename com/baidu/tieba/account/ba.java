package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba extends BdAsyncTask<String, Integer, AccountData> {
    private volatile com.baidu.tieba.util.ba a = null;
    private String b;
    private String c;
    private String d;
    private az e;
    private boolean f;
    private boolean g;

    public ba(String str, String str2, String str3, az azVar, boolean z, boolean z2) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f = z;
        this.g = z2;
        this.e = azVar == null ? new bb(this) : azVar;
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
        o a;
        long nanoTime = System.nanoTime();
        this.a = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/login");
        this.a.a("bdusstoken", String.valueOf(this.c) + "|" + this.d);
        this.a.a("channel_id", TiebaApplication.g().aY());
        this.a.a("channel_uid", TiebaApplication.g().aX());
        this.a.c(false);
        String m = this.a.m();
        com.baidu.adp.lib.util.f.e("simon", "ReLoginModel", m);
        if (this.a.d()) {
            com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
            atVar.a(m);
            AccountData accountData2 = new AccountData();
            accountData2.setAccount(atVar.a().getUserName());
            accountData2.setPassword("");
            accountData2.setID(atVar.a().getUserId());
            String bduss = atVar.a().getBDUSS();
            if (this.g && (a = bt.a(a.a(bduss))) != null) {
                bduss = String.valueOf(a.a) + "|" + a.b;
            }
            accountData2.setBDUSS(bduss);
            accountData2.setPortrait(atVar.a().getPortrait());
            accountData2.setIsActive(1);
            if (atVar.b() != null) {
                accountData2.setTbs(atVar.b().getTbs());
                accountData = accountData2;
            } else {
                accountData = accountData2;
            }
        } else {
            com.baidu.adp.lib.util.f.e(getClass().getName(), "doInBackground", "reLogin fail");
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
        super.a((ba) accountData);
        if (accountData != null) {
            this.e.a(accountData);
            return;
        }
        String str = null;
        if (this.a != null) {
            str = this.a.j();
        }
        if (str == null) {
            str = TiebaApplication.g().b().getResources().getString(R.string.data_load_error);
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
