package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.adp.lib.webSocket.k {
    final /* synthetic */ q agE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.agE = qVar;
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void d(Map<String, String> map) {
        int i;
        i = this.agE.agz;
        if (i >= 5) {
            com.baidu.adp.framework.client.socket.m.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.l.getUrl());
            a.xr().dS(com.baidu.adp.framework.client.socket.l.getUrl());
            a.xr().xv();
        }
        this.agE.agz = 0;
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void l(int i, String str) {
        int i2;
        int i3;
        if ((i == 2 || i == 9) && com.baidu.adp.lib.util.k.iH()) {
            q qVar = this.agE;
            i2 = qVar.agz;
            qVar.agz = i2 + 1;
            i3 = this.agE.agz;
            if (i3 >= 5) {
                com.baidu.adp.framework.client.socket.m.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                this.agE.xM();
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void jq() {
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void G(String str) {
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void s(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void j(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void b(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void a(int i, com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.k
    public void c(com.baidu.adp.lib.webSocket.c cVar) {
    }
}
