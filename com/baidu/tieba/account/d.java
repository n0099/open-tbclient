package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class d extends BdAsyncTask<Void, Void, AccountData> {
    final /* synthetic */ String a;
    final /* synthetic */ c b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, String str) {
        this.b = cVar;
        this.a = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AccountData a(Void... voidArr) {
        return DatabaseService.l(this.a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AccountData accountData) {
        boolean z;
        Activity activity;
        int i;
        as asVar;
        super.a((d) accountData);
        if (accountData == null || com.baidu.tieba.util.bc.c(accountData.getPassword())) {
            z = this.b.a.g;
            if (!z) {
                a aVar = this.b.a;
                activity = this.b.a.b;
                i = this.b.a.c;
                aVar.a(activity, i);
                return;
            }
            return;
        }
        String account = accountData.getAccount();
        String password = accountData.getPassword();
        asVar = this.b.a.j;
        ar.a(account, password, asVar);
    }
}
