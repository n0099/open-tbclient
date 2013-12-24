package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements be {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.be
    public void a(String str) {
    }

    @Override // com.baidu.tieba.account.be
    public void a(AccountData accountData) {
    }

    @Override // com.baidu.tieba.account.be
    public void a(String str, String str2) {
        boolean z;
        Activity activity;
        z = this.a.d;
        if (!z) {
            activity = this.a.b;
            TiebaApplication.a((AccountData) null, activity);
        } else {
            this.a.b("logout_by_share");
        }
        d dVar = new d(this, str);
        dVar.setPriority(3);
        dVar.execute(new Object[0]);
    }
}
