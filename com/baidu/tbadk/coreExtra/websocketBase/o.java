package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.performanceLog.aa;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ n asK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.asK = nVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asK.asG;
        if (eVar != null) {
            eVar2 = this.asK.asG;
            eVar2.a(aVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean c(int i, String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asK.asG;
        if (eVar != null) {
            eVar2 = this.asK.asG;
            eVar2.c(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        UpdateClientInfoMessage BV;
        UpdateClientInfoMessage updateClientInfoMessage;
        int i;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asK.asG;
        if (eVar != null) {
            eVar2 = this.asK.asG;
            eVar2.d(map);
        }
        com.baidu.adp.framework.client.socket.k.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
        if (aa.Gu().Gv()) {
            n nVar = this.asK;
            i = nVar.asJ;
            int i2 = i + 1;
            nVar.asJ = i2;
            if (i2 < 10) {
                com.baidu.adp.framework.client.socket.k.bT();
            }
        }
        n nVar2 = this.asK;
        BV = this.asK.BV();
        nVar2.asH = BV;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.asK.asH;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asK.asG;
        if (eVar != null) {
            eVar2 = this.asK.asG;
            eVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void B(String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asK.asG;
        if (eVar != null) {
            eVar2 = this.asK.asG;
            eVar2.B(str);
        }
    }
}
