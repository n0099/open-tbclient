package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.a.b.a.a.i;
import com.baidu.adp.lib.g.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.img.b;
import com.baidu.tieba.im.c.a;
import com.baidu.tieba.im.c.ae;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.au;
import com.baidu.tieba.im.chat.cv;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.n;
import com.baidu.tieba.im.db.o;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.g;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.im.util.h;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class MsglistModel extends f<Object> {
    public static final int GAME_SHARE_COUNT_OVER = 3100001;
    public static final int MODE_TYPE_CHAT_ROOM_RULE = 13;
    public static final int MODE_TYPE_CLEAR_HISTORY = 12;
    public static final int MODE_TYPE_DELETE_MSG = 7;
    public static final int MODE_TYPE_FIRST_GET_MSGS = 1;
    public static final int MODE_TYPE_INSERT_REPLY_CARD = 14;
    public static final int MODE_TYPE_LOAD_DRAFT = 8;
    public static final int MODE_TYPE_NAME_UPDATE = 10;
    public static final int MODE_TYPE_PRE = 2;
    public static final int MODE_TYPE_PUSH = 3;
    public static final int MODE_TYPE_QUIT_GROUP = 9;
    public static final int MODE_TYPE_RESEND = 6;
    public static final int MODE_TYPE_SEND = 5;
    public static final int MODE_TYPE_SENDING = 4;
    public static final int MODE_TYPE_UNLOGIN = 11;
    public static final int NOT_FRIEND_ERROR = 3160008;
    private static final int TYPE_DELETE_FAIL_MSG = 1;
    private static final int TYPE_DELETE_SUC_MSG = 2;
    private final int DURATION_TIME_OUT;
    protected int customGroupType;
    private boolean isAcceptNotify;
    protected MsglistActivity<?> mActivity;
    private final CustomMessageListener mCustomListenerInMessageCenter;
    protected MsgPageData mDatas;
    private String mDraft;
    protected long mId;
    private CustomMessageListener mListenerUnLogin;
    private ae mSendCallback;

    /* loaded from: classes.dex */
    public class CacheInfo {
        public int customGroupType;
        public String id;
    }

    protected abstract void deleteMsg(ChatMessage chatMessage);

    protected abstract ChatMessage genChatMessage();

    protected abstract CacheInfo getCacheInfo();

    protected abstract long getMaxMid();

    public abstract boolean loadDraft();

    public abstract boolean loadFirst(au auVar);

    public abstract boolean loadPrepage();

    protected abstract void markDeleteMsg(ChatMessage chatMessage);

    public abstract boolean saveDraftContent(String str);

    public MsglistModel() {
        this.DURATION_TIME_OUT = 1800;
        this.isAcceptNotify = true;
        this.mDatas = null;
        this.mCustomListenerInMessageCenter = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.MsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001113) {
                    MsglistModel.this.refreshAfterClearHistory();
                } else if (customResponsedMessage.getCmd() == 501126 && (customResponsedMessage instanceof ResponsedMessage)) {
                    MsglistModel.this.mDatas.getChatMessages().add((ChatMessage) customResponsedMessage.getOrginalMessage());
                    MsglistModel.this.mLoadDataCallBack.c(MsglistModel.this.mDatas);
                }
            }
        };
        this.mListenerUnLogin = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.MsglistModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponseUnLoginMessage) {
                    MsglistModel.this.mLoadDataMode = 11;
                    MsglistModel.this.mLoadDataCallBack.c(null);
                }
            }
        };
    }

    public MsglistModel(MsglistActivity<Object> msglistActivity) {
        super(msglistActivity.getPageContext());
        this.DURATION_TIME_OUT = 1800;
        this.isAcceptNotify = true;
        this.mDatas = null;
        this.mCustomListenerInMessageCenter = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.MsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001113) {
                    MsglistModel.this.refreshAfterClearHistory();
                } else if (customResponsedMessage.getCmd() == 501126 && (customResponsedMessage instanceof ResponsedMessage)) {
                    MsglistModel.this.mDatas.getChatMessages().add((ChatMessage) customResponsedMessage.getOrginalMessage());
                    MsglistModel.this.mLoadDataCallBack.c(MsglistModel.this.mDatas);
                }
            }
        };
        this.mListenerUnLogin = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.MsglistModel.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponseUnLoginMessage) {
                    MsglistModel.this.mLoadDataMode = 11;
                    MsglistModel.this.mLoadDataCallBack.c(null);
                }
            }
        };
        this.mActivity = msglistActivity;
        this.mDatas = new MsgPageData();
        registerListener();
    }

    private void registerListener() {
        registerListener(2001157, this.mListenerUnLogin);
        registerListener(2001113, this.mCustomListenerInMessageCenter);
        registerListener(501126, this.mCustomListenerInMessageCenter);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mListenerUnLogin);
        MessageManager.getInstance().unRegisterListener(this.mCustomListenerInMessageCenter);
    }

    public MsgPageData getData() {
        return this.mDatas;
    }

    public boolean getIsAcceptNotify() {
        return this.isAcceptNotify;
    }

    public void setIsAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }

    public void setDraft(String str) {
        this.mDraft = str;
    }

    public String getDraft() {
        return this.mDraft;
    }

    @Override // com.baidu.adp.base.f
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.f
    public boolean cancelLoadData() {
        return false;
    }

    public void onDestroy() {
        a.To().setSendCallback(null);
        unRegisterListener();
    }

    public boolean saveDraft(String str) {
        if (this.mDraft == null || !this.mDraft.equals(str)) {
            return saveDraftContent(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ChatMessage createMessage(short s, String str) {
        long j;
        ChatMessage genChatMessage = genChatMessage();
        if (genChatMessage == null) {
            return null;
        }
        genChatMessage.setCustomGroupType(this.customGroupType);
        genChatMessage.setMsgType(s);
        genChatMessage.setContent(str);
        long ae = h.ae(getLastMid());
        genChatMessage.setMsgId(ae);
        genChatMessage.setRecordId(ae);
        genChatMessage.setTime(System.currentTimeMillis() / 1000);
        UserData userData = new UserData();
        userData.setUserName(TbadkCoreApplication.getCurrentAccountName());
        userData.setUserId(TbadkCoreApplication.getCurrentAccount());
        userData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
        genChatMessage.setUserInfo(userData);
        try {
            j = c.a(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
            j = 0;
        }
        genChatMessage.setUserId(j);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        genChatMessage.setLocalData(msgLocalData);
        return genChatMessage;
    }

    public long getLastMid() {
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        return (chatMessages == null || chatMessages.size() <= 0) ? getMaxMid() : chatMessages.get(chatMessages.size() - 1).getMsgId();
    }

    public void sendTextMessage(String str) {
        ChatMessage createMessage = createMessage((short) 1, str);
        if (createMessage != null) {
            this.mDatas.getChatMessages().add(createMessage);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.c(this.mDatas);
            doSendText(createMessage);
        }
    }

    public void sendExtraMessage(String str) {
        ChatMessage createMessage = createMessage((short) 9, str);
        if (createMessage != null) {
            this.mDatas.getChatMessages().add(createMessage);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.c(this.mDatas);
            doSendText(createMessage);
        }
    }

    public void sendReplyCardMessage(String str) {
        ChatMessage createMessage = createMessage((short) 23, str);
        if (createMessage != null) {
            this.mDatas.getChatMessages().add(createMessage);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.c(this.mDatas);
            doSendText(createMessage);
        }
    }

    public void sendBigEmotionMessage(com.baidu.tbadk.coreExtra.data.f fVar) {
        ChatMessage createMessage;
        String buildBigEmotionContent = buildBigEmotionContent(fVar);
        if (buildBigEmotionContent != null && (createMessage = createMessage((short) 4, buildBigEmotionContent)) != null) {
            this.mDatas.getChatMessages().add(createMessage);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.c(this.mDatas);
            doSendText(createMessage);
        }
    }

    private String buildBigEmotionContent(com.baidu.tbadk.coreExtra.data.f fVar) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pid", fVar.getPid());
            jSONObject.put("packet_name", fVar.rN());
            jSONObject.put("face_name", fVar.getName());
            jSONObject.put("size_width", fVar.getWidth());
            jSONObject.put("size_height", fVar.getHeight());
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void sendMsgVoice(String str, int i) {
        VoiceMsgData voiceMsgData = new VoiceMsgData();
        voiceMsgData.setDuring_time(i);
        voiceMsgData.setVoice_md5(str);
        voiceMsgData.setHas_read(0);
        ChatMessage createMessage = createMessage((short) 3, "[" + i.jsonStrWithObject(voiceMsgData) + "]");
        if (createMessage != null) {
            createMessage.setCacheData(null);
            this.mDatas.getChatMessages().add(createMessage);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.c(this.mDatas);
            if (createMessage instanceof CommonGroupChatMessage) {
                final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) createMessage;
                final LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                com.baidu.tieba.im.i.a(new com.baidu.tieba.im.h<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.3
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tieba.im.h
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.db.c.MQ().a(commonGroupChatMessage.getGroupId(), linkedList, false));
                    }
                }, new g<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.im.g
                    public void onReturnDataInUI(Boolean bool) {
                        MsglistModel.this.doSendVoice(commonGroupChatMessage);
                    }
                });
            } else if (createMessage instanceof PersonalChatMessage) {
                final PersonalChatMessage personalChatMessage = (PersonalChatMessage) createMessage;
                final LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(personalChatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                com.baidu.tieba.im.i.a(new com.baidu.tieba.im.h<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.5
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tieba.im.h
                    public Boolean doInBackground() {
                        return Boolean.valueOf(o.Nk().a(com.baidu.tieba.im.util.i.n(personalChatMessage), linkedList2, false));
                    }
                }, new g<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.im.g
                    public void onReturnDataInUI(Boolean bool) {
                        MsglistModel.this.doSendVoice(personalChatMessage);
                    }
                });
            } else if (createMessage instanceof OfficialChatMessage) {
                final OfficialChatMessage officialChatMessage = (OfficialChatMessage) createMessage;
                final LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(officialChatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                com.baidu.tieba.im.i.a(new com.baidu.tieba.im.h<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.7
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tieba.im.h
                    public Boolean doInBackground() {
                        return Boolean.valueOf(n.Nj().a(com.baidu.tieba.im.util.i.n(officialChatMessage), linkedList3, false));
                    }
                }, new g<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.8
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.im.g
                    public void onReturnDataInUI(Boolean bool) {
                        MsglistModel.this.doSendVoice(officialChatMessage);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendVoice(ChatMessage chatMessage) {
        VoiceMsgData u = com.baidu.tieba.im.util.i.u(chatMessage);
        if (u != null) {
            chatMessage.setLogTime(System.currentTimeMillis());
            a.h(chatMessage);
            a.To().a(u, chatMessage);
        }
    }

    public void sendPicMessage(final String str, Bitmap bitmap) {
        ChatMessage createMessage;
        if (bitmap != null && (createMessage = createMessage((short) 2, a.b(str, str, bitmap.getWidth(), bitmap.getHeight()))) != null) {
            createMessage.setIsUploading(true);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            createMessage.setWidth(width);
            createMessage.setHeight(height);
            this.mDatas.getChatMessages().add(createMessage);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.c(this.mDatas);
            if (createMessage instanceof CommonGroupChatMessage) {
                final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) createMessage;
                final LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                com.baidu.tieba.im.i.a(new com.baidu.tieba.im.h<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.9
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tieba.im.h
                    public Boolean doInBackground() {
                        return Boolean.valueOf(com.baidu.tieba.im.db.c.MQ().a(commonGroupChatMessage.getGroupId(), linkedList, false));
                    }
                }, new g<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.10
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.im.g
                    public void onReturnDataInUI(Boolean bool) {
                        MsglistModel.this.doSendPic(commonGroupChatMessage, str);
                    }
                });
            } else if (createMessage instanceof PersonalChatMessage) {
                final PersonalChatMessage personalChatMessage = (PersonalChatMessage) createMessage;
                final LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(personalChatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                com.baidu.tieba.im.i.a(new com.baidu.tieba.im.h<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.11
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tieba.im.h
                    public Boolean doInBackground() {
                        return Boolean.valueOf(o.Nk().a(com.baidu.tieba.im.util.i.n(personalChatMessage), linkedList2, false));
                    }
                }, new g<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.12
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.im.g
                    public void onReturnDataInUI(Boolean bool) {
                        MsglistModel.this.doSendPic(personalChatMessage, str);
                    }
                });
            } else if (createMessage instanceof OfficialChatMessage) {
                final OfficialChatMessage officialChatMessage = (OfficialChatMessage) createMessage;
                final LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(officialChatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                com.baidu.tieba.im.i.a(new com.baidu.tieba.im.h<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.13
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.baidu.tieba.im.h
                    public Boolean doInBackground() {
                        return Boolean.valueOf(n.Nj().a(com.baidu.tieba.im.util.i.n(officialChatMessage), linkedList3, false));
                    }
                }, new g<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.14
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.im.g
                    public void onReturnDataInUI(Boolean bool) {
                        MsglistModel.this.doSendPic(officialChatMessage, str);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendPic(ChatMessage chatMessage, String str) {
        if (chatMessage != null) {
            if (chatMessage.getContent() == null) {
                sendMsgFail(chatMessage);
            }
            if (str == null) {
                try {
                    str = new JSONArray(chatMessage.getContent()).getJSONObject(0).optString("src");
                } catch (Exception e) {
                    e.printStackTrace();
                    sendMsgFail(chatMessage);
                    return;
                }
            }
            if (str == null) {
                sendMsgFail(chatMessage);
                return;
            }
            chatMessage.setProgressValue(0);
            chatMessage.setIsUploading(true);
            if (str.startsWith("http")) {
                a.To().m(chatMessage);
            } else {
                a.To().c(chatMessage, str);
            }
        }
    }

    public void reSendMsg(int i) {
        ChatMessage msg = getMsg(i);
        if (msg != null && msg.getLocalData() != null && msg.getLocalData().getStatus() != null && msg.getLocalData().getStatus().shortValue() == 2) {
            msg.setRecordId(msg.getMsgId());
            msg.getLocalData().setStatus((short) 1);
            msg.setTime(System.currentTimeMillis() / 1000);
            msg.setCustomGroupType(this.customGroupType);
            switch (msg.getMsgType()) {
                case 1:
                    doSendText(msg);
                    break;
                case 2:
                    doSendPic(msg, null);
                    break;
                case 3:
                    doSendVoice(msg);
                    break;
                case 4:
                    doSendText(msg);
                    break;
                case 9:
                    doSendText(msg);
                    break;
            }
            this.mLoadDataMode = 6;
            this.mLoadDataCallBack.c(this.mDatas);
            updateMsgResend(i, msg);
        }
    }

    public ChatMessage getMsg(int i) {
        if (this.mDatas == null || this.mDatas.getChatMessages() == null || i < 0 || i >= this.mDatas.getChatMessages().size()) {
            return null;
        }
        return this.mDatas.getChatMessages().get(i);
    }

    public void deleteMsg(int i) {
        processDeleteMsg(1, i);
    }

    private void processDeleteMsg(int i, int i2) {
        CacheInfo cacheInfo;
        int size = this.mDatas.getChatMessages().size();
        if (i2 >= 0 && i2 < size) {
            ChatMessage chatMessage = this.mDatas.getChatMessages().get(i2);
            switch (i) {
                case 1:
                    deleteMsg(chatMessage);
                    break;
                case 2:
                    markDeleteMsg(chatMessage);
                    break;
            }
            ChatMessage chatMessage2 = i2 + (-1) >= 0 ? this.mDatas.getChatMessages().get(i2 - 1) : null;
            markDeleteMsg(chatMessage);
            this.mDatas.getChatMessages().remove(i2);
            if (i2 == size - 1 && (cacheInfo = getCacheInfo()) != null) {
                com.baidu.tieba.im.message.f fVar = new com.baidu.tieba.im.message.f();
                fVar.customGroupType = cacheInfo.customGroupType;
                fVar.id = cacheInfo.id;
                fVar.bjk = chatMessage2;
                fVar.type = 2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryModifyLastMsgMessage(fVar));
            }
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.c(null);
    }

    public void markDeleteMsg(int i) {
        processDeleteMsg(2, i);
    }

    public void updateMsgResend(int i, ChatMessage chatMessage) {
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        int size = chatMessages.size();
        if (i >= 0 && i < size) {
            chatMessages.remove(i);
            chatMessages.add(i, chatMessage);
            this.mDatas.setIsNewAdd(false);
            this.mDatas.setNewAddNum(0);
        }
    }

    public void doSendText(ChatMessage chatMessage) {
        a.To().m(chatMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean processHistory(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() == null) {
                return true;
            }
            if (this.mId == 0 || this.mId == c.a(loadHistoryResponsedMessage.getData().id, 0L)) {
                List<ChatMessage> list = loadHistoryResponsedMessage.getData().msgList;
                boolean z = loadHistoryResponsedMessage.getData().isFirst;
                int mergeList = mergeList(this.mDatas.getChatMessages(), list);
                if (mergeList > 0) {
                    this.mDatas.setIsNewAdd(true);
                    this.mDatas.setNewAddNum(mergeList);
                } else {
                    this.mDatas.setIsNewAdd(false);
                    this.mDatas.setNewAddNum(0);
                }
                updateMsgStatusTimeOut(this.mDatas.getChatMessages());
                onAfterLoadFromDb();
                if (z) {
                    if (this.mDatas.getIsNewAdd()) {
                        this.mLoadDataMode = 1;
                        this.mLoadDataCallBack.c(null);
                    }
                    return true;
                }
                if (this.mDatas.getIsNewAdd()) {
                    this.mLoadDataMode = 2;
                    this.mLoadDataCallBack.c(null);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    protected boolean onAfterLoadFromDb() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processDraft(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof LoadDraftResponsedMessage) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = (LoadDraftResponsedMessage) customResponsedMessage;
            if (loadDraftResponsedMessage.getData() != null) {
                String str = loadDraftResponsedMessage.getData().mDraft;
                this.mLoadDataMode = 8;
                this.mLoadDataCallBack.c(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ChatMessage> processMsgFromServerCommon(List<ChatMessage> list) {
        ChatMessage chatMessage;
        String valueOf;
        updatePortraintAndNetWork(list);
        delRepeatMsg(this.mDatas.getChatMessages(), list);
        Collections.sort(list, new CompareChatMessage(this, null));
        boolean z = (list == null || list.isEmpty() || (chatMessage = list.get(list.size() + (-1))) == null || (valueOf = String.valueOf(chatMessage.getUserId())) == null || !valueOf.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        int mergeList = mergeList(this.mDatas.getChatMessages(), list);
        boolean onAfterProcessMsgFromServer = onAfterProcessMsgFromServer();
        if (mergeList > 0 || onAfterProcessMsgFromServer) {
            this.mDatas.setIsNewAdd(true);
            this.mDatas.setNewAddNum(mergeList);
            if (!z) {
                this.mLoadDataMode = 3;
            }
            this.mLoadDataCallBack.c(this.mDatas);
        } else {
            this.mDatas.setIsNewAdd(false);
            this.mDatas.setNewAddNum(0);
        }
        return list;
    }

    protected boolean onAfterProcessMsgFromServer() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void processMsgACK(ResponseCommitMessage responseCommitMessage) {
        if (responseCommitMessage != null) {
            if (responseCommitMessage.getOrginalMessage() == null || !(responseCommitMessage.getOrginalMessage() instanceof ChatMessage)) {
                TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "chatResMessage.getOrginalMessage()==null", "return", (String) null, 0, (String) null);
                return;
            }
            ChatMessage chatMessage = (ChatMessage) responseCommitMessage.getOrginalMessage();
            if (responseCommitMessage.getError() != 0) {
                TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "", "", String.valueOf(createMsgLog(chatMessage)) + "rid" + chatMessage.getRecordId(), responseCommitMessage.getError(), responseCommitMessage.getErrorString(), System.currentTimeMillis() - chatMessage.getLogTime());
                if (responseCommitMessage.getError() > 0 && responseCommitMessage.getError() != 3160008 && responseCommitMessage.getError() != 3100001) {
                    this.mActivity.showToast(responseCommitMessage.getErrorString());
                    if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
                        responseCommitMessage.setRecordId(chatMessage.getRecordId());
                        TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "orginalRecordId != serverRecordId", "", (String) null, responseCommitMessage.getError(), responseCommitMessage.getErrorString());
                    }
                }
                sendMsgFail(chatMessage);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - chatMessage.getLogTime();
            long recordId = responseCommitMessage.getRecordId();
            long msgId = responseCommitMessage.getMsgId();
            TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "", "", "rid = " + recordId + "msgId = " + msgId + createMsgLog(chatMessage), responseCommitMessage.getError(), responseCommitMessage.getErrorString(), currentTimeMillis);
            if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
                responseCommitMessage.setRecordId(chatMessage.getRecordId());
                TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "orginalRecordId != serverRecordId", "", (String) null, responseCommitMessage.getError(), responseCommitMessage.getErrorString());
            }
            sendMsgSuc(responseCommitMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void refreshAfterClearHistory() {
        if (this.mDatas != null && this.mDatas.getChatMessages() != null && this.mDatas.getChatMessages().size() != 0) {
            this.mDatas.getChatMessages().clear();
            this.mLoadDataMode = 12;
            this.mLoadDataCallBack.c(null);
        }
    }

    private int mergeList(List<ChatMessage> list, List<ChatMessage> list2) {
        if (list == null || list2 == null) {
            return 0;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size2 == 0) {
            return 0;
        }
        if (size == 0) {
            list.addAll(list2);
            return size2;
        }
        int i = size2 - 1;
        int i2 = size - 1;
        int i3 = 0;
        while (i2 >= 0 && i >= 0) {
            long recordId = list.get(i2).getRecordId();
            ChatMessage chatMessage = list2.get(i);
            long recordId2 = chatMessage.getRecordId();
            if (recordId > recordId2) {
                i2--;
            } else if (recordId < recordId2) {
                list.add(i2 + 1, chatMessage);
                i--;
                i3++;
            } else {
                i--;
                i2--;
            }
        }
        if (i >= 0) {
            while (i >= 0) {
                list.add(0, list2.get(i));
                i3++;
                i--;
            }
        }
        return i3;
    }

    private void delRepeatMsg(List<ChatMessage> list, List<ChatMessage> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size2 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = size - 1; i >= 0 && i >= 0; i--) {
                    ChatMessage chatMessage = list.get(i);
                    if (chatMessage != null && chatMessage.getUserInfo() != null && !TextUtils.isEmpty(chatMessage.getUserInfo().getUserId()) && chatMessage.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) && chatMessage.getLocalData() != null && (chatMessage.getLocalData().getStatus().shortValue() != 3 || chatMessage.getMsgType() == 4)) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                ChatMessage chatMessage2 = list2.get(i2);
                                if (chatMessage2 != null && chatMessage2.getUserInfo() != null && !TextUtils.isEmpty(chatMessage2.getUserInfo().getUserId()) && chatMessage2.getUserInfo().getUserId().equals(TbadkCoreApplication.getCurrentAccount()) && chatMessage2.getRecordId() == chatMessage.getRecordId()) {
                                    arrayList.add(chatMessage);
                                    break;
                                }
                                i2--;
                            }
                        }
                    }
                }
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    list.remove(arrayList.get(i3));
                }
                arrayList.clear();
            }
        }
    }

    private void updateMsgStatusTimeOut(List<ChatMessage> list) {
        if (list != null && list.size() != 0) {
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 1) {
                    chatMessage.setCustomGroupType(this.customGroupType);
                    if ((System.currentTimeMillis() / 1000) - chatMessage.getTime() > 1800) {
                        chatMessage.getLocalData().setStatus((short) 2);
                    } else {
                        boolean z = false;
                        if (MessageManager.getInstance().getSocketClient() != null) {
                            z = MessageManager.getInstance().getSocketClient().a(chatMessage);
                        }
                        if (!z && (chatMessage.getMsgType() != 2 || !a.To().i(chatMessage))) {
                            if (chatMessage.getMsgType() != 3 || !a.To().l(chatMessage)) {
                                chatMessage.getLocalData().setStatus((short) 2);
                            }
                        }
                    }
                }
            }
        }
    }

    private void sendMsgSuc(ResponseCommitMessage responseCommitMessage) {
        if (responseCommitMessage != null) {
            List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
            long recordId = responseCommitMessage.getRecordId();
            long msgId = responseCommitMessage.getMsgId();
            this.mDatas.setNewAddNum(0);
            this.mDatas.setIsNewAdd(false);
            int size = chatMessages.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (recordId != chatMessages.get(size).getRecordId()) {
                    size--;
                } else {
                    ChatMessage chatMessage = chatMessages.get(size);
                    if (chatMessage.getLocalData() == null) {
                        MsgLocalData msgLocalData = new MsgLocalData();
                        msgLocalData.setStatus((short) 1);
                        msgLocalData.setErrno(0L);
                        msgLocalData.setRetry(0L);
                        msgLocalData.setUpload_offset(null);
                        chatMessage.setLocalData(msgLocalData);
                    }
                    chatMessage.setMsgId(msgId);
                    chatMessage.getLocalData().setStatus((short) 3);
                }
            }
            this.mLoadDataMode = 5;
            this.mLoadDataCallBack.c(this.mDatas);
            if (this.mSendCallback != null) {
                this.mSendCallback.gB(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void sendMsgFail(ChatMessage chatMessage) {
        if (chatMessage != null) {
            chatMessage.setIsUploading(false);
            if (chatMessage.getLocalData() == null) {
                MsgLocalData msgLocalData = new MsgLocalData();
                msgLocalData.setStatus((short) 1);
                msgLocalData.setErrno(0L);
                msgLocalData.setRetry(0L);
                msgLocalData.setUpload_offset(null);
                chatMessage.setLocalData(msgLocalData);
            }
            chatMessage.getLocalData().setStatus((short) 2);
            List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
            if (chatMessages != null && chatMessages.size() != 0) {
                long recordId = chatMessage.getRecordId();
                int size = chatMessages.size() - 1;
                while (size >= 0 && chatMessages.get(size).getMsgId() != recordId) {
                    size--;
                }
                if (size >= 0) {
                    chatMessages.remove(size);
                    chatMessages.add(size, chatMessage);
                    this.mDatas.setNewAddNum(0);
                    this.mDatas.setIsNewAdd(false);
                    this.mLoadDataMode = 5;
                    this.mLoadDataCallBack.c(this.mDatas);
                }
            }
        }
    }

    private String createMsgLog(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return "";
        }
        int msgType = chatMessage.getMsgType();
        String string = TbadkCoreApplication.m255getInst().getApp().getString(z.websocket_type);
        switch (msgType) {
            case 1:
                return String.valueOf(string) + TbadkCoreApplication.m255getInst().getApp().getString(z.log_msg_text);
            case 2:
                return String.valueOf(string) + TbadkCoreApplication.m255getInst().getApp().getString(z.log_msg_pic);
            case 3:
                return String.valueOf(string) + TbadkCoreApplication.m255getInst().getApp().getString(z.log_msg_voice);
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return "";
            case 9:
                return String.valueOf(string) + TbadkCoreApplication.m255getInst().getApp().getString(z.log_msg_extra);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class CompareChatMessage implements Comparator<ChatMessage> {
        private CompareChatMessage() {
        }

        /* synthetic */ CompareChatMessage(MsglistModel msglistModel, CompareChatMessage compareChatMessage) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(ChatMessage chatMessage, ChatMessage chatMessage2) {
            if (chatMessage == null || chatMessage2 == null) {
                return 0;
            }
            if (chatMessage.getRecordId() > chatMessage2.getRecordId()) {
                return 1;
            }
            return chatMessage.getRecordId() < chatMessage2.getRecordId() ? -1 : 0;
        }
    }

    private void updatePortraintAndNetWork(List<ChatMessage> list) {
        int i;
        int i2;
        if (list != null) {
            if (this.mActivity.getListView() != null) {
                i2 = this.mActivity.getListView().getFirstVisiblePosition();
                i = this.mActivity.getListView().getLastVisiblePosition();
            } else {
                i = -1;
                i2 = -1;
            }
            List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
            int size = chatMessages.size();
            if (i2 >= 0 && i < size) {
                for (ChatMessage chatMessage : list) {
                    if (chatMessage.getMsgType() == 4) {
                        cv.aTe = com.baidu.tbadk.util.h.zR();
                    }
                    long userId = chatMessage.getUserId();
                    String portrait = chatMessage.getUserInfo().getPortrait();
                    for (int i3 = i2; i3 <= i; i3++) {
                        ChatMessage chatMessage2 = chatMessages.get(i3);
                        if (chatMessage2 != null) {
                            if (userId == chatMessage2.getUserId()) {
                                if (chatMessage2.getUserInfo() != null) {
                                    String portrait2 = chatMessage2.getUserInfo().getPortrait();
                                    if (portrait != null && !portrait.equals(portrait2)) {
                                        chatMessage2.getUserInfo().setPortrait(portrait);
                                    }
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public void setSendCallback(ae aeVar) {
        this.mSendCallback = aeVar;
        a.To().setSendCallback(aeVar);
    }

    public void setImageUploadUIProgressCallback(b<ChatMessage> bVar) {
        a.To().setImageUploadUIProgressCallback(bVar);
    }
}
