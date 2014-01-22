package com.baidu.tieba.im.net;

import android.os.Handler;
import com.baidu.adp.lib.webSocket.r;
import com.baidu.tieba.im.d.g;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.by;
import java.util.Map;
/* loaded from: classes.dex */
final class e extends r {
    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void b(byte[] bArr) {
        a aVar;
        a aVar2;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(String str) {
        a aVar;
        a aVar2;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        a aVar;
        a aVar2;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(Map<String, String> map) {
        Handler handler;
        a aVar;
        a aVar2;
        by.b("onOpen", "TiebaSocketLinkService:onOpen", "onOpen");
        f.a().c();
        handler = TiebaSocketLinkService.c;
        handler.removeMessages(1);
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(map);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.r, com.baidu.adp.lib.webSocket.l
    public void a(int i, String str) {
        Handler handler;
        a aVar;
        b bVar;
        a aVar2;
        boolean z = false;
        by.a("onClose", "TiebaSocketLinkService:onClose", "onClose", i, str);
        handler = TiebaSocketLinkService.c;
        handler.removeMessages(1);
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            if (i != 0) {
                com.baidu.tieba.im.b.a.c().b();
                by.a("TiebaSocketLinkService", 0, 0, "onClose():" + str, i);
                str = g.a(-1);
            }
            aVar2 = TiebaSocketLinkService.b;
            z = aVar2.a(i, str);
        }
        if (!z && UtilHelper.b()) {
            bVar = TiebaSocketLinkService.a;
            bVar.a("onClose:" + i + ":" + str);
        }
    }
}
