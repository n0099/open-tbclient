package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cc implements Handler.Callback {
    final /* synthetic */ cb bWW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cc(cb cbVar) {
        this.bWW = cbVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bWW.Yc()) {
            switch (message.what) {
                case 1:
                    this.bWW.Yb();
                    return true;
                case 2:
                    this.bWW.XZ();
                    return true;
                case 3:
                    this.bWW.Ya();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bWW.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
