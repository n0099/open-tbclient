package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c bIE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bIE = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bIE.WZ()) {
            switch (message.what) {
                case 1:
                    this.bIE.WY();
                    return true;
                case 2:
                    this.bIE.WW();
                    return true;
                case 3:
                    this.bIE.WX();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bIE.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
