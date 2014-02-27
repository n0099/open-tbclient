package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba extends BdAsyncTask<String, Integer, AccountData> {
    private volatile com.baidu.tieba.util.ba a = null;
    private String b;
    private String c;
    private String d;
    private az e;
    private boolean f;
    private boolean g;

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ AccountData a(String... strArr) {
        return d();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(AccountData accountData) {
        AccountData accountData2 = accountData;
        super.a((ba) accountData2);
        if (accountData2 != null) {
            this.e.a(accountData2);
            return;
        }
        String i = this.a != null ? this.a.i() : null;
        if (i == null) {
            i = TiebaApplication.g().b().getResources().getString(R.string.data_load_error);
        }
        this.e.a(this.b, i);
    }

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
    public final void b() {
        this.e.a(this.b);
    }

    private AccountData d() {
        AccountData accountData;
        o a;
        long nanoTime = System.nanoTime();
        this.a = new com.baidu.tieba.util.ba(String.valueOf(com.baidu.tieba.data.i.a) + "c/s/login");
        this.a.a("bdusstoken", String.valueOf(this.c) + "|" + this.d);
        this.a.a("channel_id", TiebaApplication.g().aQ());
        this.a.a("channel_uid", TiebaApplication.g().aP());
        this.a.c(false);
        String l = this.a.l();
        com.baidu.adp.lib.util.e.e("simon", "ReLoginModel", l);
        if (this.a.c()) {
            com.baidu.tieba.model.at atVar = new com.baidu.tieba.model.at();
            atVar.a(l);
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
            com.baidu.adp.lib.util.e.e(getClass().getName(), "doInBackground", "reLogin fail");
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

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void cancel() {
        super.cancel(true);
        if (this.a != null) {
            this.a.j();
        }
    }
}
