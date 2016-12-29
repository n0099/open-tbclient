package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.performanceLog.aa;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ n asn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.asn = nVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asn.asj;
        if (eVar != null) {
            eVar2 = this.asn.asj;
            eVar2.a(aVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean c(int i, String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asn.asj;
        if (eVar != null) {
            eVar2 = this.asn.asj;
            eVar2.c(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        UpdateClientInfoMessage BI;
        UpdateClientInfoMessage updateClientInfoMessage;
        int i;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asn.asj;
        if (eVar != null) {
            eVar2 = this.asn.asj;
            eVar2.d(map);
        }
        com.baidu.adp.framework.client.socket.k.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
        if (aa.FU().FV()) {
            n nVar = this.asn;
            i = nVar.asm;
            int i2 = i + 1;
            nVar.asm = i2;
            if (i2 < 10) {
                com.baidu.adp.framework.client.socket.k.bT();
            }
        }
        n nVar2 = this.asn;
        BI = this.asn.BI();
        nVar2.ask = BI;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.asn.ask;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asn.asj;
        if (eVar != null) {
            eVar2 = this.asn.asj;
            eVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void B(String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.asn.asj;
        if (eVar != null) {
            eVar2 = this.asn.asj;
            eVar2.B(str);
        }
    }
}
