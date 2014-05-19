package com.baidu.tieba.account;

import android.text.TextUtils;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ SapiFastRegActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SapiFastRegActivity sapiFastRegActivity) {
        this.a = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.a.b = "login_user";
            this.a.b(accountData);
            return;
        }
        this.a.a(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, String str2) {
        this.a.showToast(str2);
    }
}
