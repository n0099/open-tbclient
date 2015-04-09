package com.baidu.tieba;

import android.os.Handler;
import android.os.Message;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
class f extends Handler {
    final /* synthetic */ LogoActivity atK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LogoActivity logoActivity) {
        this.atK = logoActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        boolean z;
        this.atK.atC = true;
        z = this.atK.atB;
        if (z) {
            if (!this.atK.getPageContext().getPageActivity().getDatabasePath(TbConfig.PHONE_DATEBASE_NAME).exists()) {
                TbadkCoreApplication.setCurrentAccount(com.baidu.tbadk.core.a.d.pG(), this.atK.getBaseContext());
            }
            this.atK.al(this.atK.getBaseContext());
        }
        super.handleMessage(message);
    }
}
