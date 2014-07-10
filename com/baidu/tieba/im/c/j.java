package com.baidu.tieba.im.c;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class j extends Handler {
    private j() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ j(j jVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                b.a(b.b()).removeMessages(2);
                b.b().h();
                return;
            case 3:
                b.a(b.b()).removeMessages(3);
                b.b().h();
                b.a(b.b()).sendMessageDelayed(b.a(b.b()).obtainMessage(3), b.h(b.b()));
                return;
            default:
                return;
        }
    }
}
