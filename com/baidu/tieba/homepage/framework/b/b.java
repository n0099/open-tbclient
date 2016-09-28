package com.baidu.tieba.homepage.framework.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a cEk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cEk = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.cEk.Zb()) {
            switch (message.what) {
                case 1:
                    this.cEk.YX();
                    return true;
                case 2:
                    this.cEk.YV();
                    return true;
                case 3:
                    this.cEk.YW();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.cEk.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
