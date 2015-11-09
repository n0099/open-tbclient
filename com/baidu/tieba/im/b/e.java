package com.baidu.tieba.im.b;

import com.baidu.adp.base.BdBaseApplication;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ b bFY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bFY = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean k(int i, String str) {
        this.bFY.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void b(Map<String, String> map) {
        this.bFY.start();
        com.baidu.adp.lib.stats.a.hj().a("lc_con", (String) null, com.baidu.adp.lib.webSocket.h.jA().jH(), 0, (String) null, "dns", Long.valueOf(com.baidu.adp.lib.webSocket.h.jA().jx()), "ip", com.baidu.adp.lib.webSocket.h.jA().jw(), "net", com.baidu.adp.lib.stats.g.getNetType(BdBaseApplication.getInst()), "localdns", com.baidu.adp.lib.webSocket.h.jA().jf(), "localdnsbak", com.baidu.adp.lib.webSocket.h.jA().jg());
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
