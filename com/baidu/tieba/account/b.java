package com.baidu.tieba.account;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class b extends Handler {
    final /* synthetic */ AccountActivity awf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(AccountActivity accountActivity) {
        this.awf = accountActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                this.awf.EZ();
                return;
            case 2:
                this.awf.EY();
                return;
            default:
                return;
        }
    }
}
