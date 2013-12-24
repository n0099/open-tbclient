package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at extends BdAsyncTask<Object, Object, AccountData> {
    private String a;
    private String b;
    private as c;

    public at(String str, String str2, as asVar) {
        this.a = str;
        this.b = str2;
        this.c = asVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: d */
    public AccountData a(Object... objArr) {
        AccountData b;
        b = ar.b(this.a, this.b);
        return b;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public void a(AccountData accountData) {
        super.a((at) accountData);
        if (this.c != null) {
            if (accountData != null) {
                this.c.a(accountData);
            } else {
                this.c.a(this.a);
            }
        }
    }
}
