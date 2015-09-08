package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c bAm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bAm = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long Vl;
        Handler handler5;
        Handler handler6;
        long Vj;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long Vl2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long Vj2;
        Handler handler13;
        boolean Vh;
        Handler handler14;
        Handler handler15;
        long Vj3;
        if (message.what == 2) {
            handler13 = this.bAm.mHandler;
            handler13.removeMessages(2);
            Vh = this.bAm.Vh();
            if (Vh) {
                this.bAm.wM = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.bAm.Ve();
                }
            }
            handler14 = this.bAm.mHandler;
            handler15 = this.bAm.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            Vj3 = this.bAm.Vj();
            handler14.sendMessageDelayed(obtainMessage, Vj3);
        }
        if (message.what == 1) {
            handler10 = this.bAm.mHandler;
            handler10.removeMessages(2);
            this.bAm.wM = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bAm.Ve();
            }
            handler11 = this.bAm.mHandler;
            handler12 = this.bAm.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            Vj2 = this.bAm.Vj();
            handler11.sendMessageDelayed(obtainMessage2, Vj2);
        }
        if (message.what == 3) {
            handler7 = this.bAm.mHandler;
            handler7.removeMessages(3);
            this.bAm.Vd();
            handler8 = this.bAm.mHandler;
            handler9 = this.bAm.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            Vl2 = this.bAm.Vl();
            handler8.sendMessageDelayed(obtainMessage3, Vl2);
        }
        if (message.what == 4) {
            handler = this.bAm.mHandler;
            handler.removeMessages(3);
            handler2 = this.bAm.mHandler;
            handler2.removeMessages(2);
            this.bAm.wM = System.currentTimeMillis();
            this.bAm.Vd();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bAm.Ve();
            }
            handler3 = this.bAm.mHandler;
            handler4 = this.bAm.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            Vl = this.bAm.Vl();
            handler3.sendMessageDelayed(obtainMessage4, Vl);
            handler5 = this.bAm.mHandler;
            handler6 = this.bAm.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            Vj = this.bAm.Vj();
            handler5.sendMessageDelayed(obtainMessage5, Vj);
        }
    }
}
