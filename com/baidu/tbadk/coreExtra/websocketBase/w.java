package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.MessageManager;
import com.baidu.location.BDLocationStatusCodes;
import com.baidu.tbadk.coreExtra.message.UpdateClientInfoMessage;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.adp.framework.client.socket.link.g {
    final /* synthetic */ v ahM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.ahM = vVar;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void e(byte[] bArr) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.ahM.ahJ;
        if (gVar != null) {
            gVar2 = this.ahM.ahJ;
            gVar2.e(bArr);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public boolean k(int i, String str) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.ahM.ahJ;
        if (gVar != null) {
            gVar2 = this.ahM.ahJ;
            gVar2.k(i, str);
            return false;
        }
        return false;
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void c(Map<String, String> map) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        UpdateClientInfoMessage yB;
        UpdateClientInfoMessage updateClientInfoMessage;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.ahM.ahJ;
        if (gVar != null) {
            gVar2 = this.ahM.ahJ;
            gVar2.c(map);
        }
        com.baidu.adp.framework.client.socket.m.a("TbOnline", (int) BDLocationStatusCodes.GEOFENCE_TOO_MANY_GEOFENCES, 0, "begin_online", 0, "begin online");
        v vVar = this.ahM;
        yB = this.ahM.yB();
        vVar.ahK = yB;
        MessageManager messageManager = MessageManager.getInstance();
        updateClientInfoMessage = this.ahM.ahK;
        messageManager.sendMessage(updateClientInfoMessage);
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void a(com.baidu.adp.lib.webSocket.c cVar) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.ahM.ahJ;
        if (gVar != null) {
            gVar2 = this.ahM.ahJ;
            gVar2.a(cVar);
        }
    }

    @Override // com.baidu.adp.framework.client.socket.link.g
    public void J(String str) {
        com.baidu.adp.framework.client.socket.link.g gVar;
        com.baidu.adp.framework.client.socket.link.g gVar2;
        gVar = this.ahM.ahJ;
        if (gVar != null) {
            gVar2 = this.ahM.ahJ;
            gVar2.J(str);
        }
    }
}
