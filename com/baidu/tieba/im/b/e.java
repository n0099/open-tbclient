package com.baidu.tieba.im.b;

import com.baidu.adp.lib.webSocket.m;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ b dpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.dpO = bVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean c(int i, String str) {
        this.dpO.stop();
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        this.dpO.start();
        com.baidu.adp.framework.client.socket.g.bH().c(map);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void B(String str) {
    }
}
