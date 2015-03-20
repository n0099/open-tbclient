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
            long g = m.g(chatMessage);
            if (g > imMessageCenterPojo.getRead_msgId()) {
                imMessageCenterPojo.setRead_msgId(g);
                return true;
            }
            return true;
        }
        return false;
    }
}
