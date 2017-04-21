package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements Handler.Callback {
    final /* synthetic */ cg bSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.bSw = cgVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bSw.Yi()) {
            switch (message.what) {
                case 1:
                    this.bSw.Ye();
                    return true;
                case 2:
                    this.bSw.Yc();
                    return true;
                case 3:
                    this.bSw.Yd();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bSw.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
