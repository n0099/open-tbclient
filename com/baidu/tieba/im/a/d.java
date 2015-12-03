package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bTa = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long Zr;
        Handler handler5;
        Handler handler6;
        long Zp;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long Zr2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long Zp2;
        Handler handler13;
        boolean Zn;
        Handler handler14;
        Handler handler15;
        long Zp3;
        if (message.what == 2) {
            handler13 = this.bTa.mHandler;
            handler13.removeMessages(2);
            Zn = this.bTa.Zn();
            if (Zn) {
                this.bTa.wT = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.bTa.Zk();
                }
            }
            handler14 = this.bTa.mHandler;
            handler15 = this.bTa.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            Zp3 = this.bTa.Zp();
            handler14.sendMessageDelayed(obtainMessage, Zp3);
        }
        if (message.what == 1) {
            handler10 = this.bTa.mHandler;
            handler10.removeMessages(2);
            this.bTa.wT = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bTa.Zk();
            }
            handler11 = this.bTa.mHandler;
            handler12 = this.bTa.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            Zp2 = this.bTa.Zp();
            handler11.sendMessageDelayed(obtainMessage2, Zp2);
        }
        if (message.what == 3) {
            handler7 = this.bTa.mHandler;
            handler7.removeMessages(3);
            this.bTa.Zj();
            handler8 = this.bTa.mHandler;
            handler9 = this.bTa.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            Zr2 = this.bTa.Zr();
            handler8.sendMessageDelayed(obtainMessage3, Zr2);
        }
        if (message.what == 4) {
            handler = this.bTa.mHandler;
            handler.removeMessages(3);
            handler2 = this.bTa.mHandler;
            handler2.removeMessages(2);
            this.bTa.wT = System.currentTimeMillis();
            this.bTa.Zj();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bTa.Zk();
            }
            handler3 = this.bTa.mHandler;
            handler4 = this.bTa.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            Zr = this.bTa.Zr();
            handler3.sendMessageDelayed(obtainMessage4, Zr);
            handler5 = this.bTa.mHandler;
            handler6 = this.bTa.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            Zp = this.bTa.Zp();
            handler5.sendMessageDelayed(obtainMessage5, Zp);
        }
    }
}
