package com.baidu.tieba.im.chat.b;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.b.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class b {
    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new a.c() { // from class: com.baidu.tieba.im.chat.b.b.1
            @Override // com.baidu.tieba.im.chat.b.a.c
            public boolean Mz(String str) {
                return !TextUtils.isEmpty(str) && ChatStatusManager.getInst().getIsOpen(2) && str.equals(ChatStatusManager.getInst().getCurId(2));
            }
        }, false);
    }
}
