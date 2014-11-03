package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.adp.framework.client.socket.link.g {
    final /* synthetic */ v Qk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.Qk = vVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void d(byte[] bArr) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.Qk.Qh;
        if (gVar != null) {
            gVar2 = this.Qk.Qh;
            gVar2.d(bArr);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean a(int i, String str) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.Qk.Qh;
        if (gVar != null) {
            gVar2 = this.Qk.Qh;
            gVar2.a(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void b(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        UpdateClientInfoMessage qO;
        UpdateClientInfoMessage updateClientInfoMessage;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.Qk.Qh;
        if (gVar != null) {
            gVar2 = this.Qk.Qh;
            gVar2.b(map);
        }
        com.baidu.adp.framework.client.socket.m.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
        v vVar = this.Qk;
        qO = this.Qk.qO();
        vVar.Qi = qO;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.Qk.Qi;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.Qk.Qh;
        if (gVar != null) {
            gVar2 = this.Qk.Qh;
            gVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void j(String str) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.Qk.Qh;
        if (gVar != null) {
            gVar2 = this.Qk.Qh;
            gVar2.j(str);
        }
    }
}
