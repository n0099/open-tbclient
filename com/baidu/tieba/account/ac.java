package com.baidu.tieba.account;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ SapiFastRegActivity aof;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SapiFastRegActivity sapiFastRegActivity) {
        this.aof = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.aof.aoe = "login_user";
            this.aof.i(accountData);
            return;
        }
        this.aof.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        this.aof.showToast(com.baidu.tieba.z.register_retry);
        this.aof.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aof.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.aof.finish();
    }
}
