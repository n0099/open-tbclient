package com.baidu.tbadk.coreExtra.d;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.coreExtra.message.GroupUpdateMessage;
import com.baidu.tbadk.coreExtra.message.ResponseOnlineMessage;
/* loaded from: classes.dex */
public final class p extends com.baidu.adp.framework.b.m {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.framework.message.f' to match base method */
    @Override // com.baidu.adp.framework.b.i
    public final /* synthetic */ SocketResponsedMessage a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 instanceof ResponseOnlineMessage) {
            for (GroupUpdateMessage groupUpdateMessage : ((ResponseOnlineMessage) socketResponsedMessage2).d()) {
                com.baidu.tbadk.coreExtra.messageCenter.d.a().b(groupUpdateMessage.getGroupId(), groupUpdateMessage.getLastMsgId());
            }
            return socketResponsedMessage2;
        }
        return null;
    }

    public p() {
        super(1001);
    }
}
