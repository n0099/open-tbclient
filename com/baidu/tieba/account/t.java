package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class t extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ s awA;
    private final /* synthetic */ AccountData awB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, AccountData accountData) {
        this.awA = sVar;
        this.awB = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.awB != null) {
            com.baidu.tbadk.core.a.d.b(this.awB);
            com.baidu.tbadk.core.a.d.c(this.awB);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.awB, this.awB.getBDUSS(), this.awB.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.awB, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
