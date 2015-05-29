package com.baidu.tieba.im.b;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
class i extends Handler {
    private i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ i(i iVar) {
        this();
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 2:
                b.d(b.Uf()).removeMessages(2);
                b.Uf().Uk();
                return;
            case 3:
                b.d(b.Uf()).removeMessages(3);
                if (b.e(b.Uf()) == 3) {
                    b.Uf().Ul();
                } else {
                    b.Uf().Uk();
                }
                b.d(b.Uf()).sendMessageDelayed(b.d(b.Uf()).obtainMessage(3), b.f(b.Uf()));
                return;
            default:
                return;
        }
    }
}
