package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ LogoActivity acP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.acP = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.acP.acE = true;
        z = this.acP.acD;
        if (z) {
            if (!this.acP.getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                TbadkApplication.setCurrentAccount(com.baidu.tbadk.core.account.a.jA(), this.acP.getBaseContext());
            }
            this.acP.L(this.acP.getBaseContext());
        }
        super.handleMessage(message);
    }
}
