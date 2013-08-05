package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f856a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ReLoginActivity reLoginActivity) {
        this.f856a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountData accountData;
        String str;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        accountData = this.f856a.m;
        if (accountData != null) {
            accountData2 = this.f856a.m;
            if (accountData2.getAccount() != null) {
                accountData3 = this.f856a.m;
                if (!accountData3.getAccount().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.f856a;
                    accountData4 = this.f856a.m;
                    reLoginActivity.a(accountData4);
                    return;
                }
            }
            this.f856a.l();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.f856a;
        str = this.f856a.p;
        reLoginActivity2.a(1, str);
    }
}
