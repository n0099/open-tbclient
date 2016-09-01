package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c dgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dgy = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long auK;
        Handler handler5;
        Handler handler6;
        long auI;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long auK2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long auI2;
        Handler handler13;
        boolean auG;
        Handler handler14;
        Handler handler15;
        long auI3;
        if (message.what == 2) {
            handler13 = this.dgy.mHandler;
            handler13.removeMessages(2);
            auG = this.dgy.auG();
            if (auG) {
                this.dgy.qs = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.dgy.auD();
                }
            }
            handler14 = this.dgy.mHandler;
            handler15 = this.dgy.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            auI3 = this.dgy.auI();
            handler14.sendMessageDelayed(obtainMessage, auI3);
        }
        if (message.what == 1) {
            handler10 = this.dgy.mHandler;
            handler10.removeMessages(2);
            this.dgy.qs = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dgy.auD();
            }
            handler11 = this.dgy.mHandler;
            handler12 = this.dgy.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            auI2 = this.dgy.auI();
            handler11.sendMessageDelayed(obtainMessage2, auI2);
        }
        if (message.what == 3) {
            handler7 = this.dgy.mHandler;
            handler7.removeMessages(3);
            this.dgy.auC();
            handler8 = this.dgy.mHandler;
            handler9 = this.dgy.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            auK2 = this.dgy.auK();
            handler8.sendMessageDelayed(obtainMessage3, auK2);
        }
        if (message.what == 4) {
            handler = this.dgy.mHandler;
            handler.removeMessages(3);
            handler2 = this.dgy.mHandler;
            handler2.removeMessages(2);
            this.dgy.qs = System.currentTimeMillis();
            this.dgy.auC();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dgy.auD();
            }
            handler3 = this.dgy.mHandler;
            handler4 = this.dgy.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            auK = this.dgy.auK();
            handler3.sendMessageDelayed(obtainMessage4, auK);
            handler5 = this.dgy.mHandler;
            handler6 = this.dgy.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            auI = this.dgy.auI();
            handler5.sendMessageDelayed(obtainMessage5, auI);
        }
    }
}
