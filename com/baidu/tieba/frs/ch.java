package com.baidu.tieba.frs;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ch implements Handler.Callback {
    final /* synthetic */ cg bBO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar) {
        this.bBO = cgVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bBO.Uq()) {
            switch (message.what) {
                case 1:
                    this.bBO.Um();
                    return true;
                case 2:
                    this.bBO.Uk();
                    return true;
                case 3:
                    this.bBO.Ul();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bBO.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
