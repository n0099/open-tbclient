package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cf implements Handler.Callback {
    final /* synthetic */ ce bJh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar) {
        this.bJh = ceVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bJh.VL()) {
            switch (message.what) {
                case 1:
                    this.bJh.VH();
                    return true;
                case 2:
                    this.bJh.VF();
                    return true;
                case 3:
                    this.bJh.VG();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bJh.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
