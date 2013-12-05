package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestHotGroupsMessage;
import com.baidu.tieba.im.message.ResponseHotGroupsMessage;
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, com.baidu.tieba.im.b.p pVar) {
        if (message != null && (message instanceof ResponseHotGroupsMessage)) {
            ResponseHotGroupsMessage responseHotGroupsMessage = (ResponseHotGroupsMessage) message;
            if (!responseHotGroupsMessage.hasError() && (responseHotGroupsMessage.getOrginalMessage() instanceof RequestHotGroupsMessage) && ((RequestHotGroupsMessage) responseHotGroupsMessage.getOrginalMessage()).isFirstPage()) {
                String str = "";
                if (TiebaApplication.F() != null) {
                    str = TiebaApplication.F().getID();
                }
                com.baidu.tieba.im.b.m.a(com.baidu.tieba.b.a.a().f(), "hot_groups_info" + str, pVar);
            }
        }
        return null;
    }
}
