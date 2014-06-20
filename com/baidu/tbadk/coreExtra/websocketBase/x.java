package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.adp.framework.client.socket.link.c {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar) {
        this.a = wVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(byte[] bArr) {
        com.baidu.adp.framework.client.socket.link.c cVar;
        com.baidu.adp.framework.client.socket.link.c cVar2;
        cVar = this.a.b;
        if (cVar != null) {
            cVar2 = this.a.b;
            cVar2.a(bArr);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public boolean a(int i, String str) {
        com.baidu.adp.framework.client.socket.link.c cVar;
        com.baidu.adp.framework.client.socket.link.c cVar2;
        cVar = this.a.b;
        if (cVar != null) {
            cVar2 = this.a.b;
            cVar2.a(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.c cVar;
        UpdateClientInfoMessage e;
        UpdateClientInfoMessage updateClientInfoMessage;
        com.baidu.adp.framework.client.socket.link.c cVar2;
        cVar = this.a.b;
        if (cVar != null) {
            cVar2 = this.a.b;
            cVar2.a(map);
        }
        BdLog.i("start online");
        com.baidu.adp.framework.client.socket.m.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
        w wVar = this.a;
        e = this.a.e();
        wVar.c = e;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.a.c;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        com.baidu.adp.framework.client.socket.link.c cVar;
        com.baidu.adp.framework.client.socket.link.c cVar2;
        cVar = this.a.b;
        if (cVar != null) {
            cVar2 = this.a.b;
            cVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.c
    public void a(String str) {
        com.baidu.adp.framework.client.socket.link.c cVar;
        com.baidu.adp.framework.client.socket.link.c cVar2;
        cVar = this.a.b;
        if (cVar != null) {
            cVar2 = this.a.b;
            cVar2.a(str);
        }
    }
}
