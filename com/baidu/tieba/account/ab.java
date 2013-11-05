package com.baidu.tieba.account;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
import com.baidu.tieba.util.DatabaseService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements q {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LoginActivity f1014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(LoginActivity loginActivity) {
        this.f1014a = loginActivity;
    }

    @Override // com.baidu.tieba.account.q
    public void a(AccountData accountData) {
        AccountData accountData2;
        DatabaseService.a(accountData);
        accountData2 = this.f1014a.T;
        TiebaApplication.a(accountData2, this.f1014a.getBaseContext());
        this.f1014a.b();
    }
}
