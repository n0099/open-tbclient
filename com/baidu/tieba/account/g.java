package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.view.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements j.a {
    final /* synthetic */ AccountActivity aLu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AccountActivity accountActivity) {
        this.aLu = accountActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.j.a
    public void i(AccountData accountData) {
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CustomResponsedMessage(CmdConfigCustom.CMD_DELETE_ACCOUNT, TbadkCoreApplication.getCurrentAccount()));
        this.aLu.k(accountData);
    }
}
