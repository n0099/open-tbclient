package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class o implements b {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.b
    public boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo) {
        if (chatMessage != null && chatMessage.getMsgType() == 22) {
            if (com.baidu.tieba.im.util.i.s(chatMessage)) {
                return true;
            }
            long m = m.m(chatMessage);
            if (m > imMessageCenterPojo.getRead_msgId()) {
                imMessageCenterPojo.setRead_msgId(m);
                return true;
            }
            return true;
        }
        return false;
    }
}
