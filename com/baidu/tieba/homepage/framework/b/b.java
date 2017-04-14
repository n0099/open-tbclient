package com.baidu.tieba.homepage.framework.b;

import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Handler.Callback {
    final /* synthetic */ a cvU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.cvU = aVar;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        Handler handler;
        if ((message.what != 1 && message.what != 2) || !this.cvU.Xh()) {
            switch (message.what) {
                case 1:
                    this.cvU.Xd();
                    return true;
                case 2:
                    this.cvU.Xb();
                    return true;
                case 3:
                    this.cvU.Xc();
                    return true;
                default:
                    return false;
            }
        }
        handler = this.cvU.mHandler;
        handler.sendEmptyMessageDelayed(message.what, 100L);
        return true;
    }
}
