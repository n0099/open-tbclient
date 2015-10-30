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
        long VQ;
        Handler handler5;
        Handler handler6;
        long VO;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long VQ2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long VO2;
        Handler handler13;
        boolean VM;
        Handler handler14;
        Handler handler15;
        long VO3;
        if (message.what == 2) {
            handler13 = this.bDz.mHandler;
            handler13.removeMessages(2);
            VM = this.bDz.VM();
            if (VM) {
                this.bDz.wN = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.bDz.VJ();
                }
            }
            handler14 = this.bDz.mHandler;
            handler15 = this.bDz.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            VO3 = this.bDz.VO();
            handler14.sendMessageDelayed(obtainMessage, VO3);
        }
        if (message.what == 1) {
            handler10 = this.bDz.mHandler;
            handler10.removeMessages(2);
            this.bDz.wN = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bDz.VJ();
            }
            handler11 = this.bDz.mHandler;
            handler12 = this.bDz.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            VO2 = this.bDz.VO();
            handler11.sendMessageDelayed(obtainMessage2, VO2);
        }
        if (message.what == 3) {
            handler7 = this.bDz.mHandler;
            handler7.removeMessages(3);
            this.bDz.VI();
            handler8 = this.bDz.mHandler;
            handler9 = this.bDz.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            VQ2 = this.bDz.VQ();
            handler8.sendMessageDelayed(obtainMessage3, VQ2);
        }
        if (message.what == 4) {
            handler = this.bDz.mHandler;
            handler.removeMessages(3);
            handler2 = this.bDz.mHandler;
            handler2.removeMessages(2);
            this.bDz.wN = System.currentTimeMillis();
            this.bDz.VI();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bDz.VJ();
            }
            handler3 = this.bDz.mHandler;
            handler4 = this.bDz.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            VQ = this.bDz.VQ();
            handler3.sendMessageDelayed(obtainMessage4, VQ);
            handler5 = this.bDz.mHandler;
            handler6 = this.bDz.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            VO = this.bDz.VO();
            handler5.sendMessageDelayed(obtainMessage5, VO);
        }
    }
}
