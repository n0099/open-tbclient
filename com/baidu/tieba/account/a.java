package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ AccountActivity awg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AccountActivity accountActivity) {
        this.awg = accountActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        TbadkCoreApplication.setCurrentAccount(accountData, this.awg.getBaseContext());
        this.awg.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m411getInst().onUserChanged();
        com.baidu.tbadk.core.c.b.a(this.awg.getPageContext().getPageActivity(), 1, false);
        this.awg.awe = null;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        this.awg.closeLoadingDialog();
        this.awg.showToast(str2);
        if (i == 1) {
            ReloginManager.sg().e(TbadkCoreApplication.getCurrentAccountObj());
        }
    }
}
