package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.slidingmenu.lib.R;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf extends BdAsyncTask<String, Integer, com.baidu.tieba.model.be> {
    private volatile com.baidu.tieba.util.an a = null;
    private String b;
    private String c;
    private String d;
    private be e;
    private boolean f;

    public bf(String str, String str2, String str3, be beVar, boolean z) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.f = z;
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
    public com.baidu.tieba.model.be a(String... strArr) {
        com.baidu.tieba.model.be beVar = null;
        long nanoTime = System.nanoTime();
        this.a = new com.baidu.tieba.util.an(com.baidu.tieba.data.h.a + "c/s/login");
        this.a.a("bdusstoken", this.c + "|" + this.d);
        this.a.a("channel_id", TiebaApplication.h().bc());
        this.a.a("channel_uid", TiebaApplication.h().bb());
        this.a.c(false);
        String l = this.a.l();
        if (this.a.c()) {
            beVar = new com.baidu.tieba.model.be();
            beVar.a(l);
        } else {
            com.baidu.tieba.util.be.e(getClass().getName(), "doInBackground", "reLogin fail");
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
        return beVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(com.baidu.tieba.model.be beVar) {
        super.a((bf) beVar);
        if (beVar != null) {
            AccountData accountData = new AccountData();
            accountData.setAccount(beVar.a().getName());
            accountData.setPassword("");
            accountData.setID(beVar.a().getId());
            accountData.setBDUSS(beVar.a().getBDUSS() != null ? beVar.a().getBDUSS() + "|" + this.d : null);
            accountData.setPortrait(beVar.a().getPortrait());
            accountData.setIsActive(1);
            if (beVar.b() != null) {
                accountData.setTbs(beVar.b().getTbs());
            }
            this.e.a(accountData);
            return;
        }
        String i = this.a != null ? this.a.i() : null;
        if (i == null) {
            i = TiebaApplication.h().getResources().getString(R.string.data_load_error);
        }
        this.e.a(this.b, i);
    }

    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void cancel() {
        super.cancel(true);
        if (this.a != null) {
            this.a.j();
        }
    }
}
