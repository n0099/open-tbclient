package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements Handler.Callback {
    final /* synthetic */ ce bQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar) {
        this.bQq = ceVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bQq.WJ()) {
            switch (message.what) {
                case 1:
                    this.bQq.WF();
                    return true;
                case 2:
                    this.bQq.WD();
                    return true;
                case 3:
                    this.bQq.WE();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bQq.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
