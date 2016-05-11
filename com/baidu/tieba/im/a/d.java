package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c cmE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cmE = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long agV;
        Handler handler5;
        Handler handler6;
        long agT;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long agV2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long agT2;
        Handler handler13;
        boolean agR;
        Handler handler14;
        Handler handler15;
        long agT3;
        if (message.what == 2) {
            handler13 = this.cmE.mHandler;
            handler13.removeMessages(2);
            agR = this.cmE.agR();
            if (agR) {
                this.cmE.nv = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.cmE.agO();
                }
            }
            handler14 = this.cmE.mHandler;
            handler15 = this.cmE.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            agT3 = this.cmE.agT();
            handler14.sendMessageDelayed(obtainMessage, agT3);
        }
        if (message.what == 1) {
            handler10 = this.cmE.mHandler;
            handler10.removeMessages(2);
            this.cmE.nv = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cmE.agO();
            }
            handler11 = this.cmE.mHandler;
            handler12 = this.cmE.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            agT2 = this.cmE.agT();
            handler11.sendMessageDelayed(obtainMessage2, agT2);
        }
        if (message.what == 3) {
            handler7 = this.cmE.mHandler;
            handler7.removeMessages(3);
            this.cmE.agN();
            handler8 = this.cmE.mHandler;
            handler9 = this.cmE.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            agV2 = this.cmE.agV();
            handler8.sendMessageDelayed(obtainMessage3, agV2);
        }
        if (message.what == 4) {
            handler = this.cmE.mHandler;
            handler.removeMessages(3);
            handler2 = this.cmE.mHandler;
            handler2.removeMessages(2);
            this.cmE.nv = System.currentTimeMillis();
            this.cmE.agN();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cmE.agO();
            }
            handler3 = this.cmE.mHandler;
            handler4 = this.cmE.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            agV = this.cmE.agV();
            handler3.sendMessageDelayed(obtainMessage4, agV);
            handler5 = this.cmE.mHandler;
            handler6 = this.cmE.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            agT = this.cmE.agT();
            handler5.sendMessageDelayed(obtainMessage5, agT);
        }
    }
}
