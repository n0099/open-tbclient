package com.baidu.tieba.im.net.link;

import android.os.Handler;
import android.os.Message;
/* loaded from: classes.dex */
final class d extends Handler {
    @Override // android.os.Handler
    public void dispatchMessage(Message message) {
        b bVar;
        b bVar2;
        b bVar3;
        switch (message.what) {
            case 1:
                com.baidu.adp.lib.h.d.d("tcp建立和握手超时");
                TiebaSocketLinkService.c("tcp or websocket handshake timeout");
                bVar3 = TiebaSocketLinkService.f1757a;
                bVar3.a("tcp or websocket handshake timeout");
                return;
            case 2:
                TiebaSocketLinkService.b(7, "restart reconnStragtegy-ping error");
                bVar = TiebaSocketLinkService.f1757a;
                bVar.b("restart reconnStragtegy");
                bVar2 = TiebaSocketLinkService.f1757a;
                bVar2.a("restart reconnStragtegy");
                return;
            default:
                return;
        }
    }
}
