package com.baidu.tieba.im.c;

import com.baidu.adp.lib.util.BdLog;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.lib.network.websocket.c {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public boolean a(int i, String str) {
        BdLog.e("errorCode=" + i + "|errorString=" + str);
        this.a.d();
        return false;
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public void a(Map<String, String> map) {
        this.a.c();
        com.baidu.tbadk.a.a.a().a(map);
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public void a(byte[] bArr) {
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
    }

    @Override // com.baidu.adp.lib.network.websocket.c
    public void a(String str) {
    }
}
