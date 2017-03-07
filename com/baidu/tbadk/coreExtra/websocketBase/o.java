package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.performanceLog.aa;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ n awN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.awN = nVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.awN.awJ;
        if (eVar != null) {
            eVar2 = this.awN.awJ;
            eVar2.a(aVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.awN.awJ;
        if (eVar != null) {
            eVar2 = this.awN.awJ;
            eVar2.d(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        UpdateClientInfoMessage BW;
        UpdateClientInfoMessage updateClientInfoMessage;
        int i;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.awN.awJ;
        if (eVar != null) {
            eVar2 = this.awN.awJ;
            eVar2.d(map);
        }
        com.baidu.adp.framework.client.socket.k.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
        if (aa.Gi().Gj()) {
            n nVar = this.awN;
            i = nVar.awM;
            int i2 = i + 1;
            nVar.awM = i2;
            if (i2 < 10) {
                com.baidu.adp.framework.client.socket.k.dc();
            }
        }
        n nVar2 = this.awN;
        BW = this.awN.BW();
        nVar2.awK = BW;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.awN.awK;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.awN.awJ;
        if (eVar != null) {
            eVar2 = this.awN.awJ;
            eVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void A(String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.awN.awJ;
        if (eVar != null) {
            eVar2 = this.awN.awJ;
            eVar2.A(str);
        }
    }
}
