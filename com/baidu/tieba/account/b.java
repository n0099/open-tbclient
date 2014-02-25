package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements az {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.az
    public void a(String str) {
        k kVar;
        k kVar2;
        kVar = this.a.d;
        if (kVar != null) {
            kVar2 = this.a.d;
            kVar2.a(str);
        }
    }

    @Override // com.baidu.tieba.account.az
    public void a(AccountData accountData) {
        k kVar;
        k kVar2;
        kVar = this.a.d;
        if (kVar != null) {
            kVar2 = this.a.d;
            kVar2.a();
        }
    }

    @Override // com.baidu.tieba.account.az
    public void a(String str, String str2) {
        boolean z;
        Activity activity;
        z = this.a.e;
        if (!z) {
            activity = this.a.b;
            TiebaApplication.a((AccountData) null, activity);
        } else {
            this.a.b("logout_by_share");
        }
        c cVar = new c(this, str);
        cVar.setPriority(3);
        cVar.execute(new Object[0]);
    }
}
