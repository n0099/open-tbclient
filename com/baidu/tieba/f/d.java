package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c bHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bHj = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bHj.Xh()) {
            switch (message.what) {
                case 1:
                    this.bHj.Xd();
                    return true;
                case 2:
                    this.bHj.Xb();
                    return true;
                case 3:
                    this.bHj.Xc();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bHj.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
