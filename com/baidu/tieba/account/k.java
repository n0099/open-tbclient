package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends BdAsyncTask<Object, Integer, Boolean> {
    final /* synthetic */ AccountActivity awf;
    private AccountData mAccount;

    public k(AccountActivity accountActivity, AccountData accountData) {
        this.awf = accountActivity;
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
    /* renamed from: j */
    public Boolean doInBackground(Object... objArr) {
        try {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                BdLog.detailException(e);
            }
            this.mAccount.setIsActive(1);
            com.baidu.tbadk.core.a.d.b(this.mAccount);
            com.baidu.tbadk.coreExtra.act.l uV = com.baidu.tbadk.coreExtra.act.a.uV();
            if (uV != null) {
                uV.i(this.mAccount);
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
        com.baidu.tbadk.core.a.b bVar;
        com.baidu.tbadk.core.a.a qi = com.baidu.tbadk.core.a.a.qi();
        String account = this.mAccount.getAccount();
        String bduss = this.mAccount.getBDUSS();
        bVar = this.awf.SV;
        qi.a(account, bduss, "", bVar);
    }
}
