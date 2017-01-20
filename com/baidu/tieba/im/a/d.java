package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c cZH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cZH = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long asL;
        Handler handler5;
        Handler handler6;
        long asJ;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long asL2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long asJ2;
        Handler handler13;
        boolean asH;
        Handler handler14;
        Handler handler15;
        long asJ3;
        if (message.what == 2) {
            handler13 = this.cZH.mHandler;
            handler13.removeMessages(2);
            asH = this.cZH.asH();
            if (asH) {
                this.cZH.qm = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.cZH.asE();
                }
            }
            handler14 = this.cZH.mHandler;
            handler15 = this.cZH.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            asJ3 = this.cZH.asJ();
            handler14.sendMessageDelayed(obtainMessage, asJ3);
        }
        if (message.what == 1) {
            handler10 = this.cZH.mHandler;
            handler10.removeMessages(2);
            this.cZH.qm = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cZH.asE();
            }
            handler11 = this.cZH.mHandler;
            handler12 = this.cZH.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            asJ2 = this.cZH.asJ();
            handler11.sendMessageDelayed(obtainMessage2, asJ2);
        }
        if (message.what == 3) {
            handler7 = this.cZH.mHandler;
            handler7.removeMessages(3);
            this.cZH.asD();
            handler8 = this.cZH.mHandler;
            handler9 = this.cZH.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            asL2 = this.cZH.asL();
            handler8.sendMessageDelayed(obtainMessage3, asL2);
        }
        if (message.what == 4) {
            handler = this.cZH.mHandler;
            handler.removeMessages(3);
            handler2 = this.cZH.mHandler;
            handler2.removeMessages(2);
            this.cZH.qm = System.currentTimeMillis();
            this.cZH.asD();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cZH.asE();
            }
            handler3 = this.cZH.mHandler;
            handler4 = this.cZH.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            asL = this.cZH.asL();
            handler3.sendMessageDelayed(obtainMessage4, asL);
            handler5 = this.cZH.mHandler;
            handler6 = this.cZH.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            asJ = this.cZH.asJ();
            handler5.sendMessageDelayed(obtainMessage5, asJ);
        }
    }
}
