package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ ReLoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ReLoginActivity reLoginActivity) {
        this.a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountData accountData;
        String str;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        accountData = this.a.m;
        if (accountData != null) {
            accountData2 = this.a.m;
            if (accountData2.getAccount() != null) {
                accountData3 = this.a.m;
                if (!accountData3.getAccount().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.a;
                    accountData4 = this.a.m;
                    reLoginActivity.a(accountData4);
                    return;
                }
            }
            this.a.n();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.a;
        str = this.a.p;
        reLoginActivity2.a(1, str);
    }
}
