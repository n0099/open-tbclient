package com.baidu.tieba.account;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements com.baidu.tbadk.coreExtra.view.x {
    final /* synthetic */ SapiFastRegActivity axS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(SapiFastRegActivity sapiFastRegActivity) {
        this.axS = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.x
    public void g(AccountData accountData) {
        this.axS.axQ = RegisterActivityConfig.REGIST_USER;
        this.axS.o(accountData);
    }
}
