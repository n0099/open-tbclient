package com.baidu.tieba.im.b;

import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.g {
    final /* synthetic */ b biq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.biq = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        this.biq.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        this.biq.start();
        com.baidu.adp.lib.stats.f.es().a("lc_con", (String) null, (String) null, m.fV().ge(), 0, (String) null, "dns", Long.valueOf(m.fV().fT()), "ip", m.fV().fS(), "net", com.baidu.adp.lib.stats.f.es().ev(), "localdns", m.fV().fv(), "localdnsbak", m.fV().fw());
        com.baidu.adp.framework.client.socket.i.aT().b(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void e(byte[] bArr) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void y(String str) {
    }
}
