package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class d {
    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new a.c() { // from class: com.baidu.tieba.im.chat.receiveChatMsgHandler.d.1
            @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
            public boolean md(String str) {
                return true;
            }
        }, false);
    }
}
