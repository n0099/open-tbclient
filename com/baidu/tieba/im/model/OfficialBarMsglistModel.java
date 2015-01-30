package com.baidu.tieba.im.model;

import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.au;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.e;
import com.baidu.tieba.im.data.g;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.h;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.LoadOfficialBarDraftMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.OfficialBarSaveDraftMessage;
import com.baidu.tieba.im.message.RequestOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.RequestOfficialBarMenuMessage;
import com.baidu.tieba.im.message.RequestSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.a;
import com.baidu.tieba.im.message.c;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.p;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.z;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarMsglistModel extends CommonPersonalMsglistModel {
    private final int MSG_COUNT_PER;
    private boolean hasFake;
    private CustomMessageListener mCustomMessageListener;
    private int mUserType;
    private e officialBarMenuDatas;

    /* loaded from: classes.dex */
    public class MsgContent extends i {
        public String eventId;
        public String userMsg;
    }

    public OfficialBarMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.MSG_COUNT_PER = 10;
        this.hasFake = false;
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() != 2013003) {
                        if (customResponsedMessage.getCmd() == 2001148) {
                            OfficialBarMsglistModel.this.processDraft(customResponsedMessage);
                            return;
                        } else if (customResponsedMessage.getCmd() != 2001151) {
                            if (customResponsedMessage.getCmd() == 2001155) {
                                String str = (String) customResponsedMessage.getData();
                                if (OfficialBarMsglistModel.this.mUser != null && OfficialBarMsglistModel.this.mUser.getUserId().equals(str)) {
                                    OfficialBarMsglistModel.this.refreshAfterClearHistory();
                                    return;
                                }
                                return;
                            }
                            return;
                        } else {
                            OfficialBarMsglistModel.this.processHistoryFake(customResponsedMessage);
                            OfficialBarMsglistModel.this.addStatisticsForOpenMessage();
                            return;
                        }
                    }
                    OfficialBarMsglistModel.this.processServerMsg(customResponsedMessage);
                }
            }
        };
        registerListener();
        this.customGroupType = 4;
    }

    public e getOfficialBarMenuDatas() {
        return this.officialBarMenuDatas;
    }

    public void setOfficialBarMenuDatas(e eVar) {
        this.officialBarMenuDatas = eVar;
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    public void setUserType(int i) {
        this.mUserType = i;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage genChatMessage() {
        if (this.mUser == null) {
            return null;
        }
        OfficialChatMessage officialChatMessage = new OfficialChatMessage();
        officialChatMessage.setBornTime(System.currentTimeMillis());
        officialChatMessage.setToUserId(this.mUser.getUserIdLong());
        UserData userData = new UserData();
        userData.setUserId(String.valueOf(this.mUser.getUserId()));
        userData.setUserName(this.mUser.getUserName());
        userData.setPortrait(this.mUser.getPortrait());
        userData.setUserType(this.mUserType);
        officialChatMessage.setToUserInfo(userData);
        return officialChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(au auVar) {
        if (this.mUser == null) {
            return false;
        }
        c cVar = new c();
        cVar.limit = 10;
        cVar.bji = null;
        cVar.bjj = null;
        cVar.id = new StringBuilder(String.valueOf(this.mUser.getUserIdLong())).toString();
        super.sendMessage(new LoadOfficialHistoryMessage(cVar));
        return true;
    }

    public String getForumId() {
        UserData user = getUser();
        return user != null ? user.getUserId() : "";
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        long j2 = 0;
        if (this.mUser == null) {
            return false;
        }
        c cVar = new c();
        cVar.limit = 10;
        if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j = this.mDatas.getChatMessages().get(0).getMsgId();
            j2 = this.mDatas.getChatMessages().get(0).getRecordId();
        }
        cVar.bji = String.valueOf(j);
        cVar.bjj = String.valueOf(j2);
        cVar.id = new StringBuilder(String.valueOf(this.mUser.getUserIdLong())).toString();
        super.sendMessage(new LoadOfficialHistoryMessage(cVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mUser == null) {
            return false;
        }
        a aVar = new a();
        aVar.id = this.mUser.getUserId();
        super.sendMessage(new LoadOfficialBarDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        p pVar = new p();
        if (this.mUser == null) {
            return false;
        }
        pVar.mId = String.valueOf(String.valueOf(this.mUser.getUserId()));
        pVar.mDraft = str;
        super.sendMessage(new OfficialBarSaveDraftMessage(pVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void deleteMsg(final ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            com.baidu.tieba.im.i.a(new h<Boolean>() { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.im.h
                public Boolean doInBackground() {
                    return Boolean.valueOf(n.Nj().aA(String.valueOf(OfficialBarMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void markDeleteMsg(final ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            com.baidu.tieba.im.i.a(new h<Boolean>() { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.im.h
                public Boolean doInBackground() {
                    return Boolean.valueOf(n.Nj().az(String.valueOf(OfficialBarMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2013003, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001148, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001151, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001155, this.mCustomMessageListener);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addStatisticsForOpenMessage() {
        ChatMessage chatMessage;
        UserData userInfo;
        g hs;
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        if (chatMessages != null && chatMessages.size() > 0 && (chatMessage = chatMessages.get(chatMessages.size() - 1)) != null && (userInfo = chatMessage.getUserInfo()) != null && !TextUtils.isEmpty(userInfo.getUserId()) && !userInfo.getUserId().equals(TbadkCoreApplication.getCurrentAccount()) && (hs = com.baidu.tieba.im.util.i.hs(chatMessage.getContent())) != null) {
            TiebaStatic.eventStat(this.mActivity.getPageContext().getPageActivity(), "message_open", "click", 1, "task_type", hs.aXX, " task_id", hs.aXY);
        }
    }

    public void sendGetMenuNetMessage(String str, long j) {
        RequestOfficialBarMenuMessage requestOfficialBarMenuMessage = new RequestOfficialBarMenuMessage();
        requestOfficialBarMenuMessage.setForum_id(str);
        requestOfficialBarMenuMessage.setTimestamp(j);
        sendMessage(requestOfficialBarMenuMessage);
    }

    public void sendGetMenuLocalMessage(String str) {
        RequestOfficialBarMenuLocalMessage requestOfficialBarMenuLocalMessage = new RequestOfficialBarMenuLocalMessage();
        requestOfficialBarMenuLocalMessage.setForum_id(str);
        sendMessage(requestOfficialBarMenuLocalMessage);
    }

    public void sendClickMenuMessage(String str, String str2, String str3) {
        RequestSendOfficialBarMenuMessage requestSendOfficialBarMenuMessage = new RequestSendOfficialBarMenuMessage();
        requestSendOfficialBarMenuMessage.setRid(str);
        requestSendOfficialBarMenuMessage.setUser_id(str2);
        requestSendOfficialBarMenuMessage.setForum_id(str3);
        sendMessage(requestSendOfficialBarMenuMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHistoryFake(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() != null) {
                List list = loadHistoryResponsedMessage.getData().msgList;
                if (list == null) {
                    list = new LinkedList();
                }
                if ((this.mUserType == 1 || this.mUserType == 4) && list.size() < 10 && !this.hasFake) {
                    ChatMessage createFakeMessage = createFakeMessage();
                    createFakeMessage.setRecordId(-1L);
                    if (createFakeMessage.getLocalData() != null) {
                        createFakeMessage.getLocalData().setStatus((short) 3);
                    } else {
                        MsgLocalData msgLocalData = new MsgLocalData();
                        msgLocalData.setStatus((short) 3);
                        createFakeMessage.setLocalData(msgLocalData);
                    }
                    list.add(0, createFakeMessage);
                    this.hasFake = true;
                }
                processHistory(loadHistoryResponsedMessage);
            }
        }
    }

    private ChatMessage createFakeMessage() {
        if (this.mUser == null) {
            return null;
        }
        String str = "";
        if (this.mUserType == 1) {
            str = String.format(this.mActivity.getPageContext().getString(z.official_fake_message_official_bar), this.mUser.getUserName());
        } else if (this.mUserType == 4) {
            str = String.format(this.mActivity.getPageContext().getString(z.official_fake_message_official_account), this.mUser.getUserName());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("eventId", "-10001");
        hashMap.put("userMsg", str);
        new String();
        new MsgContent();
        return createMessage((short) 11, i.jsonStrWithObject((MsgContent) i.objectWithMap(hashMap, MsgContent.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (getUser() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof OfficialChatMessage) {
                        if (chatMessage.getToUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        }
                    }
                }
                processMsgFromServerCommon(linkedList);
            }
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected MsglistModel.CacheInfo getCacheInfo() {
        if (this.mUser == null) {
            return null;
        }
        MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
        cacheInfo.id = this.mUser.getUserId();
        cacheInfo.customGroupType = 4;
        return cacheInfo;
    }
}
