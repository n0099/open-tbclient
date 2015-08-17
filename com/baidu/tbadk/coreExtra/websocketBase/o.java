package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.framework.client.socket.link.e {
    final /* synthetic */ n amS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.amS = nVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void s(byte[] bArr) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.amS.amP;
        if (eVar != null) {
            eVar2 = this.amS.amP;
            eVar2.s(bArr);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public boolean k(int i, String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.amS.amP;
        if (eVar != null) {
            eVar2 = this.amS.amP;
            eVar2.k(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void b(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        UpdateClientInfoMessage zM;
        UpdateClientInfoMessage updateClientInfoMessage;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.amS.amP;
        if (eVar != null) {
            eVar2 = this.amS.amP;
            eVar2.b(map);
        }
        com.baidu.adp.framework.client.socket.k.a("TbOnline", (int) BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, 0, "begin_online", 0, "begin online");
        n nVar = this.amS;
        zM = this.amS.zM();
        nVar.amQ = zM;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.amS.amQ;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.amS.amP;
        if (eVar != null) {
            eVar2 = this.amS.amP;
            eVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.e
    public void I(String str) {
        com.baidu.adp.framework.client.socket.link.e eVar;
        com.baidu.adp.framework.client.socket.link.e eVar2;
        eVar = this.amS.amP;
        if (eVar != null) {
            eVar2 = this.amS.amP;
            eVar2.I(str);
        }
    }
}
