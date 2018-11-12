package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.d;
import com.baidu.tieba.im.message.GroupSaveDraftMessage;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadGroupDraftMessage;
import com.baidu.tieba.im.message.LoadGroupHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes3.dex */
public class GroupMsglistModel extends CommonGroupMsglistModel {
    private static final int MSG_COUNT_PER = 20;
    private CustomMessageListener mCustomMessageListener;

    public GroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.GroupMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                d callback;
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2012125) {
                        GroupMsglistModel.this.processServerMsg(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001142) {
                        GroupMsglistModel.this.processDraft(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001145) {
                        boolean processHistory = GroupMsglistModel.this.processHistory(customResponsedMessage);
                        if ((customResponsedMessage.getOrginalMessage() instanceof LoadGroupHistoryMessage) && processHistory && (callback = ((LoadGroupHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                            callback.aMs();
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
    public boolean loadFirst(d dVar) {
        if (this.mGroup == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.limit = 20;
        aVar.ePs = null;
        aVar.ePt = null;
        aVar.id = this.mGroup.getGroupId() + "";
        LoadGroupHistoryMessage loadGroupHistoryMessage = new LoadGroupHistoryMessage(aVar);
        loadGroupHistoryMessage.setCallback(dVar);
        super.sendMessage(loadGroupHistoryMessage);
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        long j2 = 0;
        if (this.mGroup != null) {
            LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
            aVar.limit = 20;
            if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j = this.mDatas.getChatMessages().get(0).getMsgId();
                j2 = this.mDatas.getChatMessages().get(0).getRecordId();
            }
            aVar.ePs = String.valueOf(j);
            aVar.ePt = String.valueOf(j2);
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
        MessageManager.getInstance().registerListener(2012125, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001142, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001145, this.mCustomMessageListener);
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
