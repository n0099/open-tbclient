package com.baidu.tieba.im.b;

import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ b dfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.dfa = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        this.dfa.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        this.dfa.start();
        com.baidu.adp.framework.client.socket.g.cP().c(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void x(String str) {
    }
}
