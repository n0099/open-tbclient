package com.baidu.tieba.im.b;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class l extends Handler {
    private l() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ l(byte b) {
        this();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                a.c(a.c()).removeMessages(2);
                a.c().i();
                return;
            case 3:
                a.c(a.c()).removeMessages(3);
                a.c().i();
                a.c(a.c()).sendMessageDelayed(a.c(a.c()).obtainMessage(3), a.l(a.c()));
                return;
            default:
                return;
        }
    }
}
