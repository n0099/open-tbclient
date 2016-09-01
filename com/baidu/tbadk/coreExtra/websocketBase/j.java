package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.webSocket.g;
import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements g.a {
    final /* synthetic */ i arX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.arX = iVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(Map<String, String> map) {
        int i;
        i = this.arX.arS;
        if (i >= 5) {
            com.baidu.adp.framework.client.socket.k.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.j.getUrl());
            a.Bm().eT(com.baidu.adp.framework.client.socket.j.getUrl());
            a.Bm().Bq();
        }
        this.arX.arS = 0;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void e(int i, String str) {
        int i2;
        int i3;
        if ((i == 2 || i == 9) && com.baidu.adp.lib.util.i.gm()) {
            i iVar = this.arX;
            i2 = iVar.arS;
            iVar.arS = i2 + 1;
            i3 = this.arX.arS;
            if (i3 >= 5) {
                com.baidu.adp.framework.client.socket.k.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                this.arX.BI();
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void gZ() {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void B(String str) {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void r(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(m.a aVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void b(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(int i, com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(com.baidu.adp.lib.webSocket.c cVar) {
    }
}
