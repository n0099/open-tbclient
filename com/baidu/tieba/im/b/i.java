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
                b.c(b.Ro()).removeMessages(2);
                b.Ro().Rt();
                return;
            case 3:
                b.c(b.Ro()).removeMessages(3);
                if (b.d(b.Ro()) == 3) {
                    b.Ro().Ru();
                } else {
                    b.Ro().Rt();
                }
                b.c(b.Ro()).sendMessageDelayed(b.c(b.Ro()).obtainMessage(3), b.e(b.Ro()));
                return;
            default:
                return;
        }
    }
}
