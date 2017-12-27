package com.baidu.tieba.im.chat.receiveChatMsgHandler;

import android.text.TextUtils;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.a;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
/* loaded from: classes.dex */
public class SnapChatMsgHelper extends b {
    public static void a(GroupMsgData groupMsgData, ImMessageCenterPojo imMessageCenterPojo, a.b bVar) {
        a.a(groupMsgData, imMessageCenterPojo, bVar, new a.c() { // from class: com.baidu.tieba.im.chat.receiveChatMsgHandler.SnapChatMsgHelper.1
            boolean eth = ChatStatusManager.getInst().getIsOpen(3);
            String bAE = ChatStatusManager.getInst().getCurId(3);

            @Override // com.baidu.tieba.im.chat.receiveChatMsgHandler.a.c
            public boolean mw(String str) {
                return !TextUtils.isEmpty(str) && this.eth && str.equals(this.bAE);
            }
        }, false);
    }
}
