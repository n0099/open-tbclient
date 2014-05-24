package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.RequestMarkReadedMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class CommonGroupMsglistModel extends MsglistModel {
    protected GroupData a;
    private f b;
    private final com.baidu.adp.framework.listener.b c;

    public CommonGroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.a = null;
        this.c = new c(this, 0);
        f();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        m();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void a(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.i.a(new d(this, chatMessage), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void b(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.i.a(new e(this, chatMessage), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ImMessageCenterPojo a(com.baidu.tieba.im.db.e eVar) {
        if (eVar == null || this.a == null) {
            return null;
        }
        return eVar.a(new StringBuilder(String.valueOf(this.a.getGroupId())).toString());
    }

    public void a(GroupData groupData) {
        this.a = groupData;
        if (this.a != null) {
            this.u = this.a.getGroupId();
        } else {
            this.u = 0L;
        }
    }

    public GroupData b() {
        return this.a;
    }

    private void f() {
        this.b = new f(this, null);
        com.baidu.tieba.im.chat.w.b().a(this.b);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_REMOVE_MEMBERS, this.c);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UPDATE_GROUP, this.c);
    }

    private void m() {
        MessageManager.getInstance().unRegisterListener(this.c);
        com.baidu.tieba.im.chat.w.b().b(this.b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ChatMessage> a(ResponsedMessage<?> responsedMessage) {
        LinkedList<ChatMessage> listMessage;
        if (!(responsedMessage instanceof GroupMsgData)) {
            return null;
        }
        GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
        if (b() == null || groupMsgData.getGroupInfo() == null || groupMsgData.getGroupInfo().getGroupId() != b().getGroupId() || (listMessage = groupMsgData.getListMessage()) == null) {
            return null;
        }
        return a(listMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ResponseCommitGroupMessage responseCommitGroupMessage) {
        if (responseCommitGroupMessage != null && this.a != null) {
            if (responseCommitGroupMessage.getError() == 0) {
                return responseCommitGroupMessage.getGroupId() != null && responseCommitGroupMessage.getGroupId().equals(String.valueOf(this.a.getGroupId()));
            }
            if (responseCommitGroupMessage.getOrginalMessage() != null && (responseCommitGroupMessage.getOrginalMessage() instanceof CommonGroupChatMessage)) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) responseCommitGroupMessage.getOrginalMessage();
                if (commonGroupChatMessage.getGroupId() != null && commonGroupChatMessage.getGroupId().equals(String.valueOf(this.a.getGroupId()))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ResponsedMessage<?> responsedMessage) {
        Message<?> orginalMessage;
        String[] split;
        if (responsedMessage instanceof ResponseRemoveMembersMessage) {
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) responsedMessage;
            if (responseRemoveMembersMessage.getError() == 0 && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                RequestRemoveMembersMessage requestRemoveMembersMessage = (RequestRemoveMembersMessage) orginalMessage;
                if (requestRemoveMembersMessage.getGroupId() == this.a.getGroupId()) {
                    String userIds = requestRemoveMembersMessage.getUserIds();
                    if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                        String id = TbadkApplication.getCurrentAccountObj().getID();
                        if (!TextUtils.isEmpty(id)) {
                            for (String str : split) {
                                if (id.equals(str)) {
                                    this.mLoadDataMode = 9;
                                    this.mLoadDataCallBack.a(null);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ResponsedMessage<?> responsedMessage) {
        if (!(responsedMessage instanceof ResponseUpdateGroupMessage)) {
            BdLog.d("transform error");
            return;
        }
        ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) responsedMessage;
        if (responseUpdateGroupMessage.getError() != 0) {
            BdLog.e("has error");
        } else if (responseUpdateGroupMessage.getUpdateGroupInfo() != null) {
            this.mLoadDataMode = 10;
            this.mLoadDataCallBack.a(responseUpdateGroupMessage.getUpdateGroupInfo().getName());
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.db.i.a().c(String.valueOf(this.a.getGroupId()));
        aVar.a(null);
        RequestMarkReadedMessage requestMarkReadedMessage = new RequestMarkReadedMessage();
        requestMarkReadedMessage.setData(String.valueOf(this.a.getGroupId()));
        MessageManager.getInstance().sendMessage(requestMarkReadedMessage);
    }
}
