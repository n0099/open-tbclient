package com.baidu.tieba.im.c;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class j extends Handler {
    private j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(byte b) {
        this();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                b.a(b.a()).removeMessages(2);
                b.a().g();
                return;
            case 3:
                b.a(b.a()).removeMessages(3);
                b.a().g();
                b.a(b.a()).sendMessageDelayed(b.a(b.a()).obtainMessage(3), b.h(b.a()));
                return;
            default:
                return;
        }
    }
}
