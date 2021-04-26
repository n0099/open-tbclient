package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
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
import d.a.i0.z0.f0;
import d.a.i0.z0.h0;
import d.a.j0.e1.g.c;
import d.a.j0.e1.h.l;
import d.a.j0.e1.k.b;
import d.a.j0.e1.s.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarMsglistModel extends CommonPersonalMsglistModel {
    public static final int MSG_COUNT_PER = 10;
    public boolean hasFake;
    public CustomMessageListener mCustomMessageListener;
    public int mUserType;
    public c officialBarMenuDatas;

    /* loaded from: classes4.dex */
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
                if (customResponsedMessage == null) {
                    return;
                }
                if (customResponsedMessage.getCmd() == 2012123) {
                    OfficialBarMsglistModel.this.processServerMsg(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001144) {
                    OfficialBarMsglistModel.this.processDraft(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001147) {
                    OfficialBarMsglistModel.this.processHistoryFake(customResponsedMessage);
                } else if (customResponsedMessage.getCmd() == 2001151) {
                    String str = (String) customResponsedMessage.getData();
                    UserData userData = OfficialBarMsglistModel.this.mUser;
                    if (userData == null || !userData.getUserId().equals(str)) {
                        return;
                    }
                    OfficialBarMsglistModel.this.refreshAfterClearHistory();
                }
            }
        };
        registerListener();
        this.customGroupType = 4;
    }

    private ChatMessage createFakeMessage() {
        String format;
        if (this.mUser == null) {
            return null;
        }
        int i2 = this.mUserType;
        if (i2 == 1) {
            format = String.format(this.mActivity.getPageContext().getString(R.string.official_fake_message_official_bar), this.mUser.getUserName());
        } else {
            format = i2 == 4 ? String.format(this.mActivity.getPageContext().getString(R.string.official_fake_message_official_account), this.mUser.getUserName()) : "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put(TbEnum.SystemMessage.KEY_EVENT_ID, TbEnum.SystemMessage.EVENT_ID_FAKE);
        hashMap.put(TbEnum.SystemMessage.KEY_USER_MSG, format);
        return createMessage((short) 11, OrmObject.jsonStrWithObject((MsgContent) OrmObject.objectWithMap(hashMap, MsgContent.class)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHistoryFake(CustomResponsedMessage<?> customResponsedMessage) {
        ChatMessage createFakeMessage;
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() == null) {
                return;
            }
            List<ChatMessage> list = loadHistoryResponsedMessage.getData().f18056b;
            if (list == null) {
                list = new LinkedList();
            }
            if (list.size() > 0) {
                for (ChatMessage chatMessage : list) {
                    if (chatMessage != null) {
                        StatisticItem statisticItem = new StatisticItem("official_message_open");
                        statisticItem.param("msg_id", chatMessage.getMsgId() / 100);
                        if (chatMessage.getUserInfo() != null) {
                            statisticItem.param("official_id", chatMessage.getUserInfo().getUserId());
                            statisticItem.param("official_type", chatMessage.getUserInfo().getUserType());
                        }
                        statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                        statisticItem.param("task_id", chatMessage.getStatTaskId());
                        TiebaStatic.log(statisticItem);
                    }
                }
            }
            int i2 = this.mUserType;
            if ((i2 == 1 || i2 == 4) && list.size() < 10 && !this.hasFake && (createFakeMessage = createFakeMessage()) != null) {
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
                    StatisticItem statisticItem = new StatisticItem("official_message_open");
                    statisticItem.param("msg_id", chatMessage.getMsgId() / 100);
                    if (chatMessage.getUserInfo() != null) {
                        statisticItem.param("official_id", chatMessage.getUserInfo().getUserId());
                        statisticItem.param("official_type", chatMessage.getUserInfo().getUserType());
                    }
                    statisticItem.param("operate_time", System.currentTimeMillis() / 1000);
                    statisticItem.param("task_id", chatMessage.getStatTaskId());
                    TiebaStatic.log(statisticItem);
                }
                processMsgFromServerCommon(linkedList);
            }
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

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void deleteMsg(final ChatMessage chatMessage) {
        if (this.mUser == null || chatMessage == null) {
            return;
        }
        h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(l.t().c(String.valueOf(OfficialBarMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public ChatMessage genChatMessage() {
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
    public MsglistModel.CacheInfo getCacheInfo() {
        if (this.mUser == null) {
            return null;
        }
        MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
        cacheInfo.id = this.mUser.getUserId();
        cacheInfo.customGroupType = 4;
        return cacheInfo;
    }

    public String getForumId() {
        UserData user = getUser();
        return user != null ? user.getUserId() : "";
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public long getMaxMid() {
        return b.o().p(String.valueOf(a.j), -9);
    }

    public c getOfficialBarMenuDatas() {
        return this.officialBarMenuDatas;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mUser == null) {
            return false;
        }
        LoadDraftMessage.a aVar = new LoadDraftMessage.a();
        aVar.f18049a = this.mUser.getUserId();
        super.sendMessage(new LoadOfficialBarDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(d.a.j0.e1.f.c cVar) {
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f18053c = 10;
        aVar.f18051a = null;
        aVar.f18052b = null;
        aVar.f18054d = this.mUser.getUserIdLong() + "";
        super.sendMessage(new LoadOfficialHistoryMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        if (this.mUser == null) {
            return false;
        }
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.f18053c = 10;
        MsgPageData msgPageData = this.mDatas;
        long j2 = 0;
        if (msgPageData == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j2 = this.mDatas.getChatMessages().get(0).getMsgId();
            j = this.mDatas.getChatMessages().get(0).getRecordId();
        }
        aVar.f18051a = String.valueOf(j2);
        aVar.f18052b = String.valueOf(j);
        aVar.f18054d = this.mUser.getUserIdLong() + "";
        super.sendMessage(new LoadOfficialHistoryMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void markDeleteMsg(final ChatMessage chatMessage) {
        if (this.mUser == null || chatMessage == null) {
            return;
        }
        h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.OfficialBarMsglistModel.2
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // d.a.i0.z0.f0
            public Boolean doInBackground() {
                return Boolean.valueOf(l.t().n(String.valueOf(OfficialBarMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
            }
        }, null);
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        SaveDraftMessage.a aVar = new SaveDraftMessage.a();
        UserData userData = this.mUser;
        if (userData == null) {
            return false;
        }
        aVar.f18077b = String.valueOf(String.valueOf(userData.getUserId()));
        aVar.f18076a = str;
        super.sendMessage(new OfficialBarSaveDraftMessage(aVar));
        return true;
    }

    public void sendClickMenuMessage(String str, String str2, String str3) {
        RequestSendOfficialBarMenuMessage requestSendOfficialBarMenuMessage = new RequestSendOfficialBarMenuMessage();
        requestSendOfficialBarMenuMessage.setRid(str);
        requestSendOfficialBarMenuMessage.setUser_id(str2);
        requestSendOfficialBarMenuMessage.setForum_id(str3);
        sendMessage(requestSendOfficialBarMenuMessage);
    }

    public void sendGetMenuLocalMessage(String str) {
        RequestOfficialBarMenuLocalMessage requestOfficialBarMenuLocalMessage = new RequestOfficialBarMenuLocalMessage();
        requestOfficialBarMenuLocalMessage.setForum_id(str);
        sendMessage(requestOfficialBarMenuLocalMessage);
    }

    public void sendGetMenuNetMessage(String str, long j) {
        RequestOfficialBarMenuMessage requestOfficialBarMenuMessage = new RequestOfficialBarMenuMessage();
        requestOfficialBarMenuMessage.setForum_id(str);
        requestOfficialBarMenuMessage.setTimestamp(j);
        sendMessage(requestOfficialBarMenuMessage);
    }

    public void setOfficialBarMenuDatas(c cVar) {
        this.officialBarMenuDatas = cVar;
    }

    public void setUserType(int i2) {
        this.mUserType = i2;
    }
}
