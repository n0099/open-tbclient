package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class e {
    public static boolean aui = true;

    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new a.c() { // from class: com.baidu.tieba.im.chat.receiveChatMsgHandler.e.1
            @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
            public boolean lH(String str) {
                return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(1) && str.equals(ChatStatusManager.getInst().getCurId(1));
            }
        }, ChatStatusManager.getInst().getIsOpen(4));
    }
}
