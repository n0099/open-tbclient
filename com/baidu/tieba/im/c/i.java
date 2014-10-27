package com.baidu.tieba.im.c;

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
                b.a(b.Qv()).removeMessages(2);
                b.Qv().QB();
                return;
            case 3:
                b.a(b.Qv()).removeMessages(3);
                if (b.e(b.Qv()) == 3) {
                    b.Qv().QC();
                } else {
                    b.Qv().QB();
                }
                b.a(b.Qv()).sendMessageDelayed(b.a(b.Qv()).obtainMessage(3), b.f(b.Qv()));
                return;
            default:
                return;
        }
    }
}
