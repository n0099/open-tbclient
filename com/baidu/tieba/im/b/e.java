package com.baidu.tieba.im.b;

import com.baidu.adp.lib.webSocket.l;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.g {
    final /* synthetic */ b bnU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bnU = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        this.bnU.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        this.bnU.start();
        com.baidu.adp.lib.stats.f.hz().a("lc_con", (String) null, (String) null, l.jI().jQ(), 0, (String) null, "dns", Long.valueOf(l.jI().jF()), "ip", l.jI().jE(), "net", com.baidu.adp.lib.stats.f.hz().hC(), "localdns", l.jI().jm(), "localdnsbak", l.jI().jn());
        com.baidu.adp.framework.client.socket.i.et().b(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void e(byte[] bArr) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void J(String str) {
    }
}
