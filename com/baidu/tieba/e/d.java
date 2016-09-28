package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c bJB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bJB = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bJB.Zb()) {
            switch (message.what) {
                case 1:
                    this.bJB.YX();
                    return true;
                case 2:
                    this.bJB.YV();
                    return true;
                case 3:
                    this.bJB.YW();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bJB.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
