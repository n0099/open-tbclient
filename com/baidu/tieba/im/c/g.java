package com.baidu.tieba.im.c;

import android.os.Handler;
import android.os.Message;
import com.baidu.tieba.im.messageCenter.IDuplicateProcess;
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
        int i;
        int i2;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        Handler handler5;
        Handler handler6;
        int i3;
        int i4;
        Handler handler7;
        Handler handler8;
        int i5;
        super.handleMessage(message);
        switch (message.what) {
            case 1:
                a.a().o();
                a a2 = a.a();
                IDuplicateProcess.RemoveState removeState = IDuplicateProcess.RemoveState.REMOVE_ME;
                i4 = a.g;
                a2.a(removeState, i4);
                handler7 = a.a().D;
                handler8 = a.a().D;
                Message obtainMessage = handler8.obtainMessage(1);
                i5 = a.a().j;
                handler7.sendMessageDelayed(obtainMessage, i5);
                return;
            case 2:
                handler3 = a.a().D;
                handler3.removeMessages(2);
                a.a().h();
                return;
            case 3:
                handler4 = a.a().D;
                handler4.removeMessages(3);
                a.a().h();
                handler5 = a.a().D;
                handler6 = a.a().D;
                Message obtainMessage2 = handler6.obtainMessage(3);
                i3 = a.a().k;
                handler5.sendMessageDelayed(obtainMessage2, i3);
                return;
            case 4:
                handler2 = a.a().D;
                handler2.removeMessages(4);
                a.a().a(false);
                return;
            case 5:
                com.baidu.adp.lib.h.d.c("----switchToBackground");
                handler = a.a().D;
                handler.removeMessages(5);
                a a3 = a.a();
                i = a.a().c;
                a3.j = i;
                a a4 = a.a();
                i2 = a.a().e;
                a4.k = i2;
                return;
            default:
                return;
        }
    }
}
