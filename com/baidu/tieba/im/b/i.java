package com.baidu.tieba.im.b;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class i extends Handler {
    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                b.c(b.SF()).removeMessages(2);
                b.SF().SK();
                return;
            case 3:
                b.c(b.SF()).removeMessages(3);
                if (b.d(b.SF()) == 3) {
                    b.SF().SL();
                } else {
                    b.SF().SK();
                }
                b.c(b.SF()).sendMessageDelayed(b.c(b.SF()).obtainMessage(3), b.e(b.SF()));
                return;
            default:
                return;
        }
    }
}
