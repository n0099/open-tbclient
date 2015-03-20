package com.baidu.tieba.account;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ai implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ SapiFastRegActivity awe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiFastRegActivity sapiFastRegActivity) {
        this.awe = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void bO(String str) {
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.awe.awd = RegisterActivityConfig.LOGIN_USER;
            this.awe.n(accountData);
            return;
        }
        this.awe.f(accountData);
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        this.awe.showToast(com.baidu.tieba.y.register_retry);
        this.awe.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.awe.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.awe.finish();
    }
}
