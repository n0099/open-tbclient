package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import com.baidu.tbadk.j.aa;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ n axk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.axk = nVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.axk.axg;
        if (eVar != null) {
            eVar2 = this.axk.axg;
            eVar2.a(aVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.axk.axg;
        if (eVar != null) {
            eVar2 = this.axk.axg;
            eVar2.d(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void d(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        UpdateClientInfoMessage BF;
        UpdateClientInfoMessage updateClientInfoMessage;
        int i;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.axk.axg;
        if (eVar != null) {
            eVar2 = this.axk.axg;
            eVar2.d(map);
        }
        com.baidu.adp.framework.client.socket.k.a("TbOnline", 1001, 0, "begin_online", 0, "begin online");
        if (aa.FK().FL()) {
            n nVar = this.axk;
            i = nVar.axj;
            int i2 = i + 1;
            nVar.axj = i2;
            if (i2 < 10) {
                com.baidu.adp.framework.client.socket.k.db();
            }
        }
        n nVar2 = this.axk;
        BF = this.axk.BF();
        nVar2.axh = BF;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.axk.axh;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.axk.axg;
        if (eVar != null) {
            eVar2 = this.axk.axg;
            eVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void x(String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.axk.axg;
        if (eVar != null) {
            eVar2 = this.axk.axg;
            eVar2.x(str);
        }
    }
}
