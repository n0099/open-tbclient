package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ n aqE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.aqE = nVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void s(byte[] bArr) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.aqE.aqB;
        if (eVar != null) {
            eVar2 = this.aqE.aqB;
            eVar2.s(bArr);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean k(int i, String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.aqE.aqB;
        if (eVar != null) {
            eVar2 = this.aqE.aqB;
            eVar2.k(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void b(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        UpdateClientInfoMessage AC;
        UpdateClientInfoMessage updateClientInfoMessage;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.aqE.aqB;
        if (eVar != null) {
            eVar2 = this.aqE.aqB;
            eVar2.b(map);
        }
        com.baidu.adp.framework.client.socket.k.a("TbOnline", (int) BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, 0, "begin_online", 0, "begin online");
        n nVar = this.aqE;
        AC = this.aqE.AC();
        nVar.aqC = AC;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.aqE.aqC;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.aqE.aqB;
        if (eVar != null) {
            eVar2 = this.aqE.aqB;
            eVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void I(String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.aqE.aqB;
        if (eVar != null) {
            eVar2 = this.aqE.aqB;
            eVar2.I(str);
        }
    }
}
