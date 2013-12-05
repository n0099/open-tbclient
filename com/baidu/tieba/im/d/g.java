package com.baidu.tieba.im.d;

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
                handler = a.a().r;
                handler.removeMessages(2);
                a.a().g();
                return;
            case 3:
                handler2 = a.a().r;
                handler2.removeMessages(3);
                a.a().g();
                handler3 = a.a().r;
                handler4 = a.a().r;
                Message obtainMessage = handler4.obtainMessage(3);
                i = a.a().e;
                handler3.sendMessageDelayed(obtainMessage, i);
                return;
            default:
                return;
        }
    }
}
