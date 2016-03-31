package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c clG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.clG = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long agO;
        Handler handler5;
        Handler handler6;
        long agM;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long agO2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long agM2;
        Handler handler13;
        boolean agK;
        Handler handler14;
        Handler handler15;
        long agM3;
        if (message.what == 2) {
            handler13 = this.clG.mHandler;
            handler13.removeMessages(2);
            agK = this.clG.agK();
            if (agK) {
                this.clG.xv = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.clG.agH();
                }
            }
            handler14 = this.clG.mHandler;
            handler15 = this.clG.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            agM3 = this.clG.agM();
            handler14.sendMessageDelayed(obtainMessage, agM3);
        }
        if (message.what == 1) {
            handler10 = this.clG.mHandler;
            handler10.removeMessages(2);
            this.clG.xv = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.clG.agH();
            }
            handler11 = this.clG.mHandler;
            handler12 = this.clG.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            agM2 = this.clG.agM();
            handler11.sendMessageDelayed(obtainMessage2, agM2);
        }
        if (message.what == 3) {
            handler7 = this.clG.mHandler;
            handler7.removeMessages(3);
            this.clG.agG();
            handler8 = this.clG.mHandler;
            handler9 = this.clG.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            agO2 = this.clG.agO();
            handler8.sendMessageDelayed(obtainMessage3, agO2);
        }
        if (message.what == 4) {
            handler = this.clG.mHandler;
            handler.removeMessages(3);
            handler2 = this.clG.mHandler;
            handler2.removeMessages(2);
            this.clG.xv = System.currentTimeMillis();
            this.clG.agG();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.clG.agH();
            }
            handler3 = this.clG.mHandler;
            handler4 = this.clG.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            agO = this.clG.agO();
            handler3.sendMessageDelayed(obtainMessage4, agO);
            handler5 = this.clG.mHandler;
            handler6 = this.clG.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            agM = this.clG.agM();
            handler5.sendMessageDelayed(obtainMessage5, agM);
        }
    }
}
