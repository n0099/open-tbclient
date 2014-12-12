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
                b.a(b.QX()).removeMessages(2);
                b.QX().Rd();
                return;
            case 3:
                b.a(b.QX()).removeMessages(3);
                if (b.e(b.QX()) == 3) {
                    b.QX().Re();
                } else {
                    b.QX().Rd();
                }
                b.a(b.QX()).sendMessageDelayed(b.a(b.QX()).obtainMessage(3), b.f(b.QX()));
                return;
            default:
                return;
        }
    }
}
