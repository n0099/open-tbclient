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
        long Qq;
        Handler handler5;
        Handler handler6;
        long Qo;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long Qq2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long Qo2;
        Handler handler13;
        boolean Qm;
        Handler handler14;
        Handler handler15;
        long Qo3;
        if (message.what == 2) {
            handler13 = this.this$0.mHandler;
            handler13.removeMessages(2);
            Qm = this.this$0.Qm();
            if (Qm) {
                this.this$0.mLastUploadTime = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.this$0.Qj();
                }
            }
            handler14 = this.this$0.mHandler;
            handler15 = this.this$0.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            Qo3 = this.this$0.Qo();
            handler14.sendMessageDelayed(obtainMessage, Qo3);
        }
        if (message.what == 1) {
            handler10 = this.this$0.mHandler;
            handler10.removeMessages(2);
            this.this$0.mLastUploadTime = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.this$0.Qj();
            }
            handler11 = this.this$0.mHandler;
            handler12 = this.this$0.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            Qo2 = this.this$0.Qo();
            handler11.sendMessageDelayed(obtainMessage2, Qo2);
        }
        if (message.what == 3) {
            handler7 = this.this$0.mHandler;
            handler7.removeMessages(3);
            this.this$0.Qi();
            handler8 = this.this$0.mHandler;
            handler9 = this.this$0.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            Qq2 = this.this$0.Qq();
            handler8.sendMessageDelayed(obtainMessage3, Qq2);
        }
        if (message.what == 4) {
            handler = this.this$0.mHandler;
            handler.removeMessages(3);
            handler2 = this.this$0.mHandler;
            handler2.removeMessages(2);
            this.this$0.mLastUploadTime = System.currentTimeMillis();
            this.this$0.Qi();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.this$0.Qj();
            }
            handler3 = this.this$0.mHandler;
            handler4 = this.this$0.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            Qq = this.this$0.Qq();
            handler3.sendMessageDelayed(obtainMessage4, Qq);
            handler5 = this.this$0.mHandler;
            handler6 = this.this$0.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            Qo = this.this$0.Qo();
            handler5.sendMessageDelayed(obtainMessage5, Qo);
        }
    }
}
