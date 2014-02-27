package com.baidu.tieba.account;

import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* loaded from: classes.dex */
final class bo extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ bn a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bn bnVar, AccountData accountData) {
        this.a = bnVar;
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

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ void a(Void r4) {
        String str;
        Intent intent = new Intent();
        str = this.a.a.b;
        intent.putExtra("fast_reg_user_type", str);
        this.a.a.setResult(-1, intent);
        this.a.a.finish();
    }
}
