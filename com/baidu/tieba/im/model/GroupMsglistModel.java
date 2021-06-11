package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.GroupData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.message.GroupSaveDraftMessage;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadGroupDraftMessage;
import com.baidu.tieba.im.message.LoadGroupHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import d.a.n0.f1.f.c;
/* loaded from: classes4.dex */
public class GroupMsglistModel extends CommonGroupMsglistModel {
    public static final int MSG_COUNT_PER = 20;
    public CustomMessageListener mCustomMessageListener;

    public GroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.GroupMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                c callback;
                if (customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2012125) {
                    GroupMsglistModel.this.processServerMsg(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001142) {
                    GroupMsglistModel.this.processDraft(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001145) {
                    boolean processHistory = GroupMsglistModel.this.processHistory(customResponsedMessage);
                    if ((customResponsedMessage.getOrginalMessage() instanceof LoadGroupHistoryMessage) && processHistory && (callback = ((LoadGroupHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                        callback.onFirstHistoryPageLoaded();
                    }
                }
            }
        };
        registerListener();
        this.customGroupType = 1;
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2012125, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001142, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001145, this.mCustomMessageListener);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public ChatMessage genChatMessage() {
        GroupChatMessage groupChatMessage = new GroupChatMessage();
        groupChatMessage.setBornTime(System.currentTimeMillis());
        if (getGroup() == null) {
            return null;
        }
        groupChatMessage.setGroupId(String.valueOf(getGroup().getGroupId()));
        return groupChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public MsglistModel.CacheInfo getCacheInfo() {
        if (this.mGroup == null) {
            return null;
        }
        MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
        cacheInfo.customGroupType = 1;
        cacheInfo.id = String.valueOf(this.mGroup.getGroupId());
        return cacheInfo;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mGroup == null) {
            return false;
        }
        LoadDraftMessage.a aVar = new LoadDraftMessage.a();
        aVar.f17350a = this.mGroup.getGroupId() + "";
        super.sendMessage(new LoadGroupDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(c cVar) {
        if (this.mGroup == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f17354c = 20;
        aVar.f17352a = null;
        aVar.f17353b = null;
        aVar.f17355d = this.mGroup.getGroupId() + "";
        LoadGroupHistoryMessage loadGroupHistoryMessage = new LoadGroupHistoryMessage(aVar);
        loadGroupHistoryMessage.setCallback(cVar);
        super.sendMessage(loadGroupHistoryMessage);
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        if (this.mGroup == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f17354c = 20;
        MsgPageData msgPageData = this.mDatas;
        long j2 = 0;
        if (msgPageData == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j2 = this.mDatas.getChatMessages().get(0).getMsgId();
            j = this.mDatas.getChatMessages().get(0).getRecordId();
        }
        aVar.f17352a = String.valueOf(j2);
        aVar.f17353b = String.valueOf(j);
        aVar.f17355d = this.mGroup.getGroupId() + "";
        super.sendMessage(new LoadGroupHistoryMessage(aVar));
        return false;
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        SaveDraftMessage.a aVar = new SaveDraftMessage.a();
        GroupData groupData = this.mGroup;
        if (groupData == null || groupData.getGroupId() == 0) {
            return false;
        }
        aVar.f17378b = String.valueOf(this.mGroup.getGroupId());
        aVar.f17377a = str;
        super.sendMessage(new GroupSaveDraftMessage(aVar));
        return true;
    }

    public void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
    }
}
