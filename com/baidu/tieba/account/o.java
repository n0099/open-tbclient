package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class o extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ n aDR;
    private final /* synthetic */ AccountData aDS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, AccountData accountData) {
        this.aDR = nVar;
        this.aDS = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.aDS != null) {
            com.baidu.tbadk.core.a.b.b(this.aDS);
            com.baidu.tbadk.core.a.b.c(this.aDS);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.aDS, this.aDS.getBDUSS(), this.aDS.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.aDS, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
