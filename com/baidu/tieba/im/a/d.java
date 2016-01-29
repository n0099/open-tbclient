package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c cbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cbc = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long adv;
        Handler handler5;
        Handler handler6;
        long adt;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long adv2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long adt2;
        Handler handler13;
        boolean adr;
        Handler handler14;
        Handler handler15;
        long adt3;
        if (message.what == 2) {
            handler13 = this.cbc.mHandler;
            handler13.removeMessages(2);
            adr = this.cbc.adr();
            if (adr) {
                this.cbc.xe = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.cbc.ado();
                }
            }
            handler14 = this.cbc.mHandler;
            handler15 = this.cbc.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            adt3 = this.cbc.adt();
            handler14.sendMessageDelayed(obtainMessage, adt3);
        }
        if (message.what == 1) {
            handler10 = this.cbc.mHandler;
            handler10.removeMessages(2);
            this.cbc.xe = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cbc.ado();
            }
            handler11 = this.cbc.mHandler;
            handler12 = this.cbc.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            adt2 = this.cbc.adt();
            handler11.sendMessageDelayed(obtainMessage2, adt2);
        }
        if (message.what == 3) {
            handler7 = this.cbc.mHandler;
            handler7.removeMessages(3);
            this.cbc.adn();
            handler8 = this.cbc.mHandler;
            handler9 = this.cbc.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            adv2 = this.cbc.adv();
            handler8.sendMessageDelayed(obtainMessage3, adv2);
        }
        if (message.what == 4) {
            handler = this.cbc.mHandler;
            handler.removeMessages(3);
            handler2 = this.cbc.mHandler;
            handler2.removeMessages(2);
            this.cbc.xe = System.currentTimeMillis();
            this.cbc.adn();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cbc.ado();
            }
            handler3 = this.cbc.mHandler;
            handler4 = this.cbc.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            adv = this.cbc.adv();
            handler3.sendMessageDelayed(obtainMessage4, adv);
            handler5 = this.cbc.mHandler;
            handler6 = this.cbc.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            adt = this.cbc.adt();
            handler5.sendMessageDelayed(obtainMessage5, adt);
        }
    }
}
