package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c cWQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cWQ = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long apU;
        Handler handler5;
        Handler handler6;
        long apS;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long apU2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long apS2;
        Handler handler13;
        boolean apQ;
        Handler handler14;
        Handler handler15;
        long apS3;
        if (message.what == 2) {
            handler13 = this.cWQ.mHandler;
            handler13.removeMessages(2);
            apQ = this.cWQ.apQ();
            if (apQ) {
                this.cWQ.xn = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.cWQ.apN();
                }
            }
            handler14 = this.cWQ.mHandler;
            handler15 = this.cWQ.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            apS3 = this.cWQ.apS();
            handler14.sendMessageDelayed(obtainMessage, apS3);
        }
        if (message.what == 1) {
            handler10 = this.cWQ.mHandler;
            handler10.removeMessages(2);
            this.cWQ.xn = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cWQ.apN();
            }
            handler11 = this.cWQ.mHandler;
            handler12 = this.cWQ.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            apS2 = this.cWQ.apS();
            handler11.sendMessageDelayed(obtainMessage2, apS2);
        }
        if (message.what == 3) {
            handler7 = this.cWQ.mHandler;
            handler7.removeMessages(3);
            this.cWQ.apM();
            handler8 = this.cWQ.mHandler;
            handler9 = this.cWQ.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            apU2 = this.cWQ.apU();
            handler8.sendMessageDelayed(obtainMessage3, apU2);
        }
        if (message.what == 4) {
            handler = this.cWQ.mHandler;
            handler.removeMessages(3);
            handler2 = this.cWQ.mHandler;
            handler2.removeMessages(2);
            this.cWQ.xn = System.currentTimeMillis();
            this.cWQ.apM();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cWQ.apN();
            }
            handler3 = this.cWQ.mHandler;
            handler4 = this.cWQ.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            apU = this.cWQ.apU();
            handler3.sendMessageDelayed(obtainMessage4, apU);
            handler5 = this.cWQ.mHandler;
            handler6 = this.cWQ.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            apS = this.cWQ.apS();
            handler5.sendMessageDelayed(obtainMessage5, apS);
        }
    }
}
