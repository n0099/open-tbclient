package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class ah implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f891a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ReLoginActivity reLoginActivity) {
        this.f891a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountData accountData;
        String str;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        accountData = this.f891a.m;
        if (accountData != null) {
            accountData2 = this.f891a.m;
            if (accountData2.getAccount() != null) {
                accountData3 = this.f891a.m;
                if (!accountData3.getAccount().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.f891a;
                    accountData4 = this.f891a.m;
                    reLoginActivity.a(accountData4);
                    return;
                }
            }
            this.f891a.m();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.f891a;
        str = this.f891a.p;
        reLoginActivity2.a(1, str);
    }
}
