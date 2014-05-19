package com.baidu.tieba.account;

import com.baidu.tbadk.core.account.AccountLoginHelper;
/* loaded from: classes.dex */
class t implements AccountLoginHelper.LoginHelperCallBack {
    final /* synthetic */ NotLoginGuideActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(NotLoginGuideActivity notLoginGuideActivity) {
        this.a = notLoginGuideActivity;
    }

    @Override // com.baidu.tbadk.core.account.AccountLoginHelper.LoginHelperCallBack
    public void onSuccess() {
        this.a.b();
    }

    @Override // com.baidu.tbadk.core.account.AccountLoginHelper.LoginHelperCallBack
    public void onFail() {
    }

    @Override // com.baidu.tbadk.core.account.AccountLoginHelper.LoginHelperCallBack
    public void onBeforeLogin(String str) {
    }
}
