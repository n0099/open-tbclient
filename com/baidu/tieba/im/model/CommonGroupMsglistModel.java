package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import d.a.c.c.g.c;
import d.a.n0.z0.f0;
import d.a.n0.z0.h0;
import d.a.o0.f1.k.b;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public abstract class CommonGroupMsglistModel extends MsglistModel {
    public final CustomMessageListener mCustomListener;
    public GroupData mGroup;
    public final c mSocketListener;

    public CommonGroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.mGroup = null;
        this.mSocketListener = new c(0) { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage == null) {
                    return;
                }
                if (socketResponsedMessage.getCmd() == 103112) {
                    CommonGroupMsglistModel.this.removeMemeber(socketResponsedMessage);
                } else if (socketResponsedMessage.getCmd() == 103102) {
                    CommonGroupMsglistModel.this.updataGroupInfo(socketResponsedMessage);
                }
            }
        };
        this.mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2016012) {
                    if (customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                        return;
                    }
                    SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                    if (socketResponsedMessage.getCmd() == 202001 && (socketResponsedMessage instanceof ResponseCommitGroupMessage)) {
                        ResponseCommitGroupMessage responseCommitGroupMessage = (ResponseCommitGroupMessage) socketResponsedMessage;
                        if (CommonGroupMsglistModel.this.checkAckMsg(responseCommitGroupMessage)) {
                            CommonGroupMsglistModel.this.processMsgACK(responseCommitGroupMessage);
                        }
                    }
                } else if (customResponsedMessage.getCmd() == 2001215 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                    ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                    GroupData groupData = CommonGroupMsglistModel.this.mGroup;
                    if (groupData == null || groupData.getGroupId() == 0 || chatMessage.getGroupId() == null || !chatMessage.getGroupId().equals(String.valueOf(CommonGroupMsglistModel.this.mGroup.getGroupId()))) {
                        return;
                    }
                    CommonGroupMsglistModel.this.sendMsgFail(chatMessage);
                }
            }
        };
        registerListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkAckMsg(ResponseCommitGroupMessage responseCommitGroupMessage) {
        if (responseCommitGroupMessage == null || this.mGroup == null) {
            return false;
        }
        if (responseCommitGroupMessage.getError() == 0) {
            return responseCommitGroupMessage.getGroupId() != null && responseCommitGroupMessage.getGroupId().equals(String.valueOf(this.mGroup.getGroupId()));
        }
        if (responseCommitGroupMessage.getOrginalMessage() != null && (responseCommitGroupMessage.getOrginalMessage() instanceof CommonGroupChatMessage)) {
            CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) responseCommitGroupMessage.getOrginalMessage();
            if (commonGroupChatMessage.getGroupId() != null && commonGroupChatMessage.getGroupId().equals(String.valueOf(this.mGroup.getGroupId()))) {
                return true;
            }
        }
        return false;
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(103112, this.mSocketListener);
        MessageManager.getInstance().registerListener(103102, this.mSocketListener);
        MessageManager.getInstance().registerListener(2016012, this.mCustomListener);
        MessageManager.getInstance().registerListener(2001215, this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMemeber(ResponsedMessage<?> responsedMessage) {
        Message<?> orginalMessage;
        String[] split;
        if (responsedMessage instanceof ResponseRemoveMembersMessage) {
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) responsedMessage;
            if (responseRemoveMembersMessage.getError() == 0 && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                RequestRemoveMembersMessage requestRemoveMembersMessage = (RequestRemoveMembersMessage) orginalMessage;
                if (requestRemoveMembersMessage.getGroupId() != this.mGroup.getGroupId()) {
                    return;
                }
                String userIds = requestRemoveMembersMessage.getUserIds();
                if (TextUtils.isEmpty(userIds) || (split = userIds.split(",")) == null || split.length == 0) {
                    return;
                }
                String id = TbadkCoreApplication.getCurrentAccountObj().getID();
                if (TextUtils.isEmpty(id)) {
                    return;
                }
                for (String str : split) {
                    if (id.equals(str)) {
                        this.mLoadDataMode = 9;
                        this.mLoadDataCallBack.c(null);
                        return;
                    }
                }
            }
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mSocketListener);
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updataGroupInfo(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof ResponseUpdateGroupMessage) {
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) responsedMessage;
            if (responseUpdateGroupMessage.getError() == 0 && responseUpdateGroupMessage.getUpdateGroupInfo() != null) {
                this.mLoadDataMode = 10;
                this.mLoadDataCallBack.c(responseUpdateGroupMessage.getUpdateGroupInfo().getName());
            }
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void deleteMsg(final ChatMessage chatMessage) {
        if (this.mGroup == null || chatMessage == null) {
            return;
        }
        h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.n0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.o0.f1.h.c.h().c(String.valueOf(CommonGroupMsglistModel.this.mGroup.getGroupId()), String.valueOf(chatMessage.getMsgId())));
            }
        }, null);
    }

    public GroupData getGroup() {
        return this.mGroup;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        if (getGroup() != null) {
            return b.o().p(String.valueOf(getGroup().getGroupId()), this.customGroupType);
        }
        return 0L;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void markDeleteMsg(final ChatMessage chatMessage) {
        if (this.mGroup == null || chatMessage == null) {
            return;
        }
        h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.n0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(d.a.o0.f1.h.c.h().m(String.valueOf(CommonGroupMsglistModel.this.mGroup.getGroupId()), String.valueOf(chatMessage.getMsgId())));
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    public List<ChatMessage> processServerMsg(ResponsedMessage<?> responsedMessage) {
        LinkedList<ChatMessage> listMessage;
        if (responsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
            if (getGroup() != null && groupMsgData.getGroupInfo() != null && groupMsgData.getGroupInfo().getGroupId() == getGroup().getGroupId() && (listMessage = groupMsgData.getListMessage()) != null) {
                return processMsgFromServerCommon(listMessage);
            }
        }
        return null;
    }

    public void setGroup(GroupData groupData) {
        this.mGroup = groupData;
        if (groupData != null) {
            this.mId = groupData.getGroupId();
        } else {
            this.mId = 0L;
        }
    }
}
