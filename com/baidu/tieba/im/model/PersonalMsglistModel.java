package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.util.ChatStatusManager;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.ax;
import com.baidu.tieba.im.chat.receiveChatMsgHandler.m;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.data.b;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.g;
import com.baidu.tieba.im.h;
import com.baidu.tieba.im.l;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadPersonalDraftMessage;
import com.baidu.tieba.im.message.LoadPersonalHistoryMessage;
import com.baidu.tieba.im.message.PersonalSaveDraftMessage;
import com.baidu.tieba.im.message.RequestPersonalMsgReadMessage;
import com.baidu.tieba.im.message.a;
import com.baidu.tieba.im.message.c;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.message.r;
import com.baidu.tieba.im.model.MsglistModel;
import com.baidu.tieba.im.util.i;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class PersonalMsglistModel extends CommonPersonalMsglistModel {
    private final int MSG_COUNT_PER;
    private CardStatus cardStatus;
    private int isFriend;
    private CustomMessageListener mCustomMessageListener;
    private boolean mReceiveOther;
    private ChatMessage mUnShowSystemMessage;
    private String replyContent;

    /* loaded from: classes.dex */
    public enum CardStatus {
        APPLY,
        WAIT,
        AGREE,
        PASS;

        /* JADX DEBUG: Replace access to removed values field (ENUM$VALUES) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static CardStatus[] valuesCustom() {
            CardStatus[] valuesCustom = values();
            int length = valuesCustom.length;
            CardStatus[] cardStatusArr = new CardStatus[length];
            System.arraycopy(valuesCustom, 0, cardStatusArr, 0, length);
            return cardStatusArr;
        }
    }

    public PersonalMsglistModel() {
        this.MSG_COUNT_PER = 20;
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.PersonalMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ax callback;
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2013001) {
                        PersonalMsglistModel.this.processServerMsg(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001147) {
                        PersonalMsglistModel.this.processDraft(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001150) {
                        boolean processHistory = PersonalMsglistModel.this.processHistory(customResponsedMessage);
                        if ((customResponsedMessage.getOrginalMessage() instanceof LoadHistoryMessage) && processHistory && (callback = ((LoadHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                            callback.onFirstHistoryPageLoaded();
                        }
                    }
                }
            }
        };
    }

    public PersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.MSG_COUNT_PER = 20;
        this.mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.PersonalMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                ax callback;
                if (customResponsedMessage != null) {
                    if (customResponsedMessage.getCmd() == 2013001) {
                        PersonalMsglistModel.this.processServerMsg(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001147) {
                        PersonalMsglistModel.this.processDraft(customResponsedMessage);
                    } else if (customResponsedMessage.getCmd() == 2001150) {
                        boolean processHistory = PersonalMsglistModel.this.processHistory(customResponsedMessage);
                        if ((customResponsedMessage.getOrginalMessage() instanceof LoadHistoryMessage) && processHistory && (callback = ((LoadHistoryMessage) customResponsedMessage.getOrginalMessage()).getCallback()) != null) {
                            callback.onFirstHistoryPageLoaded();
                        }
                    }
                }
            }
        };
        registerListener();
        this.customGroupType = 2;
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void onDestroy() {
        super.onDestroy();
        unRegisterListener();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage genChatMessage() {
        if (this.mUser == null) {
            return null;
        }
        PersonalChatMessage personalChatMessage = new PersonalChatMessage();
        personalChatMessage.setBornTime(System.currentTimeMillis());
        personalChatMessage.setToUserId(this.mUser.getUserIdLong());
        UserData userData = new UserData();
        userData.setUserId(String.valueOf(this.mUser.getUserId()));
        userData.setUserName(this.mUser.getUserName());
        userData.setPortrait(this.mUser.getPortrait());
        personalChatMessage.setToUserInfo(userData);
        personalChatMessage.setIsFriend(this.isFriend);
        return personalChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadFirst(ax axVar) {
        if (this.mUser == null) {
            return false;
        }
        c cVar = new c();
        cVar.limit = 20;
        cVar.bks = null;
        cVar.bkt = null;
        cVar.id = new StringBuilder(String.valueOf(this.mUser.getUserIdLong())).toString();
        LoadPersonalHistoryMessage loadPersonalHistoryMessage = new LoadPersonalHistoryMessage(cVar);
        loadPersonalHistoryMessage.setCallback(axVar);
        super.sendMessage(loadPersonalHistoryMessage);
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadPrepage() {
        long j;
        long j2 = 0;
        if (this.mUser != null) {
            c cVar = new c();
            cVar.limit = 20;
            if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() <= 0 || this.mDatas.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j = this.mDatas.getChatMessages().get(0).getMsgId();
                j2 = this.mDatas.getChatMessages().get(0).getRecordId();
            }
            cVar.bks = String.valueOf(j);
            cVar.bkt = String.valueOf(j2);
            cVar.id = new StringBuilder(String.valueOf(this.mUser.getUserIdLong())).toString();
            super.sendMessage(new LoadPersonalHistoryMessage(cVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean loadDraft() {
        if (this.mUser == null) {
            return false;
        }
        a aVar = new a();
        aVar.id = this.mUser.getUserId();
        super.sendMessage(new LoadPersonalDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean saveDraftContent(String str) {
        r rVar = new r();
        if (this.mUser == null) {
            return false;
        }
        rVar.mId = String.valueOf(String.valueOf(this.mUser.getUserId()));
        rVar.mDraft = str;
        super.sendMessage(new PersonalSaveDraftMessage(rVar));
        return true;
    }

    public CardStatus getCurrentStatus(b bVar) {
        if (bVar == null) {
            return CardStatus.APPLY;
        }
        if (bVar.getStatus() == 0) {
            return CardStatus.APPLY;
        }
        if (bVar.getStatus() == 3) {
            return CardStatus.WAIT;
        }
        if (bVar.getStatus() == 1) {
            return CardStatus.AGREE;
        }
        return CardStatus.APPLY;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void deleteMsg(final ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            l.a(new h<Boolean>() { // from class: com.baidu.tieba.im.model.PersonalMsglistModel.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.im.h
                public Boolean doInBackground() {
                    return Boolean.valueOf(n.PZ().aA(String.valueOf(PersonalMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void markDeleteMsg(final ChatMessage chatMessage) {
        if (this.mUser != null && chatMessage != null) {
            l.a(new h<Boolean>() { // from class: com.baidu.tieba.im.model.PersonalMsglistModel.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.baidu.tieba.im.h
                public Boolean doInBackground() {
                    return Boolean.valueOf(n.PZ().az(String.valueOf(PersonalMsglistModel.this.mUser.getUserId()), String.valueOf(chatMessage.getMsgId())));
                }
            }, null);
        }
    }

    private void registerListener() {
        registerListener(2013001, this.mCustomMessageListener);
        registerListener(2001147, this.mCustomMessageListener);
        registerListener(2001150, this.mCustomMessageListener);
    }

    protected void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
        BdLog.i("see picUpLoading unregister");
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected boolean onAfterLoadFromDb() {
        ImMessageCenterPojo D;
        if (getUser() == null || (D = com.baidu.tieba.im.memorycache.c.Sd().D(getUser().getUserId(), 2)) == null) {
            return false;
        }
        processReadStatus(D.getRead_msgId());
        sendHasReadMessage();
        return true;
    }

    protected void processServerMsg(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (getUser() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                this.mReceiveOther = false;
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof PersonalChatMessage) {
                        if (chatMessage.getMsgType() == 22) {
                            if (this.mUnShowSystemMessage == null) {
                                this.mUnShowSystemMessage = chatMessage;
                            } else if (this.mUnShowSystemMessage.getMsgId() < chatMessage.getMsgId()) {
                                this.mUnShowSystemMessage = chatMessage;
                            }
                        } else if (chatMessage.getToUserId() == getUser().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == getUser().getUserIdLong()) {
                            this.mReceiveOther = true;
                            linkedList.add(chatMessage);
                        }
                    }
                }
                processMsgFromServerCommon(linkedList);
                if (ChatStatusManager.getInst().getIsOpen(0)) {
                    sendHasReadReceiveOther();
                }
            }
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected boolean onAfterProcessMsgFromServer() {
        if (this.mUnShowSystemMessage == null || this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0 || i.s(this.mUnShowSystemMessage)) {
            return false;
        }
        processReadStatus(m.g(this.mUnShowSystemMessage));
        return true;
    }

    private void processReadStatus(long j) {
        if (j > 0) {
            for (ChatMessage chatMessage : this.mDatas.getChatMessages()) {
                if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 3) {
                    if (chatMessage.getMsgId() <= j) {
                        chatMessage.setHasRead(true);
                    } else {
                        chatMessage.setHasRead(false);
                    }
                }
            }
        }
    }

    public int getIsFriend() {
        return this.isFriend;
    }

    public void setIsFriend(int i) {
        this.isFriend = i;
    }

    public String getReplyContent() {
        return this.replyContent;
    }

    public void setReplyContent(String str) {
        this.replyContent = str;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected MsglistModel.CacheInfo getCacheInfo() {
        if (this.mUser == null) {
            return null;
        }
        MsglistModel.CacheInfo cacheInfo = new MsglistModel.CacheInfo();
        cacheInfo.id = this.mUser.getUserId();
        cacheInfo.customGroupType = 2;
        return cacheInfo;
    }

    public void sendHasReadReceiveOther() {
        if (this.mReceiveOther) {
            sendHasReadMessage();
            this.mReceiveOther = false;
        }
    }

    public CardStatus getCardStatus() {
        return this.cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    private void sendHasReadMessage() {
        ImMessageCenterPojo D;
        if (getUser() != null) {
            long userIdLong = getUser().getUserIdLong();
            if (userIdLong != 0 && (D = com.baidu.tieba.im.memorycache.c.Sd().D(getUser().getUserId(), 2)) != null) {
                long otherMaxMsgId = getOtherMaxMsgId();
                if (otherMaxMsgId > D.getSent_msgId()) {
                    RequestPersonalMsgReadMessage requestPersonalMsgReadMessage = new RequestPersonalMsgReadMessage(com.baidu.tieba.im.util.h.ag(otherMaxMsgId), userIdLong);
                    if (!MessageManager.getInstance().getSocketClient().a(requestPersonalMsgReadMessage)) {
                        MessageManager.getInstance().sendMessage(requestPersonalMsgReadMessage);
                    }
                }
            }
        }
    }

    private long getOtherMaxMsgId() {
        if (this.mDatas == null || this.mDatas.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0) {
            return -1L;
        }
        for (int size = this.mDatas.getChatMessages().size() - 1; size >= 0; size--) {
            ChatMessage chatMessage = this.mDatas.getChatMessages().get(size);
            if (chatMessage.getUserId() != 0 && !String.valueOf(chatMessage.getUserId()).equals(TbadkCoreApplication.getCurrentAccount())) {
                return chatMessage.getMsgId();
            }
        }
        return -1L;
    }

    public void insertReplyCard(final String str) {
        l.a(new h<CommonMsgPojo>() { // from class: com.baidu.tieba.im.model.PersonalMsglistModel.4
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.baidu.tieba.im.h
            public CommonMsgPojo doInBackground() {
                return n.PZ().B(PersonalMsglistModel.this.getUser().getUserId(), 23);
            }
        }, new g<CommonMsgPojo>() { // from class: com.baidu.tieba.im.model.PersonalMsglistModel.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.im.g
            public void onReturnDataInUI(CommonMsgPojo commonMsgPojo) {
                if (commonMsgPojo == null) {
                    final ChatMessage createMessage = PersonalMsglistModel.this.createMessage((short) 23, str);
                    final PersonalChatMessage personalChatMessage = (PersonalChatMessage) createMessage;
                    final LinkedList linkedList = new LinkedList();
                    CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(createMessage);
                    commonMsgPojo2.setRead_flag(0);
                    linkedList.add(commonMsgPojo2);
                    l.a(new h<Boolean>() { // from class: com.baidu.tieba.im.model.PersonalMsglistModel.5.1
                        /* JADX DEBUG: Method merged with bridge method */
                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // com.baidu.tieba.im.h
                        public Boolean doInBackground() {
                            return Boolean.valueOf(n.PZ().a(i.o(personalChatMessage), linkedList, false));
                        }
                    }, new g<Boolean>() { // from class: com.baidu.tieba.im.model.PersonalMsglistModel.5.2
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.tieba.im.g
                        public void onReturnDataInUI(Boolean bool) {
                            if (bool != null && bool.booleanValue()) {
                                PersonalMsglistModel.this.mDatas.getChatMessages().add(createMessage);
                                PersonalMsglistModel.this.mLoadDataMode = 14;
                                PersonalMsglistModel.this.mLoadDataCallBack.c(PersonalMsglistModel.this.mDatas);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected long getMaxMid() {
        return com.baidu.tieba.im.memorycache.c.Sd().H(String.valueOf(com.baidu.tieba.im.c.a.bmu), -1);
    }
}
