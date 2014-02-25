package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class e extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ d a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, AccountData accountData) {
        this.a = dVar;
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
