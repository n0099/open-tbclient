package com.baidu.tbadk.coreExtra.websocketBase;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* loaded from: classes.dex */
public class p extends com.baidu.adp.framework.a.j {
    public p() {
        super(1001);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.a.g
    public SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        if (!(socketResponsedMessage instanceof ResponseOnlineMessage)) {
            return null;
        }
        for (GroupUpdateMessage groupUpdateMessage : ((ResponseOnlineMessage) socketResponsedMessage).getGroupInfos()) {
            com.baidu.tbadk.coreExtra.messageCenter.e.a().b(groupUpdateMessage.getGroupId(), groupUpdateMessage.getLastMsgId());
        }
        return socketResponsedMessage;
    }
}
