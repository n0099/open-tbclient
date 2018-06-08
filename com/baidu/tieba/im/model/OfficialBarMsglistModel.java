package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.util.v;
import com.baidu.tbadk.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.d;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.c;
import com.baidu.tieba.im.db.l;
import com.baidu.tieba.im.memorycache.b;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.LoadOfficialBarDraftMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.OfficialBarSaveDraftMessage;
import com.baidu.tieba.im.message.RequestOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.RequestOfficialBarMenuMessage;
import com.baidu.tieba.im.message.RequestSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.sendmessage.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarMsglistModel extends CommonPersonalMsglistModel {
    private static final int MSG_COUNT_PER = 10;
    private boolean hasFake;
    private CustomMessageListener mCustomMessageListener;
    private int mUserType;
    private c officialBarMenuDatas;

    /* loaded from: classes3.dex */
    public static class MsgContent extends OrmObject {
        public String eventId;
        public String userMsg;
    }

    public OfficialBarMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.hasFake = false;
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2012123) {
                        OfficialBarMsglistModel.this.processServerMsg(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001144) {
                        OfficialBarMsglistModel.this.processDraft(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001147) {
                        OfficialBarMsglistModel.this.processHistoryFake(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001151) {
                        String str = (String) customResponsedMessage.getData();
                        if (OfficialBarMsglistModel.this.mUser != null && OfficialBarMsglistModel.this.mUser.getUserId().equals(str)) {
                            OfficialBarMsglistModel.this.refreshAfterClearHistory();
                        }
                    }
                }
            }
        };
        registerListener();
        this.customGroupType = 4;
    }

    public c getOfficialBarMenuDatas() {
        return this.officialBarMenuDatas;
    }

    public void setOfficialBarMenuDatas(c cVar) {
        this.officialBarMenuDatas = cVar;
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
        userData.setName_show(this.mUser.getName_show());
        userData.setUserType(this.mUserType);
        officialChatMessage.setToUserInfo(userData);
        return officialChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(d dVar) {
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.limit = 10;
        aVar.ert = null;
        aVar.eru = null;
        aVar.id = this.mUser.getUserIdLong() + "";
        super.sendMessage(new LoadOfficialHistoryMessage(aVar));
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
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.limit = 10;
        if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j = this.mDatas.getChatMessages().get(0).getMsgId();
            j2 = this.mDatas.getChatMessages().get(0).getRecordId();
        }
        aVar.ert = String.valueOf(j);
        aVar.eru = String.valueOf(j2);
        aVar.id = this.mUser.getUserIdLong() + "";
        super.sendMessage(new LoadOfficialHistoryMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mUser == null) {
            return false;
        }
        LoadDraftMessage.a aVar = new LoadDraftMessage.a();
        aVar.id = this.mUser.getUserId();
        super.sendMessage(new LoadOfficialBarDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        SaveDraftMessage.a aVar = new SaveDraftMessage.a();
        if (this.mUser == null) {
            return false;
        }
        aVar.mId = String.valueOf(String.valueOf(this.mUser.getUserId()));
        aVar.mDraft = str;
        super.sendMessage(new OfficialBarSaveDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void deleteMsg(final ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            w.b(new v<Boolean>() { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.1
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.v
                public Boolean doInBackground() {
                    return Boolean.valueOf(l.aIh().bl(String.valueOf(OfficialBarMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void markDeleteMsg(final ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            w.b(new v<Boolean>() { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tbadk.util.v
                public Boolean doInBackground() {
                    return Boolean.valueOf(l.aIh().bk(String.valueOf(OfficialBarMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    private void registerListener() {
        MessageManager.getInstance().registerListener(2012123, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001144, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001147, this.mCustomMessageListener);
        MessageManager.getInstance().registerListener(2001151, this.mCustomMessageListener);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
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
        ChatMessage createFakeMessage;
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() != null) {
                List<ChatMessage> list = loadHistoryResponsedMessage.getData().msgList;
                LinkedList linkedList = list == null ? new LinkedList() : list;
                if (linkedList.size() > 0) {
                    for (ChatMessage chatMessage : linkedList) {
                        if (chatMessage != null) {
                            am amVar = new am("official_message_open");
                            amVar.f("msg_id", chatMessage.getMsgId() / 100);
                            if (chatMessage.getUserInfo() != null) {
                                amVar.ah("official_id", chatMessage.getUserInfo().getUserId());
                                amVar.r("official_type", chatMessage.getUserInfo().getUserType());
                            }
                            amVar.f("operate_time", System.currentTimeMillis() / 1000);
                            amVar.f("task_id", chatMessage.getStatTaskId());
                            TiebaStatic.log(amVar);
                        }
                    }
                }
                if ((this.mUserType == 1 || this.mUserType == 4) && linkedList.size() < 10 && !this.hasFake && (createFakeMessage = createFakeMessage()) != null) {
                    createFakeMessage.setRecordId(-1L);
                    if (createFakeMessage.getLocalData() != null) {
                        createFakeMessage.getLocalData().setStatus((short) 3);
                    } else {
                        MsgLocalData msgLocalData = new MsgLocalData();
                        msgLocalData.setStatus((short) 3);
                        createFakeMessage.setLocalData(msgLocalData);
                    }
                    linkedList.add(0, createFakeMessage);
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
            str = String.format(this.mActivity.getPageContext().getString(d.k.official_fake_message_official_bar), this.mUser.getUserName());
        } else if (this.mUserType == 4) {
            str = String.format(this.mActivity.getPageContext().getString(d.k.official_fake_message_official_account), this.mUser.getUserName());
        }
        HashMap hashMap = new HashMap();
        hashMap.put("eventId", "-10001");
        hashMap.put("userMsg", str);
        return createMessage((short) 11, OrmObject.jsonStrWithObject((MsgContent) OrmObject.objectWithMap(hashMap, MsgContent.class)));
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
                    am amVar = new am("official_message_open");
                    amVar.f("msg_id", chatMessage.getMsgId() / 100);
                    if (chatMessage.getUserInfo() != null) {
                        amVar.ah("official_id", chatMessage.getUserInfo().getUserId());
                        amVar.r("official_type", chatMessage.getUserInfo().getUserType());
                    }
                    amVar.f("operate_time", System.currentTimeMillis() / 1000);
                    amVar.f("task_id", chatMessage.getStatTaskId());
                    TiebaStatic.log(amVar);
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

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        return b.aKr().av(String.valueOf(a.etJ), -9);
    }
}
