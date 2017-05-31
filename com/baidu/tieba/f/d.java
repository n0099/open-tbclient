package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c bOs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bOs = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bOs.Yc()) {
            switch (message.what) {
                case 1:
                    this.bOs.Yb();
                    return true;
                case 2:
                    this.bOs.XZ();
                    return true;
                case 3:
                    this.bOs.Ya();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bOs.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
