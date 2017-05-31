package com.baidu.tieba.account;

import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.account.AccountActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ AccountActivity.a aTB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AccountActivity.a aVar) {
        this.aTB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        accountActivity = AccountActivity.this;
        TbadkCoreApplication.setCurrentAccount(null, accountActivity.getPageContext().getPageActivity());
        accountActivity2 = AccountActivity.this;
        accountActivity2.finish();
    }
}
