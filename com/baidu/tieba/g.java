package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ LogoActivity acU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.acU = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.acU.acJ = true;
        z = this.acU.acI;
        if (z) {
            if (!this.acU.getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                TbadkApplication.setCurrentAccount(com.baidu.tbadk.core.account.a.jA(), this.acU.getBaseContext());
            }
            this.acU.L(this.acU.getBaseContext());
        }
        super.handleMessage(message);
    }
}
