package com.baidu.tieba.im.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends Handler {
    private g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ g(b bVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        int i;
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                handler = a.c().p;
                handler.removeMessages(2);
                a.c().i();
                return;
            case 3:
                handler2 = a.c().p;
                handler2.removeMessages(3);
                a.c().i();
                handler3 = a.c().p;
                handler4 = a.c().p;
                Message obtainMessage = handler4.obtainMessage(3);
                i = a.c().e;
                handler3.sendMessageDelayed(obtainMessage, i);
                return;
            default:
                return;
        }
    }
}
