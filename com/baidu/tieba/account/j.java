package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.account.AccountActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ AccountActivity.a aPC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(AccountActivity.a aVar) {
        this.aPC = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountActivity accountActivity;
        AccountActivity accountActivity2;
        accountActivity = AccountActivity.this;
        TbadkCoreApplication.setCurrentAccount(null, accountActivity.getPageContext().getPageActivity());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_MATINTAB, null));
        accountActivity2 = AccountActivity.this;
        accountActivity2.finish();
    }
}
