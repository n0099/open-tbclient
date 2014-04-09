package com.baidu.tieba.account;

import android.content.Intent;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
final class aj extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ ai a;
    private final /* synthetic */ AccountData b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ai aiVar, AccountData accountData) {
        this.a = aiVar;
        this.b = accountData;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ Void a(Void... voidArr) {
        return a();
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

    private Void a() {
        com.baidu.tbadk.core.a.o.a(this.b);
        com.baidu.tbadk.core.a.o.b(this.b);
        return null;
    }
}
