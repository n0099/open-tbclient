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
                b.c(b.SS()).removeMessages(2);
                b.SS().SX();
                return;
            case 3:
                b.c(b.SS()).removeMessages(3);
                if (b.d(b.SS()) == 3) {
                    b.SS().SY();
                } else {
                    b.SS().SX();
                }
                b.c(b.SS()).sendMessageDelayed(b.c(b.SS()).obtainMessage(3), b.e(b.SS()));
                return;
            default:
                return;
        }
    }
}
