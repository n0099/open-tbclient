package com.baidu.tieba.im.chat.b;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.b.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class d {
    public static void b(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new a.c() { // from class: com.baidu.tieba.im.chat.b.d.1
            @Override // com.baidu.tieba.im.chat.b.a.c
            public boolean FU(String str) {
                return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(1) && str.equals(ChatStatusManager.getInst().getCurId(1));
            }
        }, ChatStatusManager.getInst().getIsOpen(4));
    }
}
