package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class g {
    public static void a(GroupMsgData groupMsgData) {
        String valueOf = String.valueOf(groupMsgData.getGroupInfo().getGroupId());
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage != null && listMessage.size() > 0) {
            LinkedList linkedList = new LinkedList();
            for (ChatMessage chatMessage : listMessage) {
                chatMessage.setLocalData(new MsgLocalData());
                chatMessage.getLocalData().setStatus((short) 3);
                if (chatMessage instanceof CommonGroupChatMessage) {
                    CommonMsgPojo commonMsgPojo = new CommonMsgPojo(chatMessage);
                    a.a(valueOf, chatMessage);
                    if (a.a(chatMessage)) {
                        commonMsgPojo.setRead_flag(0);
                    } else {
                        commonMsgPojo.setRead_flag(1);
                    }
                    linkedList.add(commonMsgPojo);
                } else {
                    return;
                }
            }
            CommonMsgPojo commonMsgPojo2 = (CommonMsgPojo) linkedList.getLast();
            commonMsgPojo2.checkRidAndSelf();
            com.baidu.tieba.im.i.a(new h(valueOf, linkedList), new i(groupMsgData, valueOf, commonMsgPojo2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(GroupMsgData groupMsgData, String str, CommonMsgPojo commonMsgPojo) {
        com.baidu.tieba.im.b.a.a().a(str, 0, commonMsgPojo, true);
        com.baidu.tieba.im.chat.w.b().a(groupMsgData);
    }
}
