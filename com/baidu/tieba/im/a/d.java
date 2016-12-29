package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c cSz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cSz = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long arF;
        Handler handler5;
        Handler handler6;
        long arD;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long arF2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long arD2;
        Handler handler13;
        boolean arB;
        Handler handler14;
        Handler handler15;
        long arD3;
        if (message.what == 2) {
            handler13 = this.cSz.mHandler;
            handler13.removeMessages(2);
            arB = this.cSz.arB();
            if (arB) {
                this.cSz.qt = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.cSz.ary();
                }
            }
            handler14 = this.cSz.mHandler;
            handler15 = this.cSz.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            arD3 = this.cSz.arD();
            handler14.sendMessageDelayed(obtainMessage, arD3);
        }
        if (message.what == 1) {
            handler10 = this.cSz.mHandler;
            handler10.removeMessages(2);
            this.cSz.qt = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cSz.ary();
            }
            handler11 = this.cSz.mHandler;
            handler12 = this.cSz.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            arD2 = this.cSz.arD();
            handler11.sendMessageDelayed(obtainMessage2, arD2);
        }
        if (message.what == 3) {
            handler7 = this.cSz.mHandler;
            handler7.removeMessages(3);
            this.cSz.arx();
            handler8 = this.cSz.mHandler;
            handler9 = this.cSz.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            arF2 = this.cSz.arF();
            handler8.sendMessageDelayed(obtainMessage3, arF2);
        }
        if (message.what == 4) {
            handler = this.cSz.mHandler;
            handler.removeMessages(3);
            handler2 = this.cSz.mHandler;
            handler2.removeMessages(2);
            this.cSz.qt = System.currentTimeMillis();
            this.cSz.arx();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cSz.ary();
            }
            handler3 = this.cSz.mHandler;
            handler4 = this.cSz.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            arF = this.cSz.arF();
            handler3.sendMessageDelayed(obtainMessage4, arF);
            handler5 = this.cSz.mHandler;
            handler6 = this.cSz.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            arD = this.cSz.arD();
            handler5.sendMessageDelayed(obtainMessage5, arD);
        }
    }
}
