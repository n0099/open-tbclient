package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class i extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ h a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, AccountData accountData) {
        this.a = hVar;
        this.b = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        DatabaseService.i();
        DatabaseService.b(this.b);
        return null;
    }
}
