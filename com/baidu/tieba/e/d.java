package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c bsy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bsy = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bsy.Uq()) {
            switch (message.what) {
                case 1:
                    this.bsy.Um();
                    return true;
                case 2:
                    this.bsy.Uk();
                    return true;
                case 3:
                    this.bsy.Ul();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bsy.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
