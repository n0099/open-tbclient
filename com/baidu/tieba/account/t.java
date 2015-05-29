package com.baidu.tieba.account;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class t extends BdAsyncTask<Void, Void, Void> {
    private final /* synthetic */ AccountData awA;
    final /* synthetic */ s awz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, AccountData accountData) {
        this.awz = sVar;
        this.awA = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        if (this.awA != null) {
            com.baidu.tbadk.core.a.d.b(this.awA);
            com.baidu.tbadk.core.a.d.c(this.awA);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.awA, this.awA.getBDUSS(), this.awA.getTbs());
            TbadkCoreApplication.setCurrentAccount(this.awA, TbadkCoreApplication.m411getInst().getApp());
        }
        return null;
    }
}
