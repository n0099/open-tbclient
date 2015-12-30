package com.baidu.tieba.im;

import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
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
        f.b(202004, ResponseDelSystemMessage.class, false);
        f.b(103112, ResponseRemoveMembersMessage.class, false);
        f.b(202001, ResponseCommitGroupMessage.class, false);
        f.b(103111, ResponseAddGroupUserMessage.class, false);
        f.b(103105, ResponseUpgradeMemberGroupMessage.class, false);
        f.b(103008, ResponseUserPermissionMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        f.b(103102, ResponseUpdateGroupMessage.class, false).a(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
        f.b(103104, ResponseDismissGroupMessage.class, false);
        f.b(CmdConfigCustom.CMD_LOAD_DRAFT_GROUP, com.baidu.tieba.im.e.a.e.class);
        f.b(CmdConfigCustom.CMD_LOAD_HISTORY_GROUP, com.baidu.tieba.im.e.a.g.class);
        f.b(CmdConfigCustom.CMD_SAVE_DRAFT_GROUP, com.baidu.tieba.im.e.a.f.class);
    }
}
