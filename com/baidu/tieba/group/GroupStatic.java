package com.baidu.tieba.group;

import com.baidu.tieba.im.c;
import com.baidu.tieba.im.c.a.d;
import com.baidu.tieba.im.c.a.h;
import com.baidu.tieba.im.groupInfo.ResponseJoinGroupMessage;
import com.baidu.tieba.im.message.ResponseCreateGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseDelGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGetGroupActivityMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupLevelMessage;
import com.baidu.tieba.im.message.ResponseMembersMessage;
import com.baidu.tieba.im.message.ResponseReportGroupMessage;
import com.baidu.tieba.im.message.ResponseRequestGroupLocMessage;
/* loaded from: classes3.dex */
public class GroupStatic {
    static {
        c.b(103110, ResponseJoinGroupMessage.class, false);
        c.b(103103, ResponseReportGroupMessage.class, false);
        c.b(103005, ResponseMembersMessage.class, false);
        c.b(103006, ResponseGroupLevelMessage.class, false);
        c.b(103010, ResponseRequestGroupLocMessage.class, false);
        c.b(103120, ResponseCreateGroupActivityMessage.class, false);
        c.b(103015, ResponseGetGroupActivityMessage.class, false);
        c.b(103121, ResponseDelGroupActivityMessage.class, false);
        c.b(103004, ResponseGroupInfoMessage.class, false);
        c.b(2001102, h.class);
        c.b(2001123, d.class);
    }
}
