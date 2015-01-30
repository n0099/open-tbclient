package com.baidu.tieba.im.b;

import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.g {
    final /* synthetic */ b bjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bjN = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        this.bjN.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        this.bjN.start();
        com.baidu.adp.lib.stats.f.eq().a("lc_con", (String) null, (String) null, m.fU().gd(), 0, (String) null, "dns", Long.valueOf(m.fU().fS()), "ip", m.fU().fR(), "net", com.baidu.adp.lib.stats.f.eq().et(), "localdns", m.fU().fu(), "localdnsbak", m.fU().fv());
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
