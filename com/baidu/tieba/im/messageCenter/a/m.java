package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseNearbyGroupsMessage;
/* loaded from: classes.dex */
public class m extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, com.baidu.tieba.im.b.p pVar) {
        if (message != null && (message instanceof ResponseNearbyGroupsMessage)) {
            ResponseNearbyGroupsMessage responseNearbyGroupsMessage = (ResponseNearbyGroupsMessage) message;
            if (!responseNearbyGroupsMessage.hasError() && (responseNearbyGroupsMessage.getNearbyGroups() == null || responseNearbyGroupsMessage.getNearbyGroups().getOffset() == 0)) {
                String str = "";
                if (TiebaApplication.F() != null) {
                    str = TiebaApplication.F().getID();
                }
                com.baidu.tieba.im.b.m.a(com.baidu.tieba.b.a.a().r(), "nearby_group_info" + str, pVar);
            }
        }
        return null;
    }
}
