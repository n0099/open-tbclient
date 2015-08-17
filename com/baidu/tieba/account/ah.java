package com.baidu.tieba.account;

import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.view.l;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements l.a {
    final /* synthetic */ SapiFastRegActivity aFk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(SapiFastRegActivity sapiFastRegActivity) {
        this.aFk = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.l.a
    public void g(AccountData accountData) {
        this.aFk.aFi = RegisterActivityConfig.REGIST_USER;
        this.aFk.r(accountData);
    }
}
