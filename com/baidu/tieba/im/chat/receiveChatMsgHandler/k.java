package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class k {
    public static boolean St = true;

    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, c cVar) {
        a.a(groupMsgData, imMessageCenterPojo, cVar, new l(), ChatStatusManager.getInst().getIsOpen(4));
    }
}
