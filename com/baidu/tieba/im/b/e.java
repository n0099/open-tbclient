package com.baidu.tieba.im.b;

import java.util.Map;
/* loaded from: classes.dex */
class e implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ b bYR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.bYR = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean k(int i, String str) {
        this.bYR.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void b(Map<String, String> map) {
        this.bYR.start();
        com.baidu.adp.framework.client.socket.g.et().a(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void s(byte[] bArr) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void I(String str) {
    }
}
