package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.au;
import com.baidu.tieba.im.message.GroupSaveDraftMessage;
import com.baidu.tieba.im.message.LoadGroupDraftMessage;
import com.baidu.tieba.im.message.LoadGroupHistoryMessage;
import com.baidu.tieba.im.message.a;
import com.baidu.tieba.im.message.c;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
import com.baidu.tieba.im.message.p;
import com.baidu.tieba.im.model.MsglistModel;
/* loaded from: classes.dex */
public class GroupMsglistModel extends CommonGroupMsglistModel {
    private final int MSG_COUNT_PER;
    private CustomMessageListener mCustomMessageListener;

    public GroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.MSG_COUNT_PER = 20;
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.GroupMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                au callback;
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2013005) {
                        GroupMsglistModel.this.processServerMsg(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001146) {
                        GroupMsglistModel.this.processDraft(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001149) {
                        boolean processHistory = GroupMsglistModel.this.processHistory(customResponsedMessage);
                        if ((customResponsedMessage.getOrginalMessage() instanceof LoadGroupHistoryMessage) && processHistory && (callback = ((LoadGroupHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                            callback.onFirstHistoryPageLoaded();
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
    public boolean loadFirst(au auVar) {
        if (this.mGroup == null) {
            return false;
        }
        c cVar = new c();
        cVar.limit = 20;
        cVar.bji = null;
        cVar.bjj = null;
        cVar.id = new StringBuilder(String.valueOf(this.mGroup.getGroupId())).toString();
        LoadGroupHistoryMessage loadGroupHistoryMessage = new LoadGroupHistoryMessage(cVar);
        loadGroupHistoryMessage.setCallback(auVar);
        super.sendMessage(loadGroupHistoryMessage);
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        long j2 = 0;
        if (this.mGroup != null) {
            c cVar = new c();
            cVar.limit = 20;
            if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j = this.mDatas.getChatMessages().get(0).getMsgId();
                j2 = this.mDatas.getChatMessages().get(0).getRecordId();
            }
            cVar.bji = String.valueOf(j);
            cVar.bjj = String.valueOf(j2);
            cVar.id = new StringBuilder(String.valueOf(this.mGroup.getGroupId())).toString();
            super.sendMessage(new LoadGroupHistoryMessage(cVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mGroup == null) {
            return false;
        }
        a aVar = new a();
        aVar.id = new StringBuilder(String.valueOf(this.mGroup.getGroupId())).toString();
        super.sendMessage(new LoadGroupDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        p pVar = new p();
        if (this.mGroup == null || this.mGroup.getGroupId() == 0) {
            return false;
        }
        pVar.mId = String.valueOf(this.mGroup.getGroupId());
        pVar.mDraft = str;
        super.sendMessage(new GroupSaveDraftMessage(pVar));
        return true;
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2013005, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001146, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001149, this.mCustomMessageListener);
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
