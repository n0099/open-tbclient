package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class g extends Handler {
    final /* synthetic */ LogoActivity alh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LogoActivity logoActivity) {
        this.alh = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.alh.akV = true;
        z = this.alh.akU;
        if (z) {
            if (!this.alh.getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.account.a.md(), this.alh.getBaseContext());
            }
            this.alh.ai(this.alh.getBaseContext());
        }
        super.handleMessage(message);
    }
}
