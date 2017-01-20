package com.baidu.tieba.g;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c bAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bAk = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bAk.VL()) {
            switch (message.what) {
                case 1:
                    this.bAk.VH();
                    return true;
                case 2:
                    this.bAk.VF();
                    return true;
                case 3:
                    this.bAk.VG();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bAk.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
