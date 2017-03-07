package com.baidu.tieba.im.a;

import android.os.Handler;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d extends Handler {
    final /* synthetic */ c dca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dca = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Handler handler4;
        long asg;
        Handler handler5;
        Handler handler6;
        long ase;
        Handler handler7;
        Handler handler8;
        Handler handler9;
        long asg2;
        Handler handler10;
        Handler handler11;
        Handler handler12;
        long ase2;
        Handler handler13;
        boolean asc;
        Handler handler14;
        Handler handler15;
        long ase3;
        if (message.what == 2) {
            handler13 = this.dca.mHandler;
            handler13.removeMessages(2);
            asc = this.dca.asc();
            if (asc) {
                this.dca.xI = System.currentTimeMillis();
                if (MessageManager.getInstance().getSocketClient().isValid()) {
                    this.dca.arZ();
                }
            }
            handler14 = this.dca.mHandler;
            handler15 = this.dca.mHandler;
            Message obtainMessage = handler15.obtainMessage(2);
            ase3 = this.dca.ase();
            handler14.sendMessageDelayed(obtainMessage, ase3);
        }
        if (message.what == 1) {
            handler10 = this.dca.mHandler;
            handler10.removeMessages(2);
            this.dca.xI = System.currentTimeMillis();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dca.arZ();
            }
            handler11 = this.dca.mHandler;
            handler12 = this.dca.mHandler;
            Message obtainMessage2 = handler12.obtainMessage(2);
            ase2 = this.dca.ase();
            handler11.sendMessageDelayed(obtainMessage2, ase2);
        }
        if (message.what == 3) {
            handler7 = this.dca.mHandler;
            handler7.removeMessages(3);
            this.dca.arY();
            handler8 = this.dca.mHandler;
            handler9 = this.dca.mHandler;
            Message obtainMessage3 = handler9.obtainMessage(3);
            asg2 = this.dca.asg();
            handler8.sendMessageDelayed(obtainMessage3, asg2);
        }
        if (message.what == 4) {
            handler = this.dca.mHandler;
            handler.removeMessages(3);
            handler2 = this.dca.mHandler;
            handler2.removeMessages(2);
            this.dca.xI = System.currentTimeMillis();
            this.dca.arY();
            if (MessageManager.getInstance().getSocketClient().isValid()) {
                this.dca.arZ();
            }
            handler3 = this.dca.mHandler;
            handler4 = this.dca.mHandler;
            Message obtainMessage4 = handler4.obtainMessage(3);
            asg = this.dca.asg();
            handler3.sendMessageDelayed(obtainMessage4, asg);
            handler5 = this.dca.mHandler;
            handler6 = this.dca.mHandler;
            Message obtainMessage5 = handler6.obtainMessage(2);
            ase = this.dca.ase();
            handler5.sendMessageDelayed(obtainMessage5, ase);
        }
    }
}
