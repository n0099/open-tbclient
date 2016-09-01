package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dk implements Handler.Callback {
    final /* synthetic */ dj bTE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dk(dj djVar) {
        this.bTE = djVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bTE.YM()) {
            switch (message.what) {
                case 1:
                    this.bTE.YJ();
                    return true;
                case 2:
                    this.bTE.YH();
                    return true;
                case 3:
                    this.bTE.YI();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bTE.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
