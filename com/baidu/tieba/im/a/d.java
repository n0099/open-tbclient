package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c dcP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dcP = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long ata;
        Handler handler5;
        Handler handler6;
        long asY;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long ata2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long asY2;
        Handler handler13;
        boolean asW;
        Handler handler14;
        Handler handler15;
        long asY3;
        if (message.what == 2) {
            handler13 = this.dcP.mHandler;
            handler13.removeMessages(2);
            asW = this.dcP.asW();
            if (asW) {
                this.dcP.xm = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.dcP.asT();
                }
            }
            handler14 = this.dcP.mHandler;
            handler15 = this.dcP.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            asY3 = this.dcP.asY();
            handler14.sendMessageDelayed(obtainMessage, asY3);
        }
        if (message.what == 1) {
            handler10 = this.dcP.mHandler;
            handler10.removeMessages(2);
            this.dcP.xm = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dcP.asT();
            }
            handler11 = this.dcP.mHandler;
            handler12 = this.dcP.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            asY2 = this.dcP.asY();
            handler11.sendMessageDelayed(obtainMessage2, asY2);
        }
        if (message.what == 3) {
            handler7 = this.dcP.mHandler;
            handler7.removeMessages(3);
            this.dcP.asS();
            handler8 = this.dcP.mHandler;
            handler9 = this.dcP.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            ata2 = this.dcP.ata();
            handler8.sendMessageDelayed(obtainMessage3, ata2);
        }
        if (message.what == 4) {
            handler = this.dcP.mHandler;
            handler.removeMessages(3);
            handler2 = this.dcP.mHandler;
            handler2.removeMessages(2);
            this.dcP.xm = System.currentTimeMillis();
            this.dcP.asS();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dcP.asT();
            }
            handler3 = this.dcP.mHandler;
            handler4 = this.dcP.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            ata = this.dcP.ata();
            handler3.sendMessageDelayed(obtainMessage4, ata);
            handler5 = this.dcP.mHandler;
            handler6 = this.dcP.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            asY = this.dcP.asY();
            handler5.sendMessageDelayed(obtainMessage5, asY);
        }
    }
}
