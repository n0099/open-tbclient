package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.message.SocketMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y extends com.baidu.adp.framework.a.j {
    final /* synthetic */ w a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(w wVar, int i) {
        super(i);
        this.a = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        int i;
        int i2;
        if (socketResponsedMessage instanceof ResponseOnlineMessage) {
            ResponseOnlineMessage responseOnlineMessage = (ResponseOnlineMessage) socketResponsedMessage;
            int squencedId = (responseOnlineMessage.getOrginalMessage() == null || !(responseOnlineMessage.getOrginalMessage() instanceof SocketMessage)) ? 0 : ((SocketMessage) responseOnlineMessage.getOrginalMessage()).getSquencedId();
            if (responseOnlineMessage.getError() == 0) {
                this.a.f();
                int cmd = socketResponsedMessage.getCmd();
                StringBuilder sb = new StringBuilder("online succ. retry count-");
                i = this.a.a;
                com.baidu.adp.framework.client.socket.m.a("TbOnline", cmd, squencedId, "online_succ", 0, sb.append(i).toString());
                BdLog.i("----online succ");
                return socketResponsedMessage;
            }
            this.a.a(socketResponsedMessage.getCmd(), responseOnlineMessage.getError(), responseOnlineMessage.getErrorString());
            int cmd2 = socketResponsedMessage.getCmd();
            StringBuilder sb2 = new StringBuilder("online failed. count-");
            i2 = this.a.a;
            com.baidu.adp.framework.client.socket.m.a("TbOnline", cmd2, 0, "online_failed", 0, sb2.append(i2).toString());
            return null;
        }
        this.a.a(socketResponsedMessage.getCmd(), -1, null);
        return null;
    }
}
