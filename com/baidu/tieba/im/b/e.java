package com.baidu.tieba.im.b;

import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.c {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public boolean a(int i, String str) {
        this.a.e();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(Map<String, String> map) {
        this.a.d();
        com.baidu.adp.lib.stats.f.c().a("lc_con", (String) null, (String) null, m.a().l(), 0, (String) null, "dns", Long.valueOf(m.a().j()), "ip", m.a().k(), "net", com.baidu.adp.lib.stats.f.c().e(), "localdns", m.a().m(), "localdnsbak", m.a().n());
        com.baidu.adp.framework.client.socket.i.a().a(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(String str) {
    }
}
