package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0063a {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.InterfaceC0063a
    public boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo) {
        if (chatMessage != null && chatMessage.getMsgType() == 22) {
            if (com.baidu.tieba.im.util.h.r(chatMessage)) {
                return true;
            }
            long f = j.f(chatMessage);
            if (f > imMessageCenterPojo.getRead_msgId()) {
                imMessageCenterPojo.setRead_msgId(f);
                return true;
            }
            return true;
        }
        return false;
    }
}
