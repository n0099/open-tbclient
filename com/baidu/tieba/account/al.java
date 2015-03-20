package com.baidu.tieba.account;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements com.baidu.tbadk.coreExtra.view.x {
    final /* synthetic */ SapiFastRegActivity awe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(SapiFastRegActivity sapiFastRegActivity) {
        this.awe = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.x
    public void g(AccountData accountData) {
        this.awe.awd = RegisterActivityConfig.REGIST_USER;
        this.awe.n(accountData);
    }
}
