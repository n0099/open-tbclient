package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.c;
import com.baidu.tieba.im.message.GroupSaveDraftMessage;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadGroupDraftMessage;
import com.baidu.tieba.im.message.LoadGroupHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes8.dex */
public class GroupMsglistModel extends CommonGroupMsglistModel {
    private static final int MSG_COUNT_PER = 20;
    private CustomMessageListener mCustomMessageListener;

    public GroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.GroupMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c callback;
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2012125) {
                        GroupMsglistModel.this.processServerMsg(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001142) {
                        GroupMsglistModel.this.processDraft(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001145) {
                        boolean processHistory = GroupMsglistModel.this.processHistory(customResponsedMessage);
                        if ((customResponsedMessage.getOrginalMessage() instanceof LoadGroupHistoryMessage) && processHistory && (callback = ((LoadGroupHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                            callback.cUB();
                        }
                    }
                }
            }
        };
        registerListener();
        this.customGroupType = 1;
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(c cVar) {
        if (this.mGroup == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.limit = 20;
        aVar.kJe = null;
        aVar.kJf = null;
        aVar.id = this.mGroup.getGroupId() + "";
        LoadGroupHistoryMessage loadGroupHistoryMessage = new LoadGroupHistoryMessage(aVar);
        loadGroupHistoryMessage.setCallback(cVar);
        super.sendMessage(loadGroupHistoryMessage);
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        long j2;
        if (this.mGroup != null) {
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.limit = 20;
            if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
                j = 0;
                j2 = 0;
            } else {
                long msgId = this.mDatas.getChatMessages().get(0).getMsgId();
                j = this.mDatas.getChatMessages().get(0).getRecordId();
                j2 = msgId;
            }
            aVar.kJe = String.valueOf(j2);
            aVar.kJf = String.valueOf(j);
            aVar.id = this.mGroup.getGroupId() + "";
            super.sendMessage(new LoadGroupHistoryMessage(aVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mGroup == null) {
            return false;
        }
        LoadDraftMessage.a aVar = new LoadDraftMessage.a();
        aVar.id = this.mGroup.getGroupId() + "";
        super.sendMessage(new LoadGroupDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        SaveDraftMessage.a aVar = new SaveDraftMessage.a();
        if (this.mGroup == null || this.mGroup.getGroupId() == 0) {
            return false;
        }
        aVar.mId = String.valueOf(this.mGroup.getGroupId());
        aVar.mDraft = str;
        super.sendMessage(new GroupSaveDraftMessage(aVar));
        return true;
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(CmdConfigCustom.MESSAGE_LIST_GROUP_CMD, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LOAD_DRAFT_GROUP, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(CmdConfigCustom.CMD_LOAD_HISTORY_GROUP, this.mCustomMessageListener);
    }

    protected void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage genChatMessage() {
        GroupChatMessage groupChatMessage = new GroupChatMessage();
        groupChatMessage.setBornTime(System.currentTimeMillis());
        if (getGroup() == null) {
            return null;
        }
        groupChatMessage.setGroupId(String.valueOf(getGroup().getGroupId()));
        return groupChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected MsglistModel.CacheInfo getCacheInfo() {
        if (this.mGroup == null) {
            return null;
        }
        MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
        cacheInfo.customGroupType = 1;
        cacheInfo.id = String.valueOf(this.mGroup.getGroupId());
        return cacheInfo;
    }
}
