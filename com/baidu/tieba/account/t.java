package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class t extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ s auX;
    private final /* synthetic */ AccountData auY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, AccountData accountData) {
        this.auX = sVar;
        this.auY = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        p pVar;
        Activity activity;
        if (this.auY != null) {
            com.baidu.tbadk.core.a.d.b(this.auY);
            com.baidu.tbadk.core.a.d.c(this.auY);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.auY, this.auY.getBDUSS(), this.auY.getTbs());
            AccountData accountData = this.auY;
            pVar = this.auX.auU;
            activity = pVar.mActivity;
            TbadkCoreApplication.setCurrentAccount(accountData, activity);
        }
        return null;
    }
}
