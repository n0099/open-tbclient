package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class f extends Handler {
    final /* synthetic */ LogoActivity atC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LogoActivity logoActivity) {
        this.atC = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.atC.atu = true;
        z = this.atC.att;
        if (z) {
            if (!this.atC.getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.d.pG(), this.atC.getBaseContext());
            }
            this.atC.al(this.atC.getBaseContext());
        }
        super.handleMessage(message);
    }
}
