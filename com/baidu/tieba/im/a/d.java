package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c cRT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.cRT = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long apk;
        Handler handler5;
        Handler handler6;
        long api;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long apk2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long api2;
        Handler handler13;
        boolean apg;
        Handler handler14;
        Handler handler15;
        long api3;
        if (message.what == 2) {
            handler13 = this.cRT.mHandler;
            handler13.removeMessages(2);
            apg = this.cRT.apg();
            if (apg) {
                this.cRT.nv = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.cRT.apd();
                }
            }
            handler14 = this.cRT.mHandler;
            handler15 = this.cRT.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            api3 = this.cRT.api();
            handler14.sendMessageDelayed(obtainMessage, api3);
        }
        if (message.what == 1) {
            handler10 = this.cRT.mHandler;
            handler10.removeMessages(2);
            this.cRT.nv = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cRT.apd();
            }
            handler11 = this.cRT.mHandler;
            handler12 = this.cRT.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            api2 = this.cRT.api();
            handler11.sendMessageDelayed(obtainMessage2, api2);
        }
        if (message.what == 3) {
            handler7 = this.cRT.mHandler;
            handler7.removeMessages(3);
            this.cRT.apc();
            handler8 = this.cRT.mHandler;
            handler9 = this.cRT.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            apk2 = this.cRT.apk();
            handler8.sendMessageDelayed(obtainMessage3, apk2);
        }
        if (message.what == 4) {
            handler = this.cRT.mHandler;
            handler.removeMessages(3);
            handler2 = this.cRT.mHandler;
            handler2.removeMessages(2);
            this.cRT.nv = System.currentTimeMillis();
            this.cRT.apc();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.cRT.apd();
            }
            handler3 = this.cRT.mHandler;
            handler4 = this.cRT.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            apk = this.cRT.apk();
            handler3.sendMessageDelayed(obtainMessage4, apk);
            handler5 = this.cRT.mHandler;
            handler6 = this.cRT.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            api = this.cRT.api();
            handler5.sendMessageDelayed(obtainMessage5, api);
        }
    }
}
