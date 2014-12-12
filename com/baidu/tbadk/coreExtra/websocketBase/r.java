package com.baidu.tbadk.coreExtra.websocketBase;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements com.baidu.adp.lib.webSocket.l {
    final /* synthetic */ q VO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.VO = qVar;
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void d(Map<String, String> map) {
        int i;
        i = this.VO.VJ;
        if (i >= 5) {
            com.baidu.adp.framework.client.socket.m.a("RetryIpListManager", 0, 0, "retry_iplist_succ", 0, "URL-" + com.baidu.adp.framework.client.socket.l.getUrl());
            a.tJ().dK(com.baidu.adp.framework.client.socket.l.getUrl());
            a.tJ().tN();
        }
        this.VO.VJ = 0;
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void l(int i, String str) {
        int i2;
        int i3;
        if ((i == 2 || i == 9) && com.baidu.adp.lib.util.i.fg()) {
            q qVar = this.VO;
            i2 = qVar.VJ;
            qVar.VJ = i2 + 1;
            i3 = this.VO.VJ;
            if (i3 >= 5) {
                com.baidu.adp.framework.client.socket.m.a("RetryIpListManager", 0, 0, "retry_iplist", 0, "retryiplist");
                this.VO.ue();
            }
        }
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void fU() {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void y(String str) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void r(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.webSocket.l
    public void i(byte[] bArr) {
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
