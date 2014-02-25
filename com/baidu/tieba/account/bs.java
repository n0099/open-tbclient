package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements ad {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.tieba.account.ad
    public void a(AccountData accountData) {
        az azVar;
        o a = a.a(accountData.getBDUSS());
        String account = accountData.getAccount();
        String str = a.a;
        String str2 = a.b;
        azVar = this.a.d;
        ay.a(account, str, str2, azVar, true);
    }
}
