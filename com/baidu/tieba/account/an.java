package com.baidu.tieba.account;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements ac {
    final /* synthetic */ LoginActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(LoginActivity loginActivity) {
        this.a = loginActivity;
    }

    @Override // com.baidu.tieba.account.ac
    public void a(AccountData accountData) {
        DatabaseService.a(accountData);
        TiebaApplication.a(accountData, this.a.getBaseContext());
        this.a.a();
    }
}
