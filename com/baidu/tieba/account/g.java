package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class g extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ f a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, AccountData accountData) {
        this.a = fVar;
        this.b = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        DatabaseService.a(this.b);
        DatabaseService.b(this.b);
        return null;
    }
}
