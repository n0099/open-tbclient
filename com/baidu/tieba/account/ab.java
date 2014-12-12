package com.baidu.tieba.account;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ab implements com.baidu.tbadk.core.account.g {
    final /* synthetic */ SapiFastRegActivity ank;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(SapiFastRegActivity sapiFastRegActivity) {
        this.ank = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onBeforeLogin(String str) {
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onSuccess(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.ank.anj = "login_user";
            this.ank.h(accountData);
            return;
        }
        this.ank.e(accountData);
    }

    @Override // com.baidu.tbadk.core.account.g
    public void onFailure(String str, int i, String str2) {
        this.ank.showToast(com.baidu.tieba.z.register_retry);
        this.ank.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.ank.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.ank.finish();
    }
}
