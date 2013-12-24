package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class aw implements Runnable {
    final /* synthetic */ ReLoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ReLoginActivity reLoginActivity) {
        this.a = reLoginActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        AccountData accountData;
        String str;
        AccountData accountData2;
        AccountData accountData3;
        AccountData accountData4;
        accountData = this.a.i;
        if (accountData != null) {
            accountData2 = this.a.i;
            if (accountData2.getAccount() != null) {
                accountData3 = this.a.i;
                if (!accountData3.getAccount().equals("BaiduUser")) {
                    ReLoginActivity reLoginActivity = this.a;
                    accountData4 = this.a.i;
                    reLoginActivity.a(accountData4);
                    return;
                }
            }
            this.a.e();
            return;
        }
        ReLoginActivity reLoginActivity2 = this.a;
        str = this.a.l;
        reLoginActivity2.a(1, str);
    }
}
