package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.download.CancelDownloadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AccountActivity a;
    private AccountData b;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Boolean a(Object... objArr) {
        return a();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Boolean bool) {
        TbadkApplication.a(this.b, this.a.getBaseContext());
        if (this.b != null) {
            new k(this.a, this.b.getBDUSS()).start();
        }
        this.a.closeLoadingDialog();
        com.baidu.adp.framework.c.a().b(new CancelDownloadMessage(true));
        TbadkApplication.j();
        TbadkApplication.M();
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "stop"));
        com.baidu.adp.framework.c.a().a(new com.baidu.adp.framework.message.a(2006001, "start"));
        com.baidu.tbadk.core.d.b.a(this.a, 1, false);
        this.a.h = null;
    }

    public i(AccountActivity accountActivity, AccountData accountData) {
        this.a = accountActivity;
        this.b = null;
        this.b = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final void c() {
        this.a.showLoadingDialog(this.a.getString(com.baidu.tieba.a.k.account_logining), new j(this));
    }

    private Boolean a() {
        try {
            Thread.sleep(1000L);
            this.b.setIsActive(1);
            com.baidu.tbadk.core.a.o.a(this.b);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "", "doInBackground error = " + e.getMessage());
        }
        return true;
    }
}
