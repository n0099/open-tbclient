package com.baidu.tieba.account;

import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai implements AccountProxy.TokenCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f646a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ReLoginActivity reLoginActivity) {
        this.f646a = reLoginActivity;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        com.baidu.tieba.util.z.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            this.f646a.a(BaiduAccount.get(this.f646a).getCurrentAccount(), str);
            return;
        }
        this.f646a.finish();
    }
}
