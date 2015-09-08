package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.a.a;
/* loaded from: classes.dex */
class m extends BdAsyncTask<Void, Void, AccountData> {
    final /* synthetic */ l aFx;
    private final /* synthetic */ String aFy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar, String str) {
        this.aFx = lVar;
        this.aFy = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: g */
    public AccountData doInBackground(Void... voidArr) {
        return com.baidu.tbadk.core.a.b.ce(this.aFy);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: o */
    public void onPostExecute(AccountData accountData) {
        k kVar;
        a.InterfaceC0055a interfaceC0055a;
        super.onPostExecute(accountData);
        if (accountData != null && !aq.isEmpty(accountData.getPassword())) {
            String account = accountData.getAccount();
            String password = accountData.getPassword();
            kVar = this.aFx.aFw;
            interfaceC0055a = kVar.aFv;
            com.baidu.tieba.a.a.a(account, password, interfaceC0055a);
        }
    }
}
