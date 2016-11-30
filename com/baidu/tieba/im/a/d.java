package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c dnD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dnD = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long axg;
        Handler handler5;
        Handler handler6;
        long axe;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long axg2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long axe2;
        Handler handler13;
        boolean axc;
        Handler handler14;
        Handler handler15;
        long axe3;
        if (message.what == 2) {
            handler13 = this.dnD.mHandler;
            handler13.removeMessages(2);
            axc = this.dnD.axc();
            if (axc) {
                this.dnD.qt = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.dnD.awZ();
                }
            }
            handler14 = this.dnD.mHandler;
            handler15 = this.dnD.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            axe3 = this.dnD.axe();
            handler14.sendMessageDelayed(obtainMessage, axe3);
        }
        if (message.what == 1) {
            handler10 = this.dnD.mHandler;
            handler10.removeMessages(2);
            this.dnD.qt = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dnD.awZ();
            }
            handler11 = this.dnD.mHandler;
            handler12 = this.dnD.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            axe2 = this.dnD.axe();
            handler11.sendMessageDelayed(obtainMessage2, axe2);
        }
        if (message.what == 3) {
            handler7 = this.dnD.mHandler;
            handler7.removeMessages(3);
            this.dnD.awY();
            handler8 = this.dnD.mHandler;
            handler9 = this.dnD.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            axg2 = this.dnD.axg();
            handler8.sendMessageDelayed(obtainMessage3, axg2);
        }
        if (message.what == 4) {
            handler = this.dnD.mHandler;
            handler.removeMessages(3);
            handler2 = this.dnD.mHandler;
            handler2.removeMessages(2);
            this.dnD.qt = System.currentTimeMillis();
            this.dnD.awY();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dnD.awZ();
            }
            handler3 = this.dnD.mHandler;
            handler4 = this.dnD.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            axg = this.dnD.axg();
            handler3.sendMessageDelayed(obtainMessage4, axg);
            handler5 = this.dnD.mHandler;
            handler6 = this.dnD.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            axe = this.dnD.axe();
            handler5.sendMessageDelayed(obtainMessage5, axe);
        }
    }
}
