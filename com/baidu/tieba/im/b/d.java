package com.baidu.tieba.im.b;

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
        long PF;
        Handler handler5;
        Handler handler6;
        Handler handler7;
        long PH;
        Handler handler8;
        Handler handler9;
        Handler handler10;
        long PF2;
        Handler handler11;
        boolean PD;
        Handler handler12;
        Handler handler13;
        long PF3;
        if (message.what == 2) {
            handler11 = this.this$0.mHandler;
            handler11.removeMessages(2);
            PD = this.this$0.PD();
            if (PD) {
                this.this$0.mLastUploadTime = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.this$0.PA();
                }
            }
            handler12 = this.this$0.mHandler;
            handler13 = this.this$0.mHandler;
            Message obtainMessage = handler13.obtainMessage(2);
            PF3 = this.this$0.PF();
            handler12.sendMessageDelayed(obtainMessage, PF3);
        }
        if (message.what == 1) {
            handler8 = this.this$0.mHandler;
            handler8.removeMessages(2);
            this.this$0.mLastUploadTime = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.this$0.PA();
            }
            handler9 = this.this$0.mHandler;
            handler10 = this.this$0.mHandler;
            Message obtainMessage2 = handler10.obtainMessage(2);
            PF2 = this.this$0.PF();
            handler9.sendMessageDelayed(obtainMessage2, PF2);
        }
        if (message.what == 3) {
            handler5 = this.this$0.mHandler;
            handler5.removeMessages(3);
            this.this$0.Pz();
            handler6 = this.this$0.mHandler;
            handler7 = this.this$0.mHandler;
            Message obtainMessage3 = handler7.obtainMessage(3);
            PH = this.this$0.PH();
            handler6.sendMessageDelayed(obtainMessage3, PH);
        }
        if (message.what == 4) {
            handler = this.this$0.mHandler;
            handler.removeMessages(3);
            handler2 = this.this$0.mHandler;
            handler2.removeMessages(2);
            this.this$0.mLastUploadTime = System.currentTimeMillis();
            this.this$0.Pz();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.this$0.PA();
            }
            handler3 = this.this$0.mHandler;
            handler4 = this.this$0.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(2);
            PF = this.this$0.PF();
            handler3.sendMessageDelayed(obtainMessage4, PF);
        }
    }
}
