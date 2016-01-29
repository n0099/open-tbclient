package com.baidu.tieba.im.b;

import java.util.Map;
/* loaded from: classes.dex */
class e implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ b cdl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.cdl = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean k(int i, String str) {
        this.cdl.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void c(Map<String, String> map) {
        this.cdl.start();
        com.baidu.adp.framework.client.socket.g.ex().b(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void s(byte[] bArr) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void H(String str) {
    }
}
