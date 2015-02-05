package com.baidu.tieba.account;

import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tbadk.coreExtra.view.y {
    final /* synthetic */ SapiFastRegActivity aoc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(SapiFastRegActivity sapiFastRegActivity) {
        this.aoc = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.coreExtra.view.y
    public void f(AccountData accountData) {
        this.aoc.aob = "regist_user";
        this.aoc.i(accountData);
    }
}
