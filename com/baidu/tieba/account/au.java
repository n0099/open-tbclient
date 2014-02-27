package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class au extends BdAsyncTask<Object, Object, AccountData> {
    private String a;
    private String b;
    private at c;

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ AccountData a(Object... objArr) {
        AccountData b;
        b = as.b(this.a, this.b);
        return b;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* bridge */ /* synthetic */ void a(AccountData accountData) {
        AccountData accountData2 = accountData;
        super.a((au) accountData2);
        if (this.c != null) {
            if (accountData2 != null) {
                this.c.a(accountData2);
                return;
            }
            at atVar = this.c;
            String str = this.a;
            atVar.a();
        }
    }

    public au(String str, String str2, at atVar) {
        this.a = str;
        this.b = str2;
        this.c = atVar;
    }
}
