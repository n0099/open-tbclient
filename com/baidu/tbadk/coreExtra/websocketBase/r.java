package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.adp.lib.webSocket.l {
    final /* synthetic */ q Qd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.Qd = qVar;
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void c(Map<String, String> map) {
        int i;
        i = this.Qd.PY;
        if (i >= 5) {
            com.baidu.adp.framework.client.socket.m.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.l.getUrl());
            a.qq().cO(com.baidu.adp.framework.client.socket.l.getUrl());
            a.qq().qu();
        }
        this.Qd.PY = 0;
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void b(int i, String str) {
        int i2;
        int i3;
        if ((i == 2 || i == 9) && com.baidu.adp.lib.util.j.fh()) {
            q qVar = this.Qd;
            i2 = qVar.PY;
            qVar.PY = i2 + 1;
            i3 = this.Qd.PY;
            if (i3 >= 5) {
                com.baidu.adp.framework.client.socket.m.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                this.Qd.qM();
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void fS() {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void j(String str) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void s(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void h(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void b(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(int i, com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void c(com.baidu.adp.lib.webSocket.d dVar) {
    }
}
