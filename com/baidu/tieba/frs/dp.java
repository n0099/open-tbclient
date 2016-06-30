package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements Handler.Callback {
    final /* synthetic */ Cdo bHg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(Cdo cdo) {
        this.bHg = cdo;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bHg.Xi()) {
            switch (message.what) {
                case 1:
                    this.bHg.Xe();
                    return true;
                case 2:
                    this.bHg.Xc();
                    return true;
                case 3:
                    this.bHg.Xd();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bHg.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
