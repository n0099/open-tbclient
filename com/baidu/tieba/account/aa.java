package com.baidu.tieba.account;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
class aa implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ SapiFastRegActivity afL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SapiFastRegActivity sapiFastRegActivity) {
        this.afL = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.afL.afK = "login_user";
            this.afL.h(accountData);
            return;
        }
        this.afL.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        this.afL.showToast(com.baidu.tieba.y.register_retry);
        LoginActivity.a((Activity) this.afL, (String) null, true, 11003);
        this.afL.finish();
    }
}
