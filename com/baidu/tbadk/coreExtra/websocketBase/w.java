package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.adp.framework.client.socket.link.g {
    final /* synthetic */ v WA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.WA = vVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void e(byte[] bArr) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.WA.Wx;
        if (gVar != null) {
            gVar2 = this.WA.Wx;
            gVar2.e(bArr);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.WA.Wx;
        if (gVar != null) {
            gVar2 = this.WA.Wx;
            gVar2.k(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        UpdateClientInfoMessage ux;
        UpdateClientInfoMessage updateClientInfoMessage;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.WA.Wx;
        if (gVar != null) {
            gVar2 = this.WA.Wx;
            gVar2.c(map);
        }
        com.baidu.adp.framework.client.socket.m.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
        v vVar = this.WA;
        ux = this.WA.ux();
        vVar.Wy = ux;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.WA.Wy;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.d dVar) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.WA.Wx;
        if (gVar != null) {
            gVar2 = this.WA.Wx;
            gVar2.a(dVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void y(String str) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.WA.Wx;
        if (gVar != null) {
            gVar2 = this.WA.Wx;
            gVar2.y(str);
        }
    }
}
