package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements Handler.Callback {
    final /* synthetic */ dj bTx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar) {
        this.bTx = djVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bTx.Zb()) {
            switch (message.what) {
                case 1:
                    this.bTx.YX();
                    return true;
                case 2:
                    this.bTx.YV();
                    return true;
                case 3:
                    this.bTx.YW();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bTx.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
