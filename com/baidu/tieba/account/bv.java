package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
class bv extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ AccountData a;
    final /* synthetic */ bu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(bu buVar, AccountData accountData) {
        this.b = buVar;
        this.a = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void a(Void... voidArr) {
        DatabaseService.a(this.a);
        DatabaseService.b(this.a);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(Void r3) {
        this.b.a.setResult(-1);
        this.b.a.finish();
    }
}
