package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
final class g extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ f a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, AccountData accountData) {
        this.a = fVar;
        this.b = accountData;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Void a(Void... voidArr) {
        DatabaseService.a(this.b);
        DatabaseService.b(this.b);
        return null;
    }
}
