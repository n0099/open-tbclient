package com.baidu.tieba.im.b;

import com.baidu.adp.lib.webSocket.l;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.g {
    final /* synthetic */ b bln;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bln = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        this.bln.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        this.bln.start();
        com.baidu.adp.lib.stats.f.hP().a("lc_con", (String) null, (String) null, l.jr().jz(), 0, (String) null, "dns", Long.valueOf(l.jr().jo()), "ip", l.jr().jn(), "net", com.baidu.adp.lib.stats.f.hP().hS(), "localdns", l.jr().iX(), "localdnsbak", l.jr().iY());
        com.baidu.adp.framework.client.socket.i.eq().b(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void e(byte[] bArr) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void G(String str) {
    }
}
