package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.coreExtra.view.y {
    final /* synthetic */ SapiFastRegActivity aof;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SapiFastRegActivity sapiFastRegActivity) {
        this.aof = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.y
    public void f(AccountData accountData) {
        this.aof.aoe = "regist_user";
        this.aof.i(accountData);
    }
}
