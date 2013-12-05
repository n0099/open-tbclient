package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ReLoginActivity f1046a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(ReLoginActivity reLoginActivity) {
        this.f1046a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountData accountData;
        String str;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        accountData = this.f1046a.i;
        if (accountData != null) {
            accountData2 = this.f1046a.i;
            if (accountData2.getAccount() != null) {
                accountData3 = this.f1046a.i;
                if (!accountData3.getAccount().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.f1046a;
                    accountData4 = this.f1046a.i;
                    reLoginActivity.a(accountData4);
                    return;
                }
            }
            this.f1046a.e();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.f1046a;
        str = this.f1046a.l;
        reLoginActivity2.a(1, str);
    }
}
