package com.baidu.tbadk.coreExtra.d;

import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r implements com.baidu.adp.lib.network.websocket.c {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.a = qVar;
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(byte[] bArr) {
        com.baidu.adp.lib.network.websocket.c cVar;
        com.baidu.adp.lib.network.websocket.c cVar2;
        cVar = this.a.c;
        if (cVar != null) {
            cVar2 = this.a.c;
            cVar2.a(bArr);
        }
        m.a().b();
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final boolean a(int i, String str) {
        com.baidu.adp.lib.network.websocket.c cVar;
        com.baidu.adp.lib.network.websocket.c cVar2;
        cVar = this.a.c;
        if (cVar != null) {
            cVar2 = this.a.c;
            cVar2.a(i, str);
        }
        com.baidu.adp.lib.util.f.b("errorCode=" + i + "|errorString=" + str);
        return false;
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(Map<String, String> map) {
        com.baidu.adp.lib.network.websocket.c cVar;
        com.baidu.adp.lib.network.websocket.c cVar2;
        cVar = this.a.c;
        if (cVar != null) {
            cVar2 = this.a.c;
            cVar2.a(map);
        }
        this.a.e();
        m.a().b();
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(com.baidu.adp.lib.webSocket.d dVar) {
        com.baidu.adp.lib.network.websocket.c cVar;
        com.baidu.adp.lib.network.websocket.c cVar2;
        cVar = this.a.c;
        if (cVar != null) {
            cVar2 = this.a.c;
            cVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public final void a(String str) {
        com.baidu.adp.lib.network.websocket.c cVar;
        com.baidu.adp.lib.network.websocket.c cVar2;
        cVar = this.a.c;
        if (cVar != null) {
            cVar2 = this.a.c;
            cVar2.a(str);
        }
    }
}
