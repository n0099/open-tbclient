package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class c extends BdAsyncTask<Void, Void, AccountData> {
    final /* synthetic */ b a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.a = bVar;
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public AccountData a(Void... voidArr) {
        return DatabaseService.i(this.b);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AccountData accountData) {
        a aVar;
        boolean z;
        a aVar2;
        a aVar3;
        Activity activity;
        a aVar4;
        int i;
        a aVar5;
        at atVar;
        super.a((c) accountData);
        if (accountData == null || com.baidu.tieba.util.bs.c(accountData.getPassword())) {
            aVar = this.a.a;
            z = aVar.h;
            if (!z) {
                aVar2 = this.a.a;
                aVar3 = this.a.a;
                activity = aVar3.b;
                aVar4 = this.a.a;
                i = aVar4.c;
                aVar2.a(activity, i);
                return;
            }
            return;
        }
        String account = accountData.getAccount();
        String password = accountData.getPassword();
        aVar5 = this.a.a;
        atVar = aVar5.k;
        as.a(account, password, atVar);
    }
}
