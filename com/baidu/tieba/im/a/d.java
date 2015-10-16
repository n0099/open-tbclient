package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c bDz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bDz = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long VU;
        Handler handler5;
        Handler handler6;
        long VS;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long VU2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long VS2;
        Handler handler13;
        boolean VQ;
        Handler handler14;
        Handler handler15;
        long VS3;
        if (message.what == 2) {
            handler13 = this.bDz.mHandler;
            handler13.removeMessages(2);
            VQ = this.bDz.VQ();
            if (VQ) {
                this.bDz.wN = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.bDz.VN();
                }
            }
            handler14 = this.bDz.mHandler;
            handler15 = this.bDz.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            VS3 = this.bDz.VS();
            handler14.sendMessageDelayed(obtainMessage, VS3);
        }
        if (message.what == 1) {
            handler10 = this.bDz.mHandler;
            handler10.removeMessages(2);
            this.bDz.wN = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bDz.VN();
            }
            handler11 = this.bDz.mHandler;
            handler12 = this.bDz.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            VS2 = this.bDz.VS();
            handler11.sendMessageDelayed(obtainMessage2, VS2);
        }
        if (message.what == 3) {
            handler7 = this.bDz.mHandler;
            handler7.removeMessages(3);
            this.bDz.VM();
            handler8 = this.bDz.mHandler;
            handler9 = this.bDz.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            VU2 = this.bDz.VU();
            handler8.sendMessageDelayed(obtainMessage3, VU2);
        }
        if (message.what == 4) {
            handler = this.bDz.mHandler;
            handler.removeMessages(3);
            handler2 = this.bDz.mHandler;
            handler2.removeMessages(2);
            this.bDz.wN = System.currentTimeMillis();
            this.bDz.VM();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bDz.VN();
            }
            handler3 = this.bDz.mHandler;
            handler4 = this.bDz.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            VU = this.bDz.VU();
            handler3.sendMessageDelayed(obtainMessage4, VU);
            handler5 = this.bDz.mHandler;
            handler6 = this.bDz.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            VS = this.bDz.VS();
            handler5.sendMessageDelayed(obtainMessage5, VS);
        }
    }
}
