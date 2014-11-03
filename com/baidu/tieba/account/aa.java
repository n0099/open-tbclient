package com.baidu.tieba.account;

import android.app.Activity;
import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.coreExtra.act.LoginActivity;
/* loaded from: classes.dex */
class aa implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ SapiFastRegActivity afT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(SapiFastRegActivity sapiFastRegActivity) {
        this.afT = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.afT.afS = "login_user";
            this.afT.h(accountData);
            return;
        }
        this.afT.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        this.afT.showToast(com.baidu.tieba.y.register_retry);
        LoginActivity.a((Activity) this.afT, (String) null, true, 11003);
        this.afT.finish();
    }
}
