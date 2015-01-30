package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ LogoActivity alk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.alk = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.alk.akY = true;
        z = this.alk.akX;
        if (z) {
            if (!this.alk.getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.account.a.mk(), this.alk.getBaseContext());
            }
            this.alk.ai(this.alk.getBaseContext());
        }
        super.handleMessage(message);
    }
}
