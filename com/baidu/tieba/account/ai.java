package com.baidu.tieba.account;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class ai implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ SapiFastRegActivity awm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(SapiFastRegActivity sapiFastRegActivity) {
        this.awm = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void bO(String str) {
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.awm.awl = RegisterActivityConfig.LOGIN_USER;
            this.awm.n(accountData);
            return;
        }
        this.awm.f(accountData);
    }

    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        this.awm.showToast(com.baidu.tieba.y.register_retry);
        this.awm.sendMessage(new CustomMessage(2002001, new LoginActivityConfig((Context) this.awm.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.awm.finish();
    }
}
