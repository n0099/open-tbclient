package com.baidu.tieba;

import android.app.Application;
import com.baidu.tieba.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class av implements Runnable {
    private final /* synthetic */ AccountData a;
    private final /* synthetic */ Application b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(AccountData accountData, Application application) {
        this.a = accountData;
        this.b = application;
    }

    @Override // java.lang.Runnable
    public void run() {
        TiebaApplication.b(this.a, this.b);
    }
}
