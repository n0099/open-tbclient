package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.coreExtra.view.y {
    final /* synthetic */ SapiFastRegActivity ank;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(SapiFastRegActivity sapiFastRegActivity) {
        this.ank = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.y
    public void f(AccountData accountData) {
        this.ank.anj = "regist_user";
        this.ank.h(accountData);
    }
}
