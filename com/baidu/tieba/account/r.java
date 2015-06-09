package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.bb;
/* loaded from: classes.dex */
class r extends BdAsyncTask<Void, Void, AccountData> {
    final /* synthetic */ q awy;
    private final /* synthetic */ String awz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, String str) {
        this.awy = qVar;
        this.awz = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: e */
    public AccountData doInBackground(Void... voidArr) {
        return com.baidu.tbadk.core.a.d.cd(this.awz);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(AccountData accountData) {
        p pVar;
        com.baidu.tieba.a.b bVar;
        super.onPostExecute(accountData);
        if (accountData != null && !bb.isEmpty(accountData.getPassword())) {
            String account = accountData.getAccount();
            String password = accountData.getPassword();
            pVar = this.awy.awx;
            bVar = pVar.aww;
            com.baidu.tieba.a.a.a(account, password, bVar);
        }
    }
}
