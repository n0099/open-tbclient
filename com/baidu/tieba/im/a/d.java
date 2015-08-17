package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c bzF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bzF = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long Vj;
        Handler handler5;
        Handler handler6;
        long Vh;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long Vj2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long Vh2;
        Handler handler13;
        boolean Vf;
        Handler handler14;
        Handler handler15;
        long Vh3;
        if (message.what == 2) {
            handler13 = this.bzF.mHandler;
            handler13.removeMessages(2);
            Vf = this.bzF.Vf();
            if (Vf) {
                this.bzF.wO = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.bzF.Vc();
                }
            }
            handler14 = this.bzF.mHandler;
            handler15 = this.bzF.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            Vh3 = this.bzF.Vh();
            handler14.sendMessageDelayed(obtainMessage, Vh3);
        }
        if (message.what == 1) {
            handler10 = this.bzF.mHandler;
            handler10.removeMessages(2);
            this.bzF.wO = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bzF.Vc();
            }
            handler11 = this.bzF.mHandler;
            handler12 = this.bzF.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            Vh2 = this.bzF.Vh();
            handler11.sendMessageDelayed(obtainMessage2, Vh2);
        }
        if (message.what == 3) {
            handler7 = this.bzF.mHandler;
            handler7.removeMessages(3);
            this.bzF.Vb();
            handler8 = this.bzF.mHandler;
            handler9 = this.bzF.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            Vj2 = this.bzF.Vj();
            handler8.sendMessageDelayed(obtainMessage3, Vj2);
        }
        if (message.what == 4) {
            handler = this.bzF.mHandler;
            handler.removeMessages(3);
            handler2 = this.bzF.mHandler;
            handler2.removeMessages(2);
            this.bzF.wO = System.currentTimeMillis();
            this.bzF.Vb();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bzF.Vc();
            }
            handler3 = this.bzF.mHandler;
            handler4 = this.bzF.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            Vj = this.bzF.Vj();
            handler3.sendMessageDelayed(obtainMessage4, Vj);
            handler5 = this.bzF.mHandler;
            handler6 = this.bzF.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            Vh = this.bzF.Vh();
            handler5.sendMessageDelayed(obtainMessage5, Vh);
        }
    }
}
