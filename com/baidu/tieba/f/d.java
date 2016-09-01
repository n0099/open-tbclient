package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c bJA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bJA = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bJA.YM()) {
            switch (message.what) {
                case 1:
                    this.bJA.YJ();
                    return true;
                case 2:
                    this.bJA.YH();
                    return true;
                case 3:
                    this.bJA.YI();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bJA.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
