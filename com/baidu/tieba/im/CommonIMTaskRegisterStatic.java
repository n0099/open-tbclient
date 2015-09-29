package com.baidu.tieba.im;

import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.e.a.g;
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
        e.b(CmdConfigCustom.CMD_LOAD_DRAFT_GROUP, com.baidu.tieba.im.e.a.e.class);
        e.b(CmdConfigCustom.CMD_LOAD_HISTORY_GROUP, g.class);
        e.b(CmdConfigCustom.CMD_SAVE_DRAFT_GROUP, com.baidu.tieba.im.e.a.f.class);
    }
}
