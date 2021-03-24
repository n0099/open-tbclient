package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.android.imsdk.upload.action.IMTrackDatabase;
import com.baidu.searchbox.account.data.UserAccountActionItem;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
import com.baidu.tieba.im.message.ResponseUnLoginMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import d.b.b.a.e;
import d.b.h0.b0.a;
import d.b.h0.r.s.a;
import d.b.h0.s.c.t;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import d.b.h0.z0.n;
import d.b.h0.z0.o;
import d.b.i0.d1.f.h;
import d.b.i0.d1.h.l;
import d.b.i0.d1.h.m;
import d.b.i0.d1.s.d;
import d.b.i0.d1.w.b;
import d.b.i0.d1.w.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public abstract class MsglistModel extends BdBaseModel<Object> {
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
    public static final int TYPE_DELETE_FAIL_MSG = 1;
    public static final int TYPE_DELETE_SUC_MSG = 2;
    public final int DURATION_TIME_OUT;
    public int customGroupType;
    public boolean isAcceptNotify;
    public MsglistActivity<?> mActivity;
    public a mAntiDialog;
    public final CustomMessageListener mCustomListenerInMessageCenter;
    public MsgPageData mDatas;
    public String mDraft;
    public long mId;
    public AntiHelper.k mInjectListener;
    public CustomMessageListener mListenerUnLogin;
    public d mSendCallback;

    /* loaded from: classes4.dex */
    public static class CacheInfo {
        public int customGroupType;
        public String id;
    }

    /* loaded from: classes4.dex */
    public class CompareChatMessage implements Comparator<ChatMessage> {
        public CompareChatMessage() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        public int compare(ChatMessage chatMessage, ChatMessage chatMessage2) {
            if (chatMessage != null && chatMessage2 != null) {
                if (chatMessage.getRecordId() > chatMessage2.getRecordId()) {
                    return 1;
                }
                if (chatMessage.getRecordId() < chatMessage2.getRecordId()) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public MsglistModel() {
        this.DURATION_TIME_OUT = 1800;
        this.isAcceptNotify = true;
        this.mDatas = null;
        this.mInjectListener = new AntiHelper.k() { // from class: com.baidu.tieba.im.model.MsglistModel.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onNavigationButtonClick(a aVar) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onPositiveButtonClick(a aVar) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
            }
        };
        this.mCustomListenerInMessageCenter = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.MsglistModel.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001110) {
                    MsglistModel.this.refreshAfterClearHistory();
                } else if (customResponsedMessage.getCmd() == 501126 && (customResponsedMessage instanceof ResponsedMessage)) {
                    MsglistModel.this.mDatas.getChatMessages().add((ChatMessage) customResponsedMessage.getOrginalMessage());
                    if (MsglistModel.this.mLoadDataCallBack != null) {
                        MsglistModel.this.mLoadDataCallBack.c(MsglistModel.this.mDatas);
                    }
                }
            }
        };
        this.mListenerUnLogin = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.MsglistModel.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponseUnLoginMessage) {
                    MsglistModel.this.mLoadDataMode = 11;
                    if (MsglistModel.this.mLoadDataCallBack != null) {
                        MsglistModel.this.mLoadDataCallBack.c(null);
                    }
                }
            }
        };
    }

    private String buildBigEmotionContent(t tVar) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pid", tVar.c());
            jSONObject.put("packet_name", tVar.d());
            jSONObject.put("face_name", tVar.b());
            jSONObject.put("size_width", tVar.g());
            jSONObject.put("size_height", tVar.a());
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private String createMsgLog(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return "";
        }
        int msgType = chatMessage.getMsgType();
        String string = TbadkCoreApplication.getInst().getApp().getString(R.string.websocket_type);
        if (msgType == 1) {
            return string + TbadkCoreApplication.getInst().getApp().getString(R.string.log_msg_text);
        } else if (msgType == 2) {
            return string + TbadkCoreApplication.getInst().getApp().getString(R.string.editor_image);
        } else if (msgType == 3) {
            return string + TbadkCoreApplication.getInst().getApp().getString(R.string.msglist_voice);
        } else if (msgType != 9) {
            return "";
        } else {
            return string + TbadkCoreApplication.getInst().getApp().getString(R.string.log_msg_extra);
        }
    }

    private void delRepeatMsg(List<ChatMessage> list, List<ChatMessage> list2) {
        if (list == null || list2 == null) {
            return;
        }
        int size = list.size();
        int size2 = list2.size();
        if (size2 == 0) {
            return;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendPic(ChatMessage chatMessage, String str) {
        if (chatMessage == null) {
            return;
        }
        if (chatMessage.getContent() == null) {
            sendMsgFail(chatMessage);
        }
        if (str == null) {
            try {
                str = new JSONArray(chatMessage.getContent()).getJSONObject(0).optString(UserAccountActionItem.KEY_SRC);
            } catch (Exception e2) {
                e2.printStackTrace();
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
            d.b.i0.d1.s.a.j().t(chatMessage);
        } else {
            d.b.i0.d1.s.a.j().y(chatMessage, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doSendVoice(ChatMessage chatMessage) {
        VoiceMsgData n = c.n(chatMessage);
        if (n == null) {
            return;
        }
        chatMessage.setLogTime(System.currentTimeMillis());
        d.b.i0.d1.s.a.m(chatMessage);
        d.b.i0.d1.s.a.j().z(n, chatMessage);
    }

    private ChatMessage findMaxMsgIdMessage() {
        MsgPageData msgPageData = this.mDatas;
        ChatMessage chatMessage = null;
        if (msgPageData != null && msgPageData.getChatMessages() != null && this.mDatas.getChatMessages().size() != 0) {
            for (ChatMessage chatMessage2 : this.mDatas.getChatMessages()) {
                if (chatMessage == null || chatMessage2.getMsgId() > chatMessage.getMsgId()) {
                    chatMessage = chatMessage2;
                }
            }
        }
        return chatMessage;
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
        int i = size - 1;
        int i2 = size2 - 1;
        int i3 = 0;
        while (i >= 0 && i2 >= 0) {
            long recordId = list.get(i).getRecordId();
            ChatMessage chatMessage = list2.get(i2);
            long recordId2 = chatMessage.getRecordId();
            if (recordId > recordId2) {
                i--;
            } else if (recordId < recordId2) {
                list.add(i + 1, chatMessage);
                i2--;
                i3++;
            } else {
                i--;
                i2--;
            }
        }
        if (i2 >= 0) {
            while (i2 >= 0) {
                list.add(0, list2.get(i2));
                i3++;
                i2--;
            }
        }
        return i3;
    }

    private void processDeleteMsg(int i, int i2) {
        CacheInfo cacheInfo;
        int size = this.mDatas.getChatMessages().size();
        if (i2 >= 0 && i2 < size) {
            ChatMessage chatMessage = this.mDatas.getChatMessages().get(i2);
            if (i == 1) {
                deleteMsg(chatMessage);
            } else if (i == 2) {
                markDeleteMsg(chatMessage);
            }
            int i3 = i2 - 1;
            ChatMessage chatMessage2 = i3 >= 0 ? this.mDatas.getChatMessages().get(i3) : null;
            markDeleteMsg(chatMessage);
            this.mDatas.getChatMessages().remove(i2);
            if (i2 == size - 1 && (cacheInfo = getCacheInfo()) != null) {
                MemoryModifyLastMsgMessage.a aVar = new MemoryModifyLastMsgMessage.a();
                aVar.f18050b = cacheInfo.customGroupType;
                aVar.f18049a = cacheInfo.id;
                aVar.f18051c = chatMessage2;
                aVar.f18052d = 2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryModifyLastMsgMessage(aVar));
            }
        }
        this.mLoadDataMode = 7;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(null);
        }
    }

    private void registerListener() {
        registerListener(2001153, this.mListenerUnLogin);
        registerListener(2001110, this.mCustomListenerInMessageCenter);
        registerListener(501126, this.mCustomListenerInMessageCenter);
    }

    private void sendMsgSuc(ResponseCommitMessage responseCommitMessage) {
        if (responseCommitMessage == null) {
            return;
        }
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        long recordId = responseCommitMessage.getRecordId();
        long msgId = responseCommitMessage.getMsgId();
        this.mDatas.setNewAddNum(0);
        this.mDatas.setIsNewAdd(false);
        int size = chatMessages.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            } else if (recordId == chatMessages.get(size).getRecordId()) {
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
            } else {
                size--;
            }
        }
        this.mLoadDataMode = 5;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(this.mDatas);
        }
        d dVar = this.mSendCallback;
        if (dVar != null) {
            dVar.a(0);
        }
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mListenerUnLogin);
        MessageManager.getInstance().unRegisterListener(this.mCustomListenerInMessageCenter);
    }

    private void updateMsgStatusTimeOut(List<ChatMessage> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (ChatMessage chatMessage : list) {
            if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 1) {
                chatMessage.setCustomGroupType(this.customGroupType);
                if ((System.currentTimeMillis() / 1000) - chatMessage.getTime() > 1800) {
                    chatMessage.getLocalData().setStatus((short) 2);
                } else if (!(MessageManager.getInstance().getSocketClient() != null ? MessageManager.getInstance().getSocketClient().o(chatMessage) : false) && (chatMessage.getMsgType() != 2 || !d.b.i0.d1.s.a.j().g(chatMessage))) {
                    if (chatMessage.getMsgType() != 3 || !d.b.i0.d1.s.a.j().h(chatMessage)) {
                        chatMessage.getLocalData().setStatus((short) 2);
                    }
                }
            }
        }
    }

    private void updatePortraintAndNetWork(List<ChatMessage> list) {
        MsglistActivity<?> msglistActivity;
        int i;
        if (list == null || (msglistActivity = this.mActivity) == null) {
            return;
        }
        int i2 = -1;
        if (msglistActivity.getListView() != null) {
            i2 = this.mActivity.getListView().getFirstVisiblePosition();
            i = this.mActivity.getListView().getLastVisiblePosition();
        } else {
            i = -1;
        }
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        int size = chatMessages.size();
        if (i2 < 0 || i >= size) {
            return;
        }
        for (ChatMessage chatMessage : list) {
            if (chatMessage.getMsgType() == 4) {
                h.f53683a = o.e();
            }
            long userId = chatMessage.getUserId();
            String portrait = chatMessage.getUserInfo().getPortrait();
            for (int i3 = i2; i3 <= i; i3++) {
                ChatMessage chatMessage2 = chatMessages.get(i3);
                if (chatMessage2 == null) {
                    return;
                }
                if (userId == chatMessage2.getUserId()) {
                    if (chatMessage2.getUserInfo() == null) {
                        return;
                    }
                    String portrait2 = chatMessage2.getUserInfo().getPortrait();
                    if (portrait != null && !portrait.equals(portrait2)) {
                        chatMessage2.getUserInfo().setPortrait(portrait);
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public ChatMessage createMessage(short s, String str) {
        long j;
        ChatMessage genChatMessage = genChatMessage();
        if (genChatMessage == null) {
            return null;
        }
        genChatMessage.setCustomGroupType(this.customGroupType);
        genChatMessage.setMsgType(s);
        genChatMessage.setContent(str);
        long b2 = b.b(getLastMid());
        genChatMessage.setMsgId(b2);
        genChatMessage.setRecordId(b2);
        genChatMessage.setTime(System.currentTimeMillis() / 1000);
        UserData userData = new UserData();
        userData.setUserName(TbadkCoreApplication.getCurrentAccountName());
        userData.setUserId(TbadkCoreApplication.getCurrentAccount());
        userData.setName_show(TbadkCoreApplication.getCurrentAccountNameShow());
        userData.setPortrait(TbadkCoreApplication.getCurrentPortrait());
        genChatMessage.setUserInfo(userData);
        try {
            j = d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
        } catch (Exception unused) {
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

    public void deleteMsg(int i) {
        processDeleteMsg(1, i);
    }

    public abstract void deleteMsg(ChatMessage chatMessage);

    public void doSendText(ChatMessage chatMessage) {
        d.b.i0.d1.s.a.j().t(chatMessage);
    }

    public abstract ChatMessage genChatMessage();

    public abstract CacheInfo getCacheInfo();

    public MsgPageData getData() {
        return this.mDatas;
    }

    public String getDraft() {
        return this.mDraft;
    }

    public boolean getIsAcceptNotify() {
        return this.isAcceptNotify;
    }

    public long getLastMid() {
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        if (chatMessages != null && chatMessages.size() > 0) {
            return chatMessages.get(chatMessages.size() - 1).getMsgId();
        }
        return getMaxMid();
    }

    public abstract long getMaxMid();

    public ChatMessage getMsg(int i) {
        MsgPageData msgPageData = this.mDatas;
        if (msgPageData == null || msgPageData.getChatMessages() == null || i < 0 || i >= this.mDatas.getChatMessages().size()) {
            return null;
        }
        return this.mDatas.getChatMessages().get(i);
    }

    public abstract boolean loadDraft();

    public abstract boolean loadFirst(d.b.i0.d1.f.c cVar);

    public abstract boolean loadPrepage();

    public void markDeleteMsg(int i) {
        processDeleteMsg(2, i);
    }

    public abstract void markDeleteMsg(ChatMessage chatMessage);

    public boolean onAfterLoadFromDb() {
        return false;
    }

    public boolean onAfterProcessMsgFromServer() {
        return false;
    }

    public void onDestroy() {
        this.mAntiDialog = null;
        d.b.i0.d1.s.a.j().v(null);
        unRegisterListener();
    }

    public void processDraft(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof LoadDraftResponsedMessage) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = (LoadDraftResponsedMessage) customResponsedMessage;
            if (loadDraftResponsedMessage.getData() == null) {
                return;
            }
            String str = loadDraftResponsedMessage.getData().f18038a;
            this.mLoadDataMode = 8;
            e eVar = this.mLoadDataCallBack;
            if (eVar != null) {
                eVar.c(str);
            }
        }
    }

    public boolean processHistory(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() == null) {
                return true;
            }
            long j = this.mId;
            if (j == 0 || j == d.b.b.e.m.b.f(loadHistoryResponsedMessage.getData().f18043a, 0L)) {
                List<ChatMessage> list = loadHistoryResponsedMessage.getData().f18044b;
                boolean z = loadHistoryResponsedMessage.getData().f18045c;
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
                        e eVar = this.mLoadDataCallBack;
                        if (eVar != null) {
                            eVar.c(null);
                        }
                    }
                    return true;
                }
                if (this.mDatas.getIsNewAdd()) {
                    this.mLoadDataMode = 2;
                    e eVar2 = this.mLoadDataCallBack;
                    if (eVar2 != null) {
                        eVar2.c(null);
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void processMsgACK(ResponseCommitMessage responseCommitMessage) {
        if (responseCommitMessage == null || responseCommitMessage.getOrginalMessage() == null || !(responseCommitMessage.getOrginalMessage() instanceof ChatMessage)) {
            return;
        }
        ChatMessage chatMessage = (ChatMessage) responseCommitMessage.getOrginalMessage();
        if (responseCommitMessage.getError() != 0) {
            d.b.h0.c0.a.c(responseCommitMessage.getCmd(), 0, 0, 0, 13, MessageManager.getInstance().getSocketClient().v() ? 1 : 2);
            long recordId = chatMessage.getRecordId();
            String createMsgLog = createMsgLog(chatMessage);
            long clientLogID = chatMessage.getClientLogID();
            int cmd = responseCommitMessage.getCmd();
            int error = responseCommitMessage.getError();
            String errorString = responseCommitMessage.getErrorString();
            d.b.h0.r.z.a.a("im", clientLogID, cmd, IMTrackDatabase.AckEnum.TABLE_NAME, error, errorString, "comment", createMsgLog + "rid" + recordId);
            if (responseCommitMessage.getError() > 0) {
                if (AntiHelper.m(responseCommitMessage.getError(), responseCommitMessage.getErrorString())) {
                    a aVar = this.mAntiDialog;
                    if (aVar != null) {
                        if (!aVar.isShowing()) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                            this.mAntiDialog.show();
                        }
                    } else {
                        a t = AntiHelper.t(this.mActivity.getActivity(), responseCommitMessage.getBlockPopInfoData(), this.mInjectListener);
                        this.mAntiDialog = t;
                        if (t != null) {
                            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
                        }
                    }
                } else if (responseCommitMessage.getError() != 3160008 && responseCommitMessage.getError() != 3100001) {
                    this.mActivity.showToast(responseCommitMessage.getErrorString());
                    if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
                        responseCommitMessage.setRecordId(chatMessage.getRecordId());
                        d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), responseCommitMessage.getCmd(), IMTrackDatabase.AckEnum.TABLE_NAME, responseCommitMessage.getError(), responseCommitMessage.getErrorString(), "comment", "orgRId != sRId");
                    }
                }
            }
            sendMsgFail(chatMessage);
            return;
        }
        if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
            responseCommitMessage.setRecordId(chatMessage.getRecordId());
            d.b.h0.r.z.a.a("im", chatMessage.getClientLogID(), responseCommitMessage.getCmd(), IMTrackDatabase.AckEnum.TABLE_NAME, responseCommitMessage.getError(), responseCommitMessage.getErrorString(), "comment", "orgRId != sRId");
        }
        sendMsgSuc(responseCommitMessage);
    }

    public List<ChatMessage> processMsgFromServerCommon(List<ChatMessage> list) {
        ChatMessage chatMessage;
        String valueOf;
        updatePortraintAndNetWork(list);
        delRepeatMsg(this.mDatas.getChatMessages(), list);
        Collections.sort(list, new CompareChatMessage());
        boolean z = (list == null || list.isEmpty() || (chatMessage = list.get(list.size() - 1)) == null || (valueOf = String.valueOf(chatMessage.getUserId())) == null || !valueOf.equals(TbadkCoreApplication.getCurrentAccount())) ? false : true;
        int mergeList = mergeList(this.mDatas.getChatMessages(), list);
        boolean onAfterProcessMsgFromServer = onAfterProcessMsgFromServer();
        if (mergeList <= 0 && !onAfterProcessMsgFromServer) {
            this.mDatas.setIsNewAdd(false);
            this.mDatas.setNewAddNum(0);
        } else {
            this.mDatas.setIsNewAdd(true);
            this.mDatas.setNewAddNum(mergeList);
            if (!z) {
                this.mLoadDataMode = 3;
            }
            e eVar = this.mLoadDataCallBack;
            if (eVar != null) {
                eVar.c(this.mDatas);
            }
        }
        return list;
    }

    public void reSendMsg(int i) {
        ChatMessage msg = getMsg(i);
        if (msg == null || msg.getLocalData() == null || msg.getLocalData().getStatus() == null || msg.getLocalData().getStatus().shortValue() != 2) {
            return;
        }
        msg.setRecordId(msg.getMsgId());
        msg.getLocalData().setStatus((short) 1);
        msg.setTime(System.currentTimeMillis() / 1000);
        msg.setCustomGroupType(this.customGroupType);
        int msgType = msg.getMsgType();
        if (msgType == 1) {
            doSendText(msg);
        } else if (msgType == 2) {
            doSendPic(msg, null);
        } else if (msgType == 3) {
            doSendVoice(msg);
        } else if (msgType == 4) {
            doSendText(msg);
        } else if (msgType == 9) {
            doSendText(msg);
        }
        this.mLoadDataMode = 6;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(this.mDatas);
        }
        updateMsgResend(i, msg);
    }

    public void refreshAfterClearHistory() {
        MsgPageData msgPageData = this.mDatas;
        if (msgPageData == null || msgPageData.getChatMessages() == null || this.mDatas.getChatMessages().size() == 0) {
            return;
        }
        ChatMessage findMaxMsgIdMessage = findMaxMsgIdMessage();
        if (findMaxMsgIdMessage != null && c.p(findMaxMsgIdMessage)) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016020, findMaxMsgIdMessage));
        }
        this.mDatas.getChatMessages().clear();
        this.mLoadDataMode = 12;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(null);
        }
    }

    public boolean saveDraft(String str) {
        String str2 = this.mDraft;
        if (str2 == null || !str2.equals(str)) {
            return saveDraftContent(str);
        }
        return false;
    }

    public abstract boolean saveDraftContent(String str);

    public void sendBigEmotionMessage(t tVar) {
        ChatMessage createMessage;
        String buildBigEmotionContent = buildBigEmotionContent(tVar);
        if (buildBigEmotionContent == null || (createMessage = createMessage((short) 4, buildBigEmotionContent)) == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void sendExtraMessage(String str) {
        ChatMessage createMessage = createMessage((short) 9, str);
        if (createMessage == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void sendMsgFail(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return;
        }
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
        if (chatMessages == null || chatMessages.size() == 0) {
            return;
        }
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
            e eVar = this.mLoadDataCallBack;
            if (eVar != null) {
                eVar.c(this.mDatas);
            }
        }
    }

    public void sendMsgVoice(String str, int i) {
        VoiceMsgData voiceMsgData = new VoiceMsgData();
        voiceMsgData.setDuring_time(i);
        voiceMsgData.setVoice_md5(str);
        voiceMsgData.setHas_read(0);
        String jsonStrWithObject = OrmObject.jsonStrWithObject(voiceMsgData);
        ChatMessage createMessage = createMessage((short) 3, "[" + jsonStrWithObject + "]");
        if (createMessage == null) {
            return;
        }
        createMessage.setCacheData(null);
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(this.mDatas);
        }
        if (createMessage instanceof CommonGroupChatMessage) {
            final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) createMessage;
            final LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.2
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d.b.h0.z0.f0
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.b.i0.d1.h.c.h().l(commonGroupChatMessage.getGroupId(), linkedList, false));
                }
            }, new n<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.3
                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.b.h0.z0.n
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
            h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.4
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d.b.h0.z0.f0
                public Boolean doInBackground() {
                    return Boolean.valueOf(m.t().m(c.m(personalChatMessage), linkedList2, false));
                }
            }, new n<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.5
                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.b.h0.z0.n
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
            h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.6
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d.b.h0.z0.f0
                public Boolean doInBackground() {
                    return Boolean.valueOf(l.t().m(c.m(officialChatMessage), linkedList3, false));
                }
            }, new n<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.7
                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.b.h0.z0.n
                public void onReturnDataInUI(Boolean bool) {
                    MsglistModel.this.doSendVoice(officialChatMessage);
                }
            });
        }
    }

    public void sendPicMessage(final String str, Bitmap bitmap) {
        ChatMessage createMessage;
        if (bitmap == null || (createMessage = createMessage((short) 2, d.b.i0.d1.s.a.f(str, str, bitmap.getWidth(), bitmap.getHeight()))) == null) {
            return;
        }
        createMessage.setIsUploading(true);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        createMessage.setWidth(width);
        createMessage.setHeight(height);
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(this.mDatas);
        }
        if (createMessage instanceof CommonGroupChatMessage) {
            final CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) createMessage;
            final LinkedList linkedList = new LinkedList();
            CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
            commonMsgPojo.setRead_flag(0);
            linkedList.add(commonMsgPojo);
            h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.8
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d.b.h0.z0.f0
                public Boolean doInBackground() {
                    return Boolean.valueOf(d.b.i0.d1.h.c.h().l(commonGroupChatMessage.getGroupId(), linkedList, false));
                }
            }, new n<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.9
                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.b.h0.z0.n
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
            h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.10
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d.b.h0.z0.f0
                public Boolean doInBackground() {
                    return Boolean.valueOf(m.t().m(c.m(personalChatMessage), linkedList2, false));
                }
            }, new n<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.11
                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.b.h0.z0.n
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
            h0.c(new f0<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.12
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // d.b.h0.z0.f0
                public Boolean doInBackground() {
                    return Boolean.valueOf(l.t().m(c.m(officialChatMessage), linkedList3, false));
                }
            }, new n<Boolean>() { // from class: com.baidu.tieba.im.model.MsglistModel.13
                /* JADX DEBUG: Method merged with bridge method */
                @Override // d.b.h0.z0.n
                public void onReturnDataInUI(Boolean bool) {
                    MsglistModel.this.doSendPic(officialChatMessage, str);
                }
            });
        }
    }

    public void sendReplyCardMessage(String str) {
        ChatMessage createMessage = createMessage((short) 23, str);
        if (createMessage == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void sendTextMessage(String str) {
        ChatMessage createMessage = createMessage((short) 1, str);
        if (createMessage == null) {
            return;
        }
        this.mDatas.getChatMessages().add(createMessage);
        this.mLoadDataMode = 4;
        e eVar = this.mLoadDataCallBack;
        if (eVar != null) {
            eVar.c(this.mDatas);
        }
        doSendText(createMessage);
    }

    public void setDraft(String str) {
        this.mDraft = str;
    }

    public void setImageUploadUIProgressCallback(a.b<ChatMessage> bVar) {
        d.b.i0.d1.s.a.j().u(bVar);
    }

    public void setIsAcceptNotify(boolean z) {
        this.isAcceptNotify = z;
    }

    public void setSendCallback(d dVar) {
        this.mSendCallback = dVar;
        d.b.i0.d1.s.a.j().v(dVar);
    }

    public void updateMsgResend(int i, ChatMessage chatMessage) {
        List<ChatMessage> chatMessages = this.mDatas.getChatMessages();
        int size = chatMessages.size();
        if (i < 0 || i >= size) {
            return;
        }
        chatMessages.remove(i);
        chatMessages.add(i, chatMessage);
        this.mDatas.setIsNewAdd(false);
        this.mDatas.setNewAddNum(0);
    }

    public MsglistModel(MsglistActivity<Object> msglistActivity) {
        super(msglistActivity.getPageContext());
        this.DURATION_TIME_OUT = 1800;
        this.isAcceptNotify = true;
        this.mDatas = null;
        this.mInjectListener = new AntiHelper.k() { // from class: com.baidu.tieba.im.model.MsglistModel.1
            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onNavigationButtonClick(d.b.h0.r.s.a aVar) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
            }

            @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
            public void onPositiveButtonClick(d.b.h0.r.s.a aVar) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_CHAT));
            }
        };
        this.mCustomListenerInMessageCenter = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.MsglistModel.14
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage.getCmd() == 2001110) {
                    MsglistModel.this.refreshAfterClearHistory();
                } else if (customResponsedMessage.getCmd() == 501126 && (customResponsedMessage instanceof ResponsedMessage)) {
                    MsglistModel.this.mDatas.getChatMessages().add((ChatMessage) customResponsedMessage.getOrginalMessage());
                    if (MsglistModel.this.mLoadDataCallBack != null) {
                        MsglistModel.this.mLoadDataCallBack.c(MsglistModel.this.mDatas);
                    }
                }
            }
        };
        this.mListenerUnLogin = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.model.MsglistModel.15
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage instanceof ResponseUnLoginMessage) {
                    MsglistModel.this.mLoadDataMode = 11;
                    if (MsglistModel.this.mLoadDataCallBack != null) {
                        MsglistModel.this.mLoadDataCallBack.c(null);
                    }
                }
            }
        };
        this.mActivity = msglistActivity;
        this.mDatas = new MsgPageData();
        registerListener();
    }
}
