package com.baidu.tieba.im.net;

import android.os.Handler;
import com.baidu.adp.lib.webSocket.q;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.cb;
import java.util.Map;
/* loaded from: classes.dex */
final class o extends q {
    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(byte[] bArr) {
        a aVar;
        a aVar2;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(String str) {
        a aVar;
        a aVar2;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(com.baidu.adp.lib.webSocket.d dVar) {
        a aVar;
        a aVar2;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(Map<String, String> map) {
        Handler handler;
        a aVar;
        a aVar2;
        cb.b("onOpen", "TiebaSocketLinkService:onOpen", "onOpen");
        p.a().c();
        handler = TiebaSocketLinkService.c;
        handler.removeMessages(1);
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public final void a(int i, String str) {
        Handler handler;
        a aVar;
        l lVar;
        a aVar2;
        boolean z = false;
        cb.a("onClose", "TiebaSocketLinkService:onClose", "onClose", i, str);
        handler = TiebaSocketLinkService.c;
        handler.removeMessages(1);
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            if (i != 0) {
                com.baidu.tieba.im.b.a.c().b();
                cb.a("TiebaSocketLinkService", 0, 0, "onClose():" + str, i);
                str = com.baidu.tieba.im.util.n.a(-1);
            }
            aVar2 = TiebaSocketLinkService.b;
            z = aVar2.a(i, str);
        }
        if (!z && UtilHelper.b()) {
            lVar = TiebaSocketLinkService.a;
            lVar.a("onClose:" + i + ":" + str);
        }
    }
}
