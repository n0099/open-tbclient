package com.baidu.tieba.account;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ac implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ SapiFastRegActivity aoc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(SapiFastRegActivity sapiFastRegActivity) {
        this.aoc = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.aoc.aob = "login_user";
            this.aoc.i(accountData);
            return;
        }
        this.aoc.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        this.aoc.showToast(com.baidu.tieba.z.register_retry);
        this.aoc.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.aoc.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.aoc.finish();
    }
}
