package com.baidu.tieba.im.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
final class n extends Handler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public final void dispatchMessage(Message message) {
        l lVar;
        switch (message.what) {
            case 1:
                com.baidu.adp.lib.util.e.e("tcp建立和握手超时");
                TiebaSocketLinkService.b("tcp or websocket handshake timeout");
                lVar = TiebaSocketLinkService.a;
                lVar.a("tcp or websocket handshake timeout");
                return;
            default:
                return;
        }
    }
}
