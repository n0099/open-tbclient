package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.lib.webSocket.g;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements g.a {
    final /* synthetic */ i aoT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.aoT = iVar;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void c(Map<String, String> map) {
        int i;
        i = this.aoT.aoO;
        if (i >= 5) {
            com.baidu.adp.framework.client.socket.k.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.j.getUrl());
            a.Ao().eI(com.baidu.adp.framework.client.socket.j.getUrl());
            a.Ao().As();
        }
        this.aoT.aoO = 0;
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void l(int i, String str) {
        int i2;
        int i3;
        if ((i == 2 || i == 9) && com.baidu.adp.lib.util.i.iP()) {
            i iVar = this.aoT;
            i2 = iVar.aoO;
            iVar.aoO = i2 + 1;
            i3 = this.aoT.aoO;
            if (i3 >= 5) {
                com.baidu.adp.framework.client.socket.k.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                this.aoT.AK();
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void jA() {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void I(String str) {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void F(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.webSocket.g.a
    public void w(byte[] bArr) {
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
