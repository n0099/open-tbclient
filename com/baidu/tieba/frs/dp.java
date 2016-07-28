package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements Handler.Callback {
    final /* synthetic */ Cdo bIC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(Cdo cdo) {
        this.bIC = cdo;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bIC.XA()) {
            switch (message.what) {
                case 1:
                    this.bIC.Xw();
                    return true;
                case 2:
                    this.bIC.Xu();
                    return true;
                case 3:
                    this.bIC.Xv();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bIC.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
