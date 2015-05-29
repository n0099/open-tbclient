package com.baidu.tieba.account;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.RegisterActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
class an implements com.baidu.tbadk.core.a.b {
    final /* synthetic */ SapiFastRegActivity axS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SapiFastRegActivity sapiFastRegActivity) {
        this.axS = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.axS.axQ = RegisterActivityConfig.LOGIN_USER;
            this.axS.o(accountData);
            return;
        }
        this.axS.f(accountData);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.account.SapiFastRegActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        this.axS.showToast(com.baidu.tieba.t.register_retry);
        TbadkCoreApplication.m411getInst().login(this.axS.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.axS.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.axS.finish();
    }
}
