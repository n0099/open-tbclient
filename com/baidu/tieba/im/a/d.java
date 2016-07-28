package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c cUO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cUO = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long apW;
        Handler handler5;
        Handler handler6;
        long apU;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long apW2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long apU2;
        Handler handler13;
        boolean apS;
        Handler handler14;
        Handler handler15;
        long apU3;
        if (message.what == 2) {
            handler13 = this.cUO.mHandler;
            handler13.removeMessages(2);
            apS = this.cUO.apS();
            if (apS) {
                this.cUO.nX = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.cUO.apP();
                }
            }
            handler14 = this.cUO.mHandler;
            handler15 = this.cUO.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            apU3 = this.cUO.apU();
            handler14.sendMessageDelayed(obtainMessage, apU3);
        }
        if (message.what == 1) {
            handler10 = this.cUO.mHandler;
            handler10.removeMessages(2);
            this.cUO.nX = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cUO.apP();
            }
            handler11 = this.cUO.mHandler;
            handler12 = this.cUO.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            apU2 = this.cUO.apU();
            handler11.sendMessageDelayed(obtainMessage2, apU2);
        }
        if (message.what == 3) {
            handler7 = this.cUO.mHandler;
            handler7.removeMessages(3);
            this.cUO.apO();
            handler8 = this.cUO.mHandler;
            handler9 = this.cUO.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            apW2 = this.cUO.apW();
            handler8.sendMessageDelayed(obtainMessage3, apW2);
        }
        if (message.what == 4) {
            handler = this.cUO.mHandler;
            handler.removeMessages(3);
            handler2 = this.cUO.mHandler;
            handler2.removeMessages(2);
            this.cUO.nX = System.currentTimeMillis();
            this.cUO.apO();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cUO.apP();
            }
            handler3 = this.cUO.mHandler;
            handler4 = this.cUO.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            apW = this.cUO.apW();
            handler3.sendMessageDelayed(obtainMessage4, apW);
            handler5 = this.cUO.mHandler;
            handler6 = this.cUO.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            apU = this.cUO.apU();
            handler5.sendMessageDelayed(obtainMessage5, apU);
        }
    }
}
