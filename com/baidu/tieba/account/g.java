package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements as {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.as
    public void a(AccountData accountData) {
        Activity activity;
        activity = this.a.b;
        TiebaApplication.a(accountData, activity);
        l.a().b();
        new h(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.account.as
    public void a(String str) {
        this.a.b();
    }
}
