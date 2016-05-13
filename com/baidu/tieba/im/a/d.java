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
        long agX;
        Handler handler5;
        Handler handler6;
        long agV;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long agX2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long agV2;
        Handler handler13;
        boolean agT;
        Handler handler14;
        Handler handler15;
        long agV3;
        if (message.what == 2) {
            handler13 = this.cmE.mHandler;
            handler13.removeMessages(2);
            agT = this.cmE.agT();
            if (agT) {
                this.cmE.nv = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.cmE.agQ();
                }
            }
            handler14 = this.cmE.mHandler;
            handler15 = this.cmE.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            agV3 = this.cmE.agV();
            handler14.sendMessageDelayed(obtainMessage, agV3);
        }
        if (message.what == 1) {
            handler10 = this.cmE.mHandler;
            handler10.removeMessages(2);
            this.cmE.nv = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cmE.agQ();
            }
            handler11 = this.cmE.mHandler;
            handler12 = this.cmE.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            agV2 = this.cmE.agV();
            handler11.sendMessageDelayed(obtainMessage2, agV2);
        }
        if (message.what == 3) {
            handler7 = this.cmE.mHandler;
            handler7.removeMessages(3);
            this.cmE.agP();
            handler8 = this.cmE.mHandler;
            handler9 = this.cmE.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            agX2 = this.cmE.agX();
            handler8.sendMessageDelayed(obtainMessage3, agX2);
        }
        if (message.what == 4) {
            handler = this.cmE.mHandler;
            handler.removeMessages(3);
            handler2 = this.cmE.mHandler;
            handler2.removeMessages(2);
            this.cmE.nv = System.currentTimeMillis();
            this.cmE.agP();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cmE.agQ();
            }
            handler3 = this.cmE.mHandler;
            handler4 = this.cmE.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            agX = this.cmE.agX();
            handler3.sendMessageDelayed(obtainMessage4, agX);
            handler5 = this.cmE.mHandler;
            handler6 = this.cmE.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            agV = this.cmE.agV();
            handler5.sendMessageDelayed(obtainMessage5, agV);
        }
    }
}
