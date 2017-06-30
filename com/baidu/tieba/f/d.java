package com.baidu.tieba.f;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Handler.Callback {
    final /* synthetic */ c bVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.bVn = cVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.bVn.abD()) {
            switch (message.what) {
                case 1:
                    this.bVn.abC();
                    return true;
                case 2:
                    this.bVn.abA();
                    return true;
                case 3:
                    this.bVn.abB();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.bVn.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
