package com.baidu.tbadk;

import android.content.Context;
import com.baidu.tbadk.core.data.AccountData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    private final /* synthetic */ AccountData a;
    private final /* synthetic */ Context b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(AccountData accountData, Context context) {
        this.a = accountData;
        this.b = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        TbadkApplication.setCurrentAccountInUI(this.a, this.b);
    }
}
