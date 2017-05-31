package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c dco;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dco = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long aqU;
        Handler handler5;
        Handler handler6;
        long aqS;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long aqU2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long aqS2;
        Handler handler13;
        boolean aqQ;
        Handler handler14;
        Handler handler15;
        long aqS3;
        if (message.what == 2) {
            handler13 = this.dco.mHandler;
            handler13.removeMessages(2);
            aqQ = this.dco.aqQ();
            if (aqQ) {
                this.dco.xn = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.dco.aqN();
                }
            }
            handler14 = this.dco.mHandler;
            handler15 = this.dco.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            aqS3 = this.dco.aqS();
            handler14.sendMessageDelayed(obtainMessage, aqS3);
        }
        if (message.what == 1) {
            handler10 = this.dco.mHandler;
            handler10.removeMessages(2);
            this.dco.xn = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dco.aqN();
            }
            handler11 = this.dco.mHandler;
            handler12 = this.dco.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            aqS2 = this.dco.aqS();
            handler11.sendMessageDelayed(obtainMessage2, aqS2);
        }
        if (message.what == 3) {
            handler7 = this.dco.mHandler;
            handler7.removeMessages(3);
            this.dco.aqM();
            handler8 = this.dco.mHandler;
            handler9 = this.dco.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            aqU2 = this.dco.aqU();
            handler8.sendMessageDelayed(obtainMessage3, aqU2);
        }
        if (message.what == 4) {
            handler = this.dco.mHandler;
            handler.removeMessages(3);
            handler2 = this.dco.mHandler;
            handler2.removeMessages(2);
            this.dco.xn = System.currentTimeMillis();
            this.dco.aqM();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dco.aqN();
            }
            handler3 = this.dco.mHandler;
            handler4 = this.dco.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            aqU = this.dco.aqU();
            handler3.sendMessageDelayed(obtainMessage4, aqU);
            handler5 = this.dco.mHandler;
            handler6 = this.dco.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            aqS = this.dco.aqS();
            handler5.sendMessageDelayed(obtainMessage5, aqS);
        }
    }
}
