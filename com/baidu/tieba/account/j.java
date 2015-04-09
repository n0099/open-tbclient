package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AccountActivity auC;
    private AccountData mAccount;

    public j(AccountActivity accountActivity, AccountData accountData) {
        this.auC = accountActivity;
        this.mAccount = null;
        this.mAccount = accountData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void onPreExecute() {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public Boolean doInBackground(Object... objArr) {
        try {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            this.mAccount.setIsActive(1);
            com.baidu.tbadk.core.a.d.b(this.mAccount);
            com.baidu.tbadk.coreExtra.act.l um = com.baidu.tbadk.coreExtra.act.a.um();
            if (um != null) {
                um.i(this.mAccount);
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
        }
        return true;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        TbadkCoreApplication.setCurrentAccount(this.mAccount, this.auC.getBaseContext());
        if (this.mAccount != null) {
            new k(this.auC, this.mAccount.getBDUSS()).start();
        }
        this.auC.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m411getInst().onUserChanged();
        com.baidu.tbadk.core.c.b.a(this.auC.getPageContext().getPageActivity(), 1, false);
        this.auC.auA = null;
    }
}
