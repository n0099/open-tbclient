package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.c;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tbadk.util.ac;
import com.baidu.tbadk.util.ad;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public abstract class CommonGroupMsglistModel extends MsglistModel {
    private final CustomMessageListener mCustomListener;
    protected GroupData mGroup;
    private final c mSocketListener;

    public CommonGroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.mGroup = null;
        this.mSocketListener = new c(0) { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(SocketResponsedMessage socketResponsedMessage) {
                if (socketResponsedMessage != null) {
                    if (socketResponsedMessage.getCmd() == 103112) {
                        CommonGroupMsglistModel.this.removeMemeber(socketResponsedMessage);
                    } else if (socketResponsedMessage.getCmd() == 103102) {
                        CommonGroupMsglistModel.this.updataGroupInfo(socketResponsedMessage);
                    }
                }
            }
        };
        this.mCustomListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2016012) {
                        if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof SocketResponsedMessage)) {
                            SocketResponsedMessage socketResponsedMessage = (SocketResponsedMessage) customResponsedMessage.getData();
                            if (socketResponsedMessage.getCmd() == 202001 && (socketResponsedMessage instanceof ResponseCommitGroupMessage)) {
                                ResponseCommitGroupMessage responseCommitGroupMessage = (ResponseCommitGroupMessage) socketResponsedMessage;
                                if (CommonGroupMsglistModel.this.checkAckMsg(responseCommitGroupMessage)) {
                                    CommonGroupMsglistModel.this.processMsgACK(responseCommitGroupMessage);
                                }
                            }
                        }
                    } else if (customResponsedMessage.getCmd() == 2001215 && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ChatMessage)) {
                        ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                        if (CommonGroupMsglistModel.this.mGroup != null && CommonGroupMsglistModel.this.mGroup.getGroupId() != 0 && chatMessage.getGroupId() != null && chatMessage.getGroupId().equals(String.valueOf(CommonGroupMsglistModel.this.mGroup.getGroupId()))) {
                            CommonGroupMsglistModel.this.sendMsgFail(chatMessage);
                        }
                    }
                }
            }
        };
        registerListener();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        if (getGroup() != null) {
            return b.crX().bi(String.valueOf(getGroup().getGroupId()), this.customGroupType);
        }
        return 0L;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void deleteMsg(final ChatMessage chatMessage) {
        if (this.mGroup != null && chatMessage != null) {
            ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tieba.im.db.c.cpA().ev(String.valueOf(CommonGroupMsglistModel.this.mGroup.getGroupId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void markDeleteMsg(final ChatMessage chatMessage) {
        if (this.mGroup != null && chatMessage != null) {
            ad.b(new ac<Boolean>() { // from class: com.baidu.tieba.im.model.CommonGroupMsglistModel.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.ac
                public Boolean doInBackground() {
                    return Boolean.valueOf(com.baidu.tieba.im.db.c.cpA().eu(String.valueOf(CommonGroupMsglistModel.this.mGroup.getGroupId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    public void setGroup(GroupData groupData) {
        this.mGroup = groupData;
        if (this.mGroup != null) {
            this.mId = this.mGroup.getGroupId();
        } else {
            this.mId = 0L;
        }
    }

    public GroupData getGroup() {
        return this.mGroup;
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_REMOVE_MEMBERS, this.mSocketListener);
        MessageManager.getInstance().registerListener(CmdConfigSocket.CMD_UPDATE_GROUP, this.mSocketListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.MEMORY_COMMIT_MSG_ACK, this.mCustomListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_UPLOAD_FAIL, this.mCustomListener);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mSocketListener);
        MessageManager.getInstance().unRegisterListener(this.mCustomListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ChatMessage> processServerMsg(ResponsedMessage<?> responsedMessage) {
        LinkedList<ChatMessage> listMessage;
        if (!(responsedMessage instanceof GroupMsgData)) {
            return null;
        }
        GroupMsgData groupMsgData = (GroupMsgData) responsedMessage;
        if (getGroup() == null || groupMsgData.getGroupInfo() == null || groupMsgData.getGroupInfo().getGroupId() != getGroup().getGroupId() || (listMessage = groupMsgData.getListMessage()) == null) {
            return null;
        }
        return processMsgFromServerCommon(listMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkAckMsg(ResponseCommitGroupMessage responseCommitGroupMessage) {
        if (responseCommitGroupMessage != null && this.mGroup != null) {
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
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMemeber(ResponsedMessage<?> responsedMessage) {
        Message<?> orginalMessage;
        String[] split;
        if (responsedMessage instanceof ResponseRemoveMembersMessage) {
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) responsedMessage;
            if (responseRemoveMembersMessage.getError() == 0 && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                RequestRemoveMembersMessage requestRemoveMembersMessage = (RequestRemoveMembersMessage) orginalMessage;
                if (requestRemoveMembersMessage.getGroupId() == this.mGroup.getGroupId()) {
                    String userIds = requestRemoveMembersMessage.getUserIds();
                    if (!TextUtils.isEmpty(userIds) && (split = userIds.split(Constants.ACCEPT_TIME_SEPARATOR_SP)) != null && split.length != 0) {
                        String id = TbadkApplication.getCurrentAccountObj().getID();
                        if (!TextUtils.isEmpty(id)) {
                            for (String str : split) {
                                if (id.equals(str)) {
                                    this.mLoadDataMode = 9;
                                    this.mLoadDataCallBack.callback(null);
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
    public void updataGroupInfo(ResponsedMessage<?> responsedMessage) {
        if (responsedMessage instanceof ResponseUpdateGroupMessage) {
            ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) responsedMessage;
            if (responseUpdateGroupMessage.getError() == 0 && responseUpdateGroupMessage.getUpdateGroupInfo() != null) {
                this.mLoadDataMode = 10;
                this.mLoadDataCallBack.callback(responseUpdateGroupMessage.getUpdateGroupInfo().getName());
            }
        }
    }
}
