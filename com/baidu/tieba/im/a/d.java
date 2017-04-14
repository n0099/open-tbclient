package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c daw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.daw = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long arZ;
        Handler handler5;
        Handler handler6;
        long arX;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long arZ2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long arX2;
        Handler handler13;
        boolean arV;
        Handler handler14;
        Handler handler15;
        long arX3;
        if (message.what == 2) {
            handler13 = this.daw.mHandler;
            handler13.removeMessages(2);
            arV = this.daw.arV();
            if (arV) {
                this.daw.xj = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.daw.arS();
                }
            }
            handler14 = this.daw.mHandler;
            handler15 = this.daw.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            arX3 = this.daw.arX();
            handler14.sendMessageDelayed(obtainMessage, arX3);
        }
        if (message.what == 1) {
            handler10 = this.daw.mHandler;
            handler10.removeMessages(2);
            this.daw.xj = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.daw.arS();
            }
            handler11 = this.daw.mHandler;
            handler12 = this.daw.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            arX2 = this.daw.arX();
            handler11.sendMessageDelayed(obtainMessage2, arX2);
        }
        if (message.what == 3) {
            handler7 = this.daw.mHandler;
            handler7.removeMessages(3);
            this.daw.arR();
            handler8 = this.daw.mHandler;
            handler9 = this.daw.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            arZ2 = this.daw.arZ();
            handler8.sendMessageDelayed(obtainMessage3, arZ2);
        }
        if (message.what == 4) {
            handler = this.daw.mHandler;
            handler.removeMessages(3);
            handler2 = this.daw.mHandler;
            handler2.removeMessages(2);
            this.daw.xj = System.currentTimeMillis();
            this.daw.arR();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.daw.arS();
            }
            handler3 = this.daw.mHandler;
            handler4 = this.daw.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            arZ = this.daw.arZ();
            handler3.sendMessageDelayed(obtainMessage4, arZ);
            handler5 = this.daw.mHandler;
            handler6 = this.daw.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            arX = this.daw.arX();
            handler5.sendMessageDelayed(obtainMessage5, arX);
        }
    }
}
