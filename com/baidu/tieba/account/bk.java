package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class bk implements be {
    final /* synthetic */ ReLoginShareActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(ReLoginShareActivity reLoginShareActivity) {
        this.a = reLoginShareActivity;
    }

    @Override // com.baidu.tieba.account.be
    public void a(String str) {
        String str2;
        ReLoginShareActivity reLoginShareActivity = this.a;
        str2 = this.a.f;
        reLoginShareActivity.a(0, str2, null);
    }

    @Override // com.baidu.tieba.account.be
    public void a(AccountData accountData) {
        String str;
        if (accountData.getAccount() != null) {
            this.a.a(accountData);
            return;
        }
        ReLoginShareActivity reLoginShareActivity = this.a;
        str = this.a.f;
        reLoginShareActivity.a(2, str, accountData);
    }

    @Override // com.baidu.tieba.account.be
    public void a(String str, String str2) {
        l.a().b(str);
        this.a.a(1, str2, null);
    }
}
