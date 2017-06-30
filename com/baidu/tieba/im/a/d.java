package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c dkm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dkm = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long auF;
        Handler handler5;
        Handler handler6;
        long auD;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long auF2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long auD2;
        Handler handler13;
        boolean auB;
        Handler handler14;
        Handler handler15;
        long auD3;
        if (message.what == 2) {
            handler13 = this.dkm.mHandler;
            handler13.removeMessages(2);
            auB = this.dkm.auB();
            if (auB) {
                this.dkm.xn = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.dkm.auy();
                }
            }
            handler14 = this.dkm.mHandler;
            handler15 = this.dkm.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            auD3 = this.dkm.auD();
            handler14.sendMessageDelayed(obtainMessage, auD3);
        }
        if (message.what == 1) {
            handler10 = this.dkm.mHandler;
            handler10.removeMessages(2);
            this.dkm.xn = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dkm.auy();
            }
            handler11 = this.dkm.mHandler;
            handler12 = this.dkm.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            auD2 = this.dkm.auD();
            handler11.sendMessageDelayed(obtainMessage2, auD2);
        }
        if (message.what == 3) {
            handler7 = this.dkm.mHandler;
            handler7.removeMessages(3);
            this.dkm.aux();
            handler8 = this.dkm.mHandler;
            handler9 = this.dkm.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            auF2 = this.dkm.auF();
            handler8.sendMessageDelayed(obtainMessage3, auF2);
        }
        if (message.what == 4) {
            handler = this.dkm.mHandler;
            handler.removeMessages(3);
            handler2 = this.dkm.mHandler;
            handler2.removeMessages(2);
            this.dkm.xn = System.currentTimeMillis();
            this.dkm.aux();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dkm.auy();
            }
            handler3 = this.dkm.mHandler;
            handler4 = this.dkm.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            auF = this.dkm.auF();
            handler3.sendMessageDelayed(obtainMessage4, auF);
            handler5 = this.dkm.mHandler;
            handler6 = this.dkm.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            auD = this.dkm.auD();
            handler5.sendMessageDelayed(obtainMessage5, auD);
        }
    }
}
