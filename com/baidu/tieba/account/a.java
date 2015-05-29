package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.relogin.ReloginManager;
import com.baidu.tieba.tbadkCore.message.CancelDownloadMessage;
/* loaded from: classes.dex */
class a implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ AccountActivity awf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AccountActivity accountActivity) {
        this.awf = accountActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        TbadkCoreApplication.setCurrentAccount(accountData, this.awf.getBaseContext());
        this.awf.closeLoadingDialog();
        MessageManager.getInstance().dispatchResponsedMessageToUI(new CancelDownloadMessage(true));
        TbadkCoreApplication.m411getInst().onUserChanged();
        com.baidu.tbadk.core.c.b.a(this.awf.getPageContext().getPageActivity(), 1, false);
        this.awf.awd = null;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        this.awf.closeLoadingDialog();
        this.awf.showToast(str2);
        if (i == 1) {
            ReloginManager.sg().e(TbadkCoreApplication.getCurrentAccountObj());
        }
    }
}
