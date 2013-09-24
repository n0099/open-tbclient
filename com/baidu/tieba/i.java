package com.baidu.tieba;

import android.app.Activity;
import com.baidu.account.AccountProxy;
import com.baidu.tieba.BaiduAccount.BaiduAccount;
import com.baidu.tieba.account.ReLoginActivity;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements AccountProxy.TokenCallback {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Activity f1234a;
    private final /* synthetic */ int b;
    private final /* synthetic */ int c;
    private final /* synthetic */ boolean d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Activity activity, int i, int i2, boolean z) {
        this.f1234a = activity;
        this.b = i;
        this.c = i2;
        this.d = z;
    }

    @Override // com.baidu.account.AccountProxy.TokenCallback
    public void callBack(String str) {
        com.baidu.tieba.util.av.e("BaiduAccountProxy", "getAccountData", "token = " + str);
        if (str != null) {
            BaiduAccount baiduAccount = BaiduAccount.get(this.f1234a);
            AccountData accountData = new AccountData();
            accountData.setAccount(baiduAccount.getCurrentAccount());
            accountData.setBDUSS(str);
            accountData.setIsActive(1);
            ReLoginActivity.a(this.f1234a, this.b, this.c, this.d, accountData);
        } else if ((this.f1234a instanceof GuideActivity) || (this.f1234a instanceof LogoActivity)) {
            this.f1234a.finish();
        }
    }
}
