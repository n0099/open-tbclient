package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.coreExtra.view.x {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.x
    public void a(AccountData accountData) {
        this.a.b = "regist_user";
        this.a.b(accountData);
    }
}
