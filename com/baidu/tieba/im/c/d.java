package com.baidu.tieba.im.c;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.framework.client.socket.link.c {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public boolean a(int i, String str) {
        BdLog.e("errorCode=" + i + "|errorString=" + str);
        this.a.d();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(Map<String, String> map) {
        this.a.c();
        com.baidu.adp.lib.stats.h.a().a("lc_con", (String) null, (String) null, m.a().l(), 0, (String) null, "dns", Long.valueOf(m.a().j()), "ip", m.a().k(), "net", com.baidu.adp.lib.stats.h.a().d(), "localdns", m.a().m(), "localdnsbak", m.a().n());
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
