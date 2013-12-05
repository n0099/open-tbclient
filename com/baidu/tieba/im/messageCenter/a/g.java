package com.baidu.tieba.im.messageCenter.a;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.messageCenter.a {
    @Override // com.baidu.tieba.im.messageCenter.a
    public Message a(Message message, com.baidu.tieba.im.b.p pVar) {
        if (message != null && (message instanceof ResponseGroupInfoMessage)) {
            ResponseGroupInfoMessage responseGroupInfoMessage = (ResponseGroupInfoMessage) message;
            if (responseGroupInfoMessage.getGroup() != null && !responseGroupInfoMessage.hasError()) {
                String str = "";
                if (TiebaApplication.F() != null) {
                    str = TiebaApplication.F().getID();
                }
                com.baidu.tieba.im.b.m.a(com.baidu.tieba.b.a.a().q(), "group_info" + str + responseGroupInfoMessage.getGroup().getGroupId(), pVar);
            }
        }
        return null;
    }
}
