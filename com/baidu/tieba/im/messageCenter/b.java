package com.baidu.tieba.im.messageCenter;

import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.im.message.ChatResponsedMessage;
import com.baidu.tieba.im.message.ResponseFrsGroupsMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.message.ResponseOnlineMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
/* loaded from: classes.dex */
public class b {
    public static void a(TiebaApplication tiebaApplication) {
        f a2 = f.a();
        a2.c(1001, ResponseOnlineMessage.class);
        a2.c(202003, ResponsedMessage.class);
        a2.c(1003, ResponsedMessage.class);
        a2.c(103004, ResponseGroupInfoMessage.class);
        a2.c(103111, ResponsedMessage.class);
        a2.c(103102, ResponsedMessage.class);
        a2.c(103003, ResponseGroupsByUidMessage.class);
        a2.c(202001, ChatResponsedMessage.class);
        a2.c(103103, ResponseReportGroupMessage.class);
        a2.c(103005, ResponseMembersMessage.class);
        a2.c(103002, ResponseFrsGroupsMessage.class);
        a2.c(103006, ResponseGroupLevelMessage.class);
        a2.c(103112, ResponseRemoveMembersMessage.class);
        a2.c(103008, ResponseUserPermissionMessage.class);
    }
}
