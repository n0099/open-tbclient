package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ LogoActivity akC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.akC = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.akC.aku = true;
        z = this.akC.akt;
        if (z) {
            if (!this.akC.getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.account.a.mk(), this.akC.getBaseContext());
            }
            this.akC.ai(this.akC.getBaseContext());
        }
        super.handleMessage(message);
    }
}
