package com.baidu.tieba.account;

import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements AccountProxy.TokenCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f856a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ReLoginActivity reLoginActivity) {
        this.f856a = reLoginActivity;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        com.baidu.tieba.util.aj.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            this.f856a.a(BaiduAccount.get(this.f856a).getCurrentAccount(), str);
            return;
        }
        this.f856a.finish();
    }
}
