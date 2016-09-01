package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements a.InterfaceC0064a {
    @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.InterfaceC0064a
    public boolean a(ChatMessage chatMessage, ImMessageCenterPojo imMessageCenterPojo) {
        if (chatMessage != null && chatMessage.getMsgType() == 22) {
            if (com.baidu.tieba.im.util.h.t(chatMessage)) {
                return true;
            }
            long h = j.h(chatMessage);
            if (h > imMessageCenterPojo.getRead_msgId()) {
                imMessageCenterPojo.setRead_msgId(h);
                return true;
            }
            return true;
        }
        return false;
    }
}
