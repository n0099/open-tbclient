package com.baidu.tieba.im;

import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tieba.im.message.ResponseAddGroupUserMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseDelSystemMessage;
import com.baidu.tieba.im.message.ResponseDismissGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponseUpgradeMemberGroupMessage;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
/* loaded from: classes.dex */
public class CommonIMTaskRegisterStatic {
    static {
        e.b(202004, ResponseDelSystemMessage.class, false);
        e.b(103112, ResponseRemoveMembersMessage.class, false);
        e.b(202001, ResponseCommitGroupMessage.class, false);
        e.b(103111, ResponseAddGroupUserMessage.class, false);
        e.b(103105, ResponseUpgradeMemberGroupMessage.class, false);
        e.b(103008, ResponseUserPermissionMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        e.b(103102, ResponseUpdateGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        e.b(103104, ResponseDismissGroupMessage.class, false);
        e.b(2001146, com.baidu.tieba.im.e.a.e.class);
        e.b(2001149, com.baidu.tieba.im.e.a.g.class);
        e.b(2001152, com.baidu.tieba.im.e.a.f.class);
    }
}
