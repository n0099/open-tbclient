package com.baidu.tieba.e;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c bMu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bMu = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bMu.aad()) {
            switch (message.what) {
                case 1:
                    this.bMu.ZZ();
                    return true;
                case 2:
                    this.bMu.ZX();
                    return true;
                case 3:
                    this.bMu.ZY();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bMu.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
