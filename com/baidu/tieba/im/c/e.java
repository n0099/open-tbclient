package com.baidu.tieba.im.c;

import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.g {
    final /* synthetic */ b beX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.beX = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean a(int i, String str) {
        this.beX.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void b(Map<String, String> map) {
        this.beX.start();
        com.baidu.adp.lib.stats.f.er().a("lc_con", (String) null, (String) null, m.fT().gb(), 0, (String) null, "dns", Long.valueOf(m.fT().fR()), "ip", m.fT().fQ(), "net", com.baidu.adp.lib.stats.f.er().eu(), "localdns", m.fT().fv(), "localdnsbak", m.fT().fw());
        com.baidu.adp.framework.client.socket.i.at().a(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void d(byte[] bArr) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void j(String str) {
    }
}
