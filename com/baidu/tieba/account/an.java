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
    final /* synthetic */ SapiFastRegActivity axT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(SapiFastRegActivity sapiFastRegActivity) {
        this.axT = sapiFastRegActivity;
    }

    @Override // com.baidu.tbadk.core.a.b
    public void cb(String str) {
    }

    @Override // com.baidu.tbadk.core.a.b
    public void a(AccountData accountData) {
        if (!TextUtils.isEmpty(accountData.getAccount())) {
            this.axT.axR = RegisterActivityConfig.LOGIN_USER;
            this.axT.o(accountData);
            return;
        }
        this.axT.f(accountData);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: com.baidu.tieba.account.SapiFastRegActivity */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.baidu.tbadk.core.a.b
    public void c(String str, int i, String str2) {
        this.axT.showToast(com.baidu.tieba.t.register_retry);
        TbadkCoreApplication.m411getInst().login(this.axT.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig((Context) this.axT.getPageContext().getPageActivity(), (String) null, true, 11003)));
        this.axT.finish();
    }
}
