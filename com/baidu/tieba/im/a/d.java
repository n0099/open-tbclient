package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c bWI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bWI = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long aaw;
        Handler handler5;
        Handler handler6;
        long aau;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long aaw2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long aau2;
        Handler handler13;
        boolean aas;
        Handler handler14;
        Handler handler15;
        long aau3;
        if (message.what == 2) {
            handler13 = this.bWI.mHandler;
            handler13.removeMessages(2);
            aas = this.bWI.aas();
            if (aas) {
                this.bWI.wV = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.bWI.aap();
                }
            }
            handler14 = this.bWI.mHandler;
            handler15 = this.bWI.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            aau3 = this.bWI.aau();
            handler14.sendMessageDelayed(obtainMessage, aau3);
        }
        if (message.what == 1) {
            handler10 = this.bWI.mHandler;
            handler10.removeMessages(2);
            this.bWI.wV = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bWI.aap();
            }
            handler11 = this.bWI.mHandler;
            handler12 = this.bWI.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            aau2 = this.bWI.aau();
            handler11.sendMessageDelayed(obtainMessage2, aau2);
        }
        if (message.what == 3) {
            handler7 = this.bWI.mHandler;
            handler7.removeMessages(3);
            this.bWI.aao();
            handler8 = this.bWI.mHandler;
            handler9 = this.bWI.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            aaw2 = this.bWI.aaw();
            handler8.sendMessageDelayed(obtainMessage3, aaw2);
        }
        if (message.what == 4) {
            handler = this.bWI.mHandler;
            handler.removeMessages(3);
            handler2 = this.bWI.mHandler;
            handler2.removeMessages(2);
            this.bWI.wV = System.currentTimeMillis();
            this.bWI.aao();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.bWI.aap();
            }
            handler3 = this.bWI.mHandler;
            handler4 = this.bWI.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            aaw = this.bWI.aaw();
            handler3.sendMessageDelayed(obtainMessage4, aaw);
            handler5 = this.bWI.mHandler;
            handler6 = this.bWI.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            aau = this.bWI.aau();
            handler5.sendMessageDelayed(obtainMessage5, aau);
        }
    }
}
