package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class h extends Handler {
    final /* synthetic */ LogoActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LogoActivity logoActivity) {
        this.a = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.a.b = true;
        z = this.a.a;
        if (z) {
            if (!this.a.getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                TbadkApplication.setCurrentAccount(com.baidu.tbadk.core.account.a.c(), this.a.getBaseContext());
            }
            this.a.a(this.a.getBaseContext());
        }
        super.handleMessage(message);
    }
}
