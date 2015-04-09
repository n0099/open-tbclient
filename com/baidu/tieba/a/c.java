package com.baidu.tieba.a;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c extends BdAsyncTask<Object, Object, AccountData> {
    private final b bDN;
    private final String mAccount;
    private final String mPassword;

    public c(String str, String str2, b bVar) {
        this.mAccount = str;
        this.mPassword = str2;
        this.bDN = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: i */
    public AccountData doInBackground(Object... objArr) {
        AccountData aM;
        aM = a.aM(this.mAccount, this.mPassword);
        return aM;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    /* renamed from: m */
    public void onPostExecute(AccountData accountData) {
        super.onPostExecute(accountData);
        if (this.bDN != null) {
            if (accountData != null) {
                this.bDN.a(accountData);
            } else {
                this.bDN.eU(this.mAccount);
            }
        }
    }
}
