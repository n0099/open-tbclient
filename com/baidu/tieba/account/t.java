package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class t extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ s auP;
    private final /* synthetic */ AccountData auQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, AccountData accountData) {
        this.auP = sVar;
        this.auQ = accountData;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public Void doInBackground(Void... voidArr) {
        p pVar;
        Activity activity;
        if (this.auQ != null) {
            com.baidu.tbadk.core.a.d.b(this.auQ);
            com.baidu.tbadk.core.a.d.c(this.auQ);
            TbadkCoreApplication.setBdussAndTbsFromBackgroundInRelogin(this.auQ, this.auQ.getBDUSS(), this.auQ.getTbs());
            AccountData accountData = this.auQ;
            pVar = this.auP.auM;
            activity = pVar.mActivity;
            TbadkCoreApplication.setCurrentAccount(accountData, activity);
        }
        return null;
    }
}
