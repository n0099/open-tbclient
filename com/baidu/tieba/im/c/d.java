package com.baidu.tieba.im.c;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements com.baidu.adp.lib.network.websocket.c {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final boolean a(int i, String str) {
        com.baidu.adp.lib.util.f.b("errorCode=" + i + "|errorString=" + str);
        this.a.d();
        return false;
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(Map<String, String> map) {
        this.a.c();
        com.baidu.tbadk.a.a.a().a(map);
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(String str) {
    }
}
