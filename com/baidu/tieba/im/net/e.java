package com.baidu.tieba.im.net;

import android.os.Handler;
import com.baidu.adp.lib.webSocket.r;
import com.baidu.tieba.log.i;
import com.baidu.tieba.util.UtilHelper;
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
        b bVar;
        a aVar;
        a aVar2;
        com.baidu.tieba.log.a.b(i.a("onOpen", "TiebaSocketLinkService:onOpen", "onOpen"));
        f.a().c();
        handler = TiebaSocketLinkService.c;
        handler.removeMessages(1);
        bVar = TiebaSocketLinkService.f1854a;
        bVar.b("ConnectiononOpen");
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
        com.baidu.tieba.log.a.b(i.a("onClose", "TiebaSocketLinkService:onClose", "onClose", i, str));
        handler = TiebaSocketLinkService.c;
        handler.removeMessages(1);
        boolean z = false;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            if (i != 0) {
                str = com.baidu.tieba.im.e.f.a(-1);
            }
            aVar2 = TiebaSocketLinkService.b;
            z = aVar2.a(i, str);
        }
        if (!z && UtilHelper.b()) {
            bVar = TiebaSocketLinkService.f1854a;
            bVar.a("onClose:" + i + ":" + str);
        }
    }
}
