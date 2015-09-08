package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class o extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ AccountData aFA;
    final /* synthetic */ n aFz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, AccountData accountData) {
        this.aFz = nVar;
        this.aFA = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.aFA != null) {
            com.baidu.tbadk.core.a.b.b(this.aFA);
            com.baidu.tbadk.core.a.b.c(this.aFA);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.aFA, this.aFA.getBDUSS(), this.aFA.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.aFA, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
