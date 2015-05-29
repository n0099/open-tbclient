package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.this$0 = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long TB;
        Handler handler5;
        Handler handler6;
        long Tz;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long TB2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long Tz2;
        Handler handler13;
        boolean Tx;
        Handler handler14;
        Handler handler15;
        long Tz3;
        if (message.what == 2) {
            handler13 = this.this$0.mHandler;
            handler13.removeMessages(2);
            Tx = this.this$0.Tx();
            if (Tx) {
                this.this$0.mLastUploadTime = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.this$0.Tu();
                }
            }
            handler14 = this.this$0.mHandler;
            handler15 = this.this$0.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            Tz3 = this.this$0.Tz();
            handler14.sendMessageDelayed(obtainMessage, Tz3);
        }
        if (message.what == 1) {
            handler10 = this.this$0.mHandler;
            handler10.removeMessages(2);
            this.this$0.mLastUploadTime = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.this$0.Tu();
            }
            handler11 = this.this$0.mHandler;
            handler12 = this.this$0.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            Tz2 = this.this$0.Tz();
            handler11.sendMessageDelayed(obtainMessage2, Tz2);
        }
        if (message.what == 3) {
            handler7 = this.this$0.mHandler;
            handler7.removeMessages(3);
            this.this$0.Tt();
            handler8 = this.this$0.mHandler;
            handler9 = this.this$0.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            TB2 = this.this$0.TB();
            handler8.sendMessageDelayed(obtainMessage3, TB2);
        }
        if (message.what == 4) {
            handler = this.this$0.mHandler;
            handler.removeMessages(3);
            handler2 = this.this$0.mHandler;
            handler2.removeMessages(2);
            this.this$0.mLastUploadTime = System.currentTimeMillis();
            this.this$0.Tt();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.this$0.Tu();
            }
            handler3 = this.this$0.mHandler;
            handler4 = this.this$0.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            TB = this.this$0.TB();
            handler3.sendMessageDelayed(obtainMessage4, TB);
            handler5 = this.this$0.mHandler;
            handler6 = this.this$0.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            Tz = this.this$0.Tz();
            handler5.sendMessageDelayed(obtainMessage5, Tz);
        }
    }
}
