package com.baidu.tieba.im.c;

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
                b.a(b.Qy()).removeMessages(2);
                b.Qy().QE();
                return;
            case 3:
                b.a(b.Qy()).removeMessages(3);
                if (b.e(b.Qy()) == 3) {
                    b.Qy().QF();
                } else {
                    b.Qy().QE();
                }
                b.a(b.Qy()).sendMessageDelayed(b.a(b.Qy()).obtainMessage(3), b.f(b.Qy()));
                return;
            default:
                return;
        }
    }
}
