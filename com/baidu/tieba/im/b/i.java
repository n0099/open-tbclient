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
                b.c(b.Rt()).removeMessages(2);
                b.Rt().Ry();
                return;
            case 3:
                b.c(b.Rt()).removeMessages(3);
                if (b.d(b.Rt()) == 3) {
                    b.Rt().Rz();
                } else {
                    b.Rt().Ry();
                }
                b.c(b.Rt()).sendMessageDelayed(b.c(b.Rt()).obtainMessage(3), b.e(b.Rt()));
                return;
            default:
                return;
        }
    }
}
