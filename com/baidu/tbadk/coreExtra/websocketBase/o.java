package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.performanceLog.aa;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ n ars;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.ars = nVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.ars.aro;
        if (eVar != null) {
            eVar2 = this.ars.aro;
            eVar2.a(aVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean c(int i, String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.ars.aro;
        if (eVar != null) {
            eVar2 = this.ars.aro;
            eVar2.c(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        UpdateClientInfoMessage BD;
        UpdateClientInfoMessage updateClientInfoMessage;
        int i;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.ars.aro;
        if (eVar != null) {
            eVar2 = this.ars.aro;
            eVar2.d(map);
        }
        com.baidu.adp.framework.client.socket.k.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
        if (aa.FO().FP()) {
            n nVar = this.ars;
            i = nVar.arr;
            int i2 = i + 1;
            nVar.arr = i2;
            if (i2 < 10) {
                com.baidu.adp.framework.client.socket.k.bT();
            }
        }
        n nVar2 = this.ars;
        BD = this.ars.BD();
        nVar2.arp = BD;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.ars.arp;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.ars.aro;
        if (eVar != null) {
            eVar2 = this.ars.aro;
            eVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void B(String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.ars.aro;
        if (eVar != null) {
            eVar2 = this.ars.aro;
            eVar2.B(str);
        }
    }
}
