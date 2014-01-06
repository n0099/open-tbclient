package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.tieba.MainTabActivity;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements as {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(a aVar) {
        this.a = aVar;
    }

    @Override // com.baidu.tieba.account.as
    public void a(AccountData accountData) {
        Activity activity;
        Activity activity2;
        Activity activity3;
        int i;
        activity = this.a.b;
        TiebaApplication.a(accountData, activity);
        activity2 = this.a.b;
        if (activity2 != null) {
            activity3 = this.a.b;
            i = this.a.c;
            MainTabActivity.c(activity3, i);
        }
        new f(this, accountData).execute(new Void[0]);
    }

    @Override // com.baidu.tieba.account.as
    public void a(String str) {
        boolean z;
        Activity activity;
        int i;
        z = this.a.g;
        if (!z) {
            a aVar = this.a;
            activity = this.a.b;
            i = this.a.c;
            aVar.a(activity, i);
        }
    }
}
