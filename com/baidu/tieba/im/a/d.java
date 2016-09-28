package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c dhV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dhV = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long avj;
        Handler handler5;
        Handler handler6;
        long avh;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long avj2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long avh2;
        Handler handler13;
        boolean avf;
        Handler handler14;
        Handler handler15;
        long avh3;
        if (message.what == 2) {
            handler13 = this.dhV.mHandler;
            handler13.removeMessages(2);
            avf = this.dhV.avf();
            if (avf) {
                this.dhV.qs = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.dhV.avc();
                }
            }
            handler14 = this.dhV.mHandler;
            handler15 = this.dhV.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            avh3 = this.dhV.avh();
            handler14.sendMessageDelayed(obtainMessage, avh3);
        }
        if (message.what == 1) {
            handler10 = this.dhV.mHandler;
            handler10.removeMessages(2);
            this.dhV.qs = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dhV.avc();
            }
            handler11 = this.dhV.mHandler;
            handler12 = this.dhV.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            avh2 = this.dhV.avh();
            handler11.sendMessageDelayed(obtainMessage2, avh2);
        }
        if (message.what == 3) {
            handler7 = this.dhV.mHandler;
            handler7.removeMessages(3);
            this.dhV.avb();
            handler8 = this.dhV.mHandler;
            handler9 = this.dhV.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            avj2 = this.dhV.avj();
            handler8.sendMessageDelayed(obtainMessage3, avj2);
        }
        if (message.what == 4) {
            handler = this.dhV.mHandler;
            handler.removeMessages(3);
            handler2 = this.dhV.mHandler;
            handler2.removeMessages(2);
            this.dhV.qs = System.currentTimeMillis();
            this.dhV.avb();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dhV.avc();
            }
            handler3 = this.dhV.mHandler;
            handler4 = this.dhV.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            avj = this.dhV.avj();
            handler3.sendMessageDelayed(obtainMessage4, avj);
            handler5 = this.dhV.mHandler;
            handler6 = this.dhV.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            avh = this.dhV.avh();
            handler5.sendMessageDelayed(obtainMessage5, avh);
        }
    }
}
