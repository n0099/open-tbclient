package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c bDU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bDU = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long Wl;
        Handler handler5;
        Handler handler6;
        long Wj;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long Wl2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long Wj2;
        Handler handler13;
        boolean Wh;
        Handler handler14;
        Handler handler15;
        long Wj3;
        if (message.what == 2) {
            handler13 = this.bDU.mHandler;
            handler13.removeMessages(2);
            Wh = this.bDU.Wh();
            if (Wh) {
                this.bDU.wN = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.bDU.We();
                }
            }
            handler14 = this.bDU.mHandler;
            handler15 = this.bDU.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            Wj3 = this.bDU.Wj();
            handler14.sendMessageDelayed(obtainMessage, Wj3);
        }
        if (message.what == 1) {
            handler10 = this.bDU.mHandler;
            handler10.removeMessages(2);
            this.bDU.wN = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bDU.We();
            }
            handler11 = this.bDU.mHandler;
            handler12 = this.bDU.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            Wj2 = this.bDU.Wj();
            handler11.sendMessageDelayed(obtainMessage2, Wj2);
        }
        if (message.what == 3) {
            handler7 = this.bDU.mHandler;
            handler7.removeMessages(3);
            this.bDU.Wd();
            handler8 = this.bDU.mHandler;
            handler9 = this.bDU.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            Wl2 = this.bDU.Wl();
            handler8.sendMessageDelayed(obtainMessage3, Wl2);
        }
        if (message.what == 4) {
            handler = this.bDU.mHandler;
            handler.removeMessages(3);
            handler2 = this.bDU.mHandler;
            handler2.removeMessages(2);
            this.bDU.wN = System.currentTimeMillis();
            this.bDU.Wd();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bDU.We();
            }
            handler3 = this.bDU.mHandler;
            handler4 = this.bDU.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            Wl = this.bDU.Wl();
            handler3.sendMessageDelayed(obtainMessage4, Wl);
            handler5 = this.bDU.mHandler;
            handler6 = this.bDU.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            Wj = this.bDU.Wj();
            handler5.sendMessageDelayed(obtainMessage5, Wj);
        }
    }
}
