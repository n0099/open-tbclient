package com.baidu.tieba.account;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements k.a {
    final /* synthetic */ SapiFastRegActivity aGg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SapiFastRegActivity sapiFastRegActivity) {
        this.aGg = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.k.a
    public void g(AccountData accountData) {
        this.aGg.aGe = RegisterActivityConfig.REGIST_USER;
        this.aGg.q(accountData);
    }
}
