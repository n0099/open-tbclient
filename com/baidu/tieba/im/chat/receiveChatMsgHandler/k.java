package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class k {
    public static boolean LU = true;

    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, c cVar) {
        a.a(groupMsgData, imMessageCenterPojo, cVar, new l(), OfficialBarTipActivity.isOpen);
    }
}
