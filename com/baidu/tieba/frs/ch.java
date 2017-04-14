package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements Handler.Callback {
    final /* synthetic */ cg bQf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.bQf = cgVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bQf.Xh()) {
            switch (message.what) {
                case 1:
                    this.bQf.Xd();
                    return true;
                case 2:
                    this.bQf.Xb();
                    return true;
                case 3:
                    this.bQf.Xc();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bQf.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
