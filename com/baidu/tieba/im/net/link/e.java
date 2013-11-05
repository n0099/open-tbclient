package com.baidu.tieba.im.net.link;

import android.os.Handler;
import com.baidu.adp.lib.webSocket.am;
import com.baidu.adp.lib.webSocket.q;
import com.baidu.tieba.util.UtilHelper;
import com.baidu.tieba.util.o;
/* loaded from: classes.dex */
final class e extends q {
    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void b(byte[] bArr) {
        a aVar;
        a aVar2;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(bArr);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void a(String str) {
        a aVar;
        a aVar2;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(str);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void a(am amVar) {
        a aVar;
        a aVar2;
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(amVar);
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void a() {
        Handler handler;
        b bVar;
        a aVar;
        a aVar2;
        o.a("onOpen", "TiebaSocketLinkService:onOpen", "onOpen");
        handler = TiebaSocketLinkService.c;
        handler.removeMessages(1);
        bVar = TiebaSocketLinkService.f1679a;
        bVar.b("ConnectiononOpen");
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            aVar2 = TiebaSocketLinkService.b;
            aVar2.c();
        }
    }

    @Override // com.baidu.adp.lib.webSocket.q, com.baidu.adp.lib.webSocket.k
    public void a(int i, String str) {
        Handler handler;
        a aVar;
        b bVar;
        a aVar2;
        o.a("onClose", "TiebaSocketLinkService:onClose", "onClose", i, str);
        handler = TiebaSocketLinkService.c;
        handler.removeMessages(1);
        aVar = TiebaSocketLinkService.b;
        if (aVar != null) {
            if (i != 0) {
                str = com.baidu.tieba.im.d.e.a(-1);
            }
            aVar2 = TiebaSocketLinkService.b;
            aVar2.a(i, str);
        }
        if (i != 1 && UtilHelper.b()) {
            bVar = TiebaSocketLinkService.f1679a;
            bVar.a("onClose:" + i + ":" + str);
        }
    }
}
