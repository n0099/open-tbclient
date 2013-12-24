package com.baidu.tieba.im.net;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class d extends Handler {
    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        b bVar;
        switch (message.what) {
            case 1:
                com.baidu.adp.lib.h.e.d("tcp建立和握手超时");
                TiebaSocketLinkService.a("tcp or websocket handshake timeout");
                bVar = TiebaSocketLinkService.a;
                bVar.a("tcp or websocket handshake timeout");
                return;
            default:
                return;
        }
    }
}
