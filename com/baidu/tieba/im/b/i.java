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
                b.d(b.Ug()).removeMessages(2);
                b.Ug().Ul();
                return;
            case 3:
                b.d(b.Ug()).removeMessages(3);
                if (b.e(b.Ug()) == 3) {
                    b.Ug().Um();
                } else {
                    b.Ug().Ul();
                }
                b.d(b.Ug()).sendMessageDelayed(b.d(b.Ug()).obtainMessage(3), b.f(b.Ug()));
                return;
            default:
                return;
        }
    }
}
