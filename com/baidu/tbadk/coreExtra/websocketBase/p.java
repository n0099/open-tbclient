package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.a.j {
    final /* synthetic */ n aoE;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(n nVar, int i) {
        super(i);
        this.aoE = nVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    /* renamed from: d */
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        int i;
        int i2;
        int i3;
        if (socketResponsedMessage instanceof ResponseOnlineMessage) {
            ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
            long j = 0;
            if (responseOnlineMessage.getOrginalMessage() == null || !(responseOnlineMessage.getOrginalMessage() instanceof SocketMessage)) {
                i = 0;
            } else {
                i = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getSquencedId();
                j = ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getClientLogID();
            }
            if (responseOnlineMessage.getError() == 0) {
                this.aoE.Ac();
                int cmd = socketResponsedMessage.getCmd();
                StringBuilder sb = new StringBuilder("online succ. retry count-");
                i2 = this.aoE.aoA;
                com.baidu.adp.framework.client.socket.k.a("TbOnline", cmd, j, i, "online_succ", 0, sb.append(i2).toString());
                return socketResponsedMessage;
            }
            this.aoE.b(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
            int cmd2 = socketResponsedMessage.getCmd();
            StringBuilder sb2 = new StringBuilder("online failed. count-");
            i3 = this.aoE.aoA;
            com.baidu.adp.framework.client.socket.k.a("TbOnline", cmd2, j, 0, "online_failed", 0, sb2.append(i3).toString());
            return null;
        }
        this.aoE.b(socketResponsedMessage.getCmd(), -1, null);
        return null;
    }
}
