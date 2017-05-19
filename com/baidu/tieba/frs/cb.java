package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cb implements Handler.Callback {
    final /* synthetic */ ca bRg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(ca caVar) {
        this.bRg = caVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bRg.WZ()) {
            switch (message.what) {
                case 1:
                    this.bRg.WY();
                    return true;
                case 2:
                    this.bRg.WW();
                    return true;
                case 3:
                    this.bRg.WX();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bRg.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
