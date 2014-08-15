package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupMsgData;
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
    private final com.baidu.adp.framework.listener.d b;
    private final CustomMessageListener c;

    public CommonGroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.a = null;
        this.b = new c(this, 0);
        this.c = new d(this, 0);
        f();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        m();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long b() {
        if (c() != null) {
            return com.baidu.tieba.im.memorycache.c.b().e(String.valueOf(c().getGroupId()), this.v);
        }
        return 0L;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void a(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.e.a(new e(this, chatMessage), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void b(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.e.a(new f(this, chatMessage), null);
        }
    }

    public void a(GroupData groupData) {
        this.a = groupData;
        if (this.a != null) {
            this.u = this.a.getGroupId();
        } else {
            this.u = 0L;
        }
    }

    public GroupData c() {
        return this.a;
    }

    private void f() {
        MessageManager.getInstance().registerListener(103112, this.b);
        MessageManager.getInstance().registerListener(103102, this.b);
        MessageManager.getInstance().registerListener(2016012, this.c);
        MessageManager.getInstance().registerListener(2001221, this.c);
    }

    private void m() {
        MessageManager.getInstance().unRegisterListener(this.b);
        MessageManager.getInstance().unRegisterListener(this.c);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ChatMessage> a(ResponsedMessage<?> responsedMessage) {
        LinkedList<ChatMessage> listMessage;
        if (!(responsedMessage instanceof GroupMsgData)) {
            return null;
        }
        GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
        if (c() == null || groupMsgData.getGroupInfo() == null || groupMsgData.getGroupInfo().getGroupId() != c().getGroupId() || (listMessage = groupMsgData.getListMessage()) == null) {
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
        if (responsedMessage instanceof ResponseUpdateGroupMessage) {
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) responsedMessage;
            if (responseUpdateGroupMessage.getError() == 0 && responseUpdateGroupMessage.getUpdateGroupInfo() != null) {
                this.mLoadDataMode = 10;
                this.mLoadDataCallBack.a(responseUpdateGroupMessage.getUpdateGroupInfo().getName());
            }
        }
    }
}
