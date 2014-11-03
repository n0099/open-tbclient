package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.coreExtra.view.w {
    final /* synthetic */ SapiFastRegActivity afT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SapiFastRegActivity sapiFastRegActivity) {
        this.afT = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.w
    public void f(AccountData accountData) {
        this.afT.afS = "regist_user";
        this.afT.h(accountData);
    }
}
