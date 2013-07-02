package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class al implements o {
    final /* synthetic */ ReLoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ReLoginActivity reLoginActivity) {
        this.a = reLoginActivity;
    }

    @Override // com.baidu.tieba.account.o
    public void a(AccountData accountData) {
        this.a.finish();
    }
}
