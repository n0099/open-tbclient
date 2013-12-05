package com.baidu.tieba.account;

import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.util.bd;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements AccountProxy.TokenCallback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1047a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(ReLoginActivity reLoginActivity) {
        this.f1047a = reLoginActivity;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        bd.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            this.f1047a.a(BaiduAccount.get(this.f1047a).getCurrentAccount(), str);
            return;
        }
        this.f1047a.finish();
    }
}
