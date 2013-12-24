package com.baidu.tieba.account;

import com.baidu.tieba.data.AccountData;
/* loaded from: classes.dex */
class bb implements ac {
    final /* synthetic */ ReLoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ReLoginActivity reLoginActivity) {
        this.a = reLoginActivity;
    }

    @Override // com.baidu.tieba.account.ac
    public void a(AccountData accountData) {
        this.a.finish();
    }
}
