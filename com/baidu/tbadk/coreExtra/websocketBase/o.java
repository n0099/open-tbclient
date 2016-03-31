package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.webSocket.m;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ n arO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.arO = nVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(m.a aVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.arO.arL;
        if (eVar != null) {
            eVar2 = this.arO.arL;
            eVar2.a(aVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean d(int i, String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.arO.arL;
        if (eVar != null) {
            eVar2 = this.arO.arL;
            eVar2.d(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void c(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        UpdateClientInfoMessage Cv;
        UpdateClientInfoMessage updateClientInfoMessage;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.arO.arL;
        if (eVar != null) {
            eVar2 = this.arO.arL;
            eVar2.c(map);
        }
        com.baidu.adp.framework.client.socket.k.a("TbOnline", (int) BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, 0, "begin_online", 0, "begin online");
        n nVar = this.arO;
        Cv = this.arO.Cv();
        nVar.arM = Cv;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.arO.arM;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.arO.arL;
        if (eVar != null) {
            eVar2 = this.arO.arL;
            eVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void H(String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.arO.arL;
        if (eVar != null) {
            eVar2 = this.arO.arL;
            eVar2.H(str);
        }
    }
}
