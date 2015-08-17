package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class l implements a.InterfaceC0058a {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.InterfaceC0058a
    public boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo) {
        if (chatMessage != null && chatMessage.getMsgType() == 22) {
            if (com.baidu.tieba.im.util.h.s(chatMessage)) {
                return true;
            }
            long g = j.g(chatMessage);
            if (g > imMessageCenterPojo.getRead_msgId()) {
                imMessageCenterPojo.setRead_msgId(g);
                return true;
            }
            return true;
        }
        return false;
    }
}
