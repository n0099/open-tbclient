package com.baidu.tieba.im.b;

import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ b cnQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.cnQ = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        this.cnQ.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void c(Map<String, String> map) {
        this.cnQ.start();
        com.baidu.adp.framework.client.socket.g.ex().b(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void H(String str) {
    }
}
