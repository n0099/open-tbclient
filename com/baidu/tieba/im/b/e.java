package com.baidu.tieba.im.b;

import com.baidu.adp.base.BdBaseApplication;
import java.util.Map;
/* loaded from: classes.dex */
class e implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ b bFD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bFD = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean k(int i, String str) {
        this.bFD.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void b(Map<String, String> map) {
        this.bFD.start();
        com.baidu.adp.lib.stats.a.hi().a("lc_con", (String) null, com.baidu.adp.lib.webSocket.h.jz().jG(), 0, (String) null, "dns", Long.valueOf(com.baidu.adp.lib.webSocket.h.jz().jw()), "ip", com.baidu.adp.lib.webSocket.h.jz().jv(), "net", com.baidu.adp.lib.stats.g.getNetType(BdBaseApplication.getInst()), "localdns", com.baidu.adp.lib.webSocket.h.jz().je(), "localdnsbak", com.baidu.adp.lib.webSocket.h.jz().jf());
        com.baidu.adp.framework.client.socket.g.et().a(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void s(byte[] bArr) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void I(String str) {
    }
}
