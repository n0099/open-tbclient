package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.gson.Gson;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.ag;
import com.baidu.tieba.im.db.pojo.GroupMsgPojo;
import com.baidu.tieba.im.message.ChatMessage;
import com.baidu.tieba.im.message.ChatResponsedMessage;
import com.baidu.tieba.im.message.LoadDraftMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.Message;
import com.baidu.tieba.im.message.RequestMarkReadedMessage;
import com.baidu.tieba.im.message.RequestRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseRemoveMembersMessage;
import com.baidu.tieba.im.message.ResponseUpdateGroupMessage;
import com.baidu.tieba.im.message.ResponsedMessage;
import com.baidu.tieba.im.message.SaveDraftMessage;
import com.slidingmenu.lib.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class MsglistModel extends com.baidu.adp.a.d {
    private static final String b = MsglistModel.class.getName();
    private String h;
    private MsgPageData i;
    private com.baidu.tieba.im.chat.aa j;
    private r n;
    private MsglistActivity o;
    private final int c = 1800;
    private final int d = 20;
    private GroupData e = null;
    private boolean f = true;
    private boolean g = true;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.adp.a.g f1806a = new k(this);
    private final HashMap<String, t> k = new HashMap<>();
    private final w m = new i(this);
    private final ac l = new ac();

    /* loaded from: classes.dex */
    public class PicMessageData implements Serializable {
        public String big_src;
        public String bsize;
        public String src;
        public String type;
    }

    public MsglistModel(MsglistActivity msglistActivity) {
        this.i = null;
        this.j = null;
        this.o = msglistActivity;
        this.i = new MsgPageData();
        this.j = new q(this, null);
        this.l.setLoadDataCallBack(this.f1806a);
        j();
    }

    private void j() {
        com.baidu.tieba.im.chat.a.b().a(this.j);
        this.n = new r(this, null);
        com.baidu.tieba.im.messageCenter.e.a().a(103112, this.n);
        com.baidu.tieba.im.messageCenter.e.a().a(103102, this.n);
        com.baidu.tieba.im.messageCenter.e.a().a(202003, this.n);
        com.baidu.tieba.im.messageCenter.e.a().a(-113, this.n);
    }

    private void k() {
        com.baidu.tieba.im.chat.a.b().c();
        com.baidu.tieba.im.messageCenter.e.a().a(this.n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatMessage a(long j) {
        if (this.i != null && this.i.getChatMessages() != null && this.i.getChatMessages().size() > 0) {
            for (ChatMessage chatMessage : this.i.getChatMessages()) {
                if (chatMessage.getRecordId() == j) {
                    return chatMessage;
                }
            }
        }
        return null;
    }

    public void a(GroupData groupData) {
        this.e = groupData;
    }

    public GroupData a() {
        return this.e;
    }

    public MsgPageData b() {
        return this.i;
    }

    public boolean c() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public void a(String str) {
        this.h = str;
    }

    @Override // com.baidu.adp.a.d
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.a.d
    public boolean cancelLoadData() {
        return false;
    }

    public void d() {
        synchronized (MsglistModel.class) {
            if (this.k != null) {
                for (Map.Entry<String, t> entry : this.k.entrySet()) {
                    t value = entry.getValue();
                    if (value != null) {
                        value.b();
                    }
                }
                this.k.clear();
            }
        }
        k();
    }

    public boolean e() {
        com.baidu.adp.lib.h.e.d("start loadFirst");
        if (this.e == null || this.e.getGroupId() == 0) {
            return false;
        }
        LoadHistoryMessage loadHistoryMessage = new LoadHistoryMessage();
        loadHistoryMessage.setGroupId(String.valueOf(this.e.getGroupId()));
        loadHistoryMessage.setLimit(20);
        loadHistoryMessage.setLastMsgId(null);
        loadHistoryMessage.setLastRid(null);
        com.baidu.tieba.im.messageCenter.e.a().a(loadHistoryMessage);
        return true;
    }

    public boolean f() {
        long j;
        long j2 = 0;
        com.baidu.adp.lib.h.e.d("start loadPrepage");
        if (this.e == null || this.e.getGroupId() == 0) {
            return false;
        }
        LoadHistoryMessage loadHistoryMessage = new LoadHistoryMessage();
        loadHistoryMessage.setGroupId(String.valueOf(this.e.getGroupId()));
        if (this.i == null || this.i.getChatMessages() == null || this.i.getChatMessages().size() <= 0 || this.i.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j = this.i.getChatMessages().get(0).getMsgId();
            j2 = this.i.getChatMessages().get(0).getRecordId();
        }
        loadHistoryMessage.setLimit(20);
        loadHistoryMessage.setLastMsgId(String.valueOf(j));
        loadHistoryMessage.setLastRid(String.valueOf(j2));
        com.baidu.tieba.im.messageCenter.e.a().a(loadHistoryMessage);
        return true;
    }

    public boolean g() {
        if (this.e == null || this.e.getGroupId() == 0) {
            return false;
        }
        LoadDraftMessage loadDraftMessage = new LoadDraftMessage();
        loadDraftMessage.setGroupId(String.valueOf(this.e.getGroupId()));
        com.baidu.tieba.im.messageCenter.e.a().a(loadDraftMessage);
        return true;
    }

    public boolean b(String str) {
        if (this.e == null || this.e.getGroupId() == 0) {
            return false;
        }
        if (this.h == null || !this.h.equals(str)) {
            SaveDraftMessage saveDraftMessage = new SaveDraftMessage();
            saveDraftMessage.setGroupId(String.valueOf(this.e.getGroupId()));
            saveDraftMessage.setDraft(str);
            com.baidu.tieba.im.messageCenter.e.a().a(saveDraftMessage);
            return true;
        }
        return false;
    }

    private ChatMessage a(short s, String str) {
        long j;
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMsgType(s);
        chatMessage.setContent(str);
        chatMessage.setGroupId(String.valueOf(this.e.getGroupId()));
        long a2 = com.baidu.tieba.im.chat.ac.a(h());
        chatMessage.setMsgId(a2);
        chatMessage.setRecordId(a2);
        chatMessage.setTime(System.currentTimeMillis() / 1000);
        UserData userData = new UserData();
        userData.setName(TiebaApplication.G());
        userData.setId(TiebaApplication.B());
        userData.setPortrait(com.baidu.tieba.im.i.b());
        chatMessage.setUserInfo(userData);
        try {
            j = Long.valueOf(TiebaApplication.B()).longValue();
        } catch (Exception e) {
            com.baidu.adp.lib.h.e.a("transform error" + e.getMessage());
            j = 0;
        }
        chatMessage.setUserId(j);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        chatMessage.setLocalData(msgLocalData);
        return chatMessage;
    }

    public long h() {
        List<ChatMessage> chatMessages = this.i.getChatMessages();
        if (chatMessages == null || chatMessages.size() <= 0) {
            return 0L;
        }
        return chatMessages.get(chatMessages.size() - 1).getMsgId();
    }

    public void c(String str) {
        com.baidu.adp.lib.h.e.d("SHANG sendTextMessage");
        ChatMessage a2 = a((short) 1, str);
        this.i.getChatMessages().add(a2);
        this.mLoadDataMode = 4;
        this.mLoadDataCallBack.a(this.i);
        b(a2);
    }

    public void a(String str, int i) {
        VoiceMsgData voiceMsgData = new VoiceMsgData();
        voiceMsgData.setDuring_time(i);
        voiceMsgData.setVoice_md5(str);
        voiceMsgData.setHas_read(1);
        ChatMessage a2 = a((short) 3, "[" + new Gson().toJson(voiceMsgData) + "]");
        a2.setCacheData(null);
        this.i.getChatMessages().add(a2);
        this.mLoadDataMode = 4;
        this.mLoadDataCallBack.a(this.i);
        LinkedList<GroupMsgPojo> linkedList = new LinkedList<>();
        GroupMsgPojo groupMsgPojo = new GroupMsgPojo(a2);
        groupMsgPojo.setRead_flag(0);
        linkedList.add(groupMsgPojo);
        com.baidu.tieba.im.db.d.a().a(a2.getGroupId(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new m(this, a2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChatMessage chatMessage) {
        VoiceMsgData e = com.baidu.tieba.im.e.d.e(chatMessage);
        if (e != null) {
            chatMessage.setLogTime(System.currentTimeMillis());
            this.l.a(e.getVoice_md5(), chatMessage.getRecordId());
        }
    }

    public void a(String str, Bitmap bitmap, x xVar) {
        ChatMessage a2 = a((short) 2, a(str, str, bitmap.getWidth(), bitmap.getHeight()));
        a2.setIsUploading(true);
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            a2.setWidth(width);
            a2.setHeight(height);
        }
        this.i.getChatMessages().add(a2);
        this.mLoadDataMode = 4;
        this.mLoadDataCallBack.a(this.i);
        LinkedList<GroupMsgPojo> linkedList = new LinkedList<>();
        GroupMsgPojo groupMsgPojo = new GroupMsgPojo(a2);
        groupMsgPojo.setRead_flag(0);
        linkedList.add(groupMsgPojo);
        com.baidu.tieba.im.db.d.a().a(a2.getGroupId(), linkedList, false, (com.baidu.tieba.im.a<Boolean>) new n(this, a2, str, xVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str, String str2, int i, int i2) {
        PicMessageData picMessageData = new PicMessageData();
        picMessageData.src = str2;
        picMessageData.big_src = str;
        picMessageData.type = "3";
        if (i > 0) {
            picMessageData.bsize = i + "," + i2;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(picMessageData);
        String json = new Gson().toJson(linkedList);
        com.baidu.adp.lib.h.e.d("pic msg content:" + json);
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChatMessage chatMessage, String str, x xVar) {
        String optString;
        if (chatMessage != null) {
            if (chatMessage.getContent() == null) {
                c(chatMessage);
            }
            if (str == null) {
                try {
                    optString = new JSONArray(chatMessage.getContent()).getJSONObject(0).optString("src");
                } catch (Exception e) {
                    e.printStackTrace();
                    c(chatMessage);
                    return;
                }
            } else {
                optString = str;
            }
            if (optString == null) {
                c(chatMessage);
                return;
            }
            chatMessage.setProgressValue(0);
            chatMessage.setIsUploading(true);
            if (optString.startsWith("http")) {
                com.baidu.tieba.im.chat.a.b().a(chatMessage);
                return;
            }
            t tVar = this.k.get(optString);
            if (tVar == null) {
                tVar = new t(optString, 0, 0, 0, 0);
                tVar.a(chatMessage);
                tVar.a(xVar);
                tVar.a(this.m);
                tVar.a(chatMessage.getGroupId());
                synchronized (MsglistModel.class) {
                    this.k.put(optString, tVar);
                }
            }
            chatMessage.setLogTime(System.currentTimeMillis());
            tVar.a();
        }
    }

    public void a(int i, x xVar) {
        ChatMessage a2 = a(i);
        if (a2 == null || a2.getLocalData() == null || a2.getLocalData().getStatus() == null) {
            com.baidu.adp.lib.h.e.b(b, "reSendMsg", "data error");
            return;
        }
        short shortValue = a2.getLocalData().getStatus().shortValue();
        if (shortValue != 2) {
            com.baidu.adp.lib.h.e.b(b, "reSendMsg", "status error:" + ((int) shortValue));
            return;
        }
        a2.setRecordId(a2.getMsgId());
        a2.getLocalData().setStatus((short) 1);
        a2.setTime(System.currentTimeMillis() / 1000);
        switch (a2.getMsgType()) {
            case 1:
                b(a2);
                break;
            case 2:
                a(a2, (String) null, xVar);
                break;
            case 3:
                a(a2);
                break;
        }
        this.mLoadDataMode = 6;
        this.mLoadDataCallBack.a(this.i);
        a(i, a2);
    }

    public ChatMessage a(int i) {
        if (this.i == null || this.i.getChatMessages() == null || i < 0 || i >= this.i.getChatMessages().size()) {
            return null;
        }
        return this.i.getChatMessages().get(i);
    }

    public void b(int i) {
        int size = this.i.getChatMessages().size();
        if (i >= 0 && i < size) {
            ChatMessage chatMessage = this.i.getChatMessages().get(i);
            if (this.e != null && chatMessage != null) {
                com.baidu.tieba.im.db.d.a().b(String.valueOf(this.e.getGroupId()), String.valueOf(chatMessage.getMsgId()), null);
            }
            this.i.getChatMessages().remove(i);
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    public void c(int i) {
        int size = this.i.getChatMessages().size();
        if (i >= 0 && i < size) {
            ChatMessage chatMessage = this.i.getChatMessages().get(i);
            ChatMessage chatMessage2 = i + (-1) >= 0 ? this.i.getChatMessages().get(i - 1) : null;
            if (this.e != null && chatMessage != null) {
                com.baidu.tieba.im.db.d.a().a(String.valueOf(this.e.getGroupId()), String.valueOf(chatMessage.getMsgId()), null);
            }
            this.i.getChatMessages().remove(i);
            if (i == size - 1) {
                com.baidu.tieba.im.db.ad.a().a(new o(this, chatMessage, chatMessage2));
            }
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    public void a(int i, ChatMessage chatMessage) {
        List<ChatMessage> chatMessages = this.i.getChatMessages();
        int size = chatMessages.size();
        if (i >= 0 && i < size) {
            chatMessages.remove(i);
            chatMessages.add(i, chatMessage);
            this.i.setIsNewAdd(false);
            this.i.setNewAddNum(0);
        }
    }

    private void b(ChatMessage chatMessage) {
        com.baidu.tieba.im.chat.a.b().a(chatMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Message message) {
        Message orginalMessage;
        String[] split;
        if (message instanceof ResponseRemoveMembersMessage) {
            ResponseRemoveMembersMessage responseRemoveMembersMessage = (ResponseRemoveMembersMessage) message;
            if (!responseRemoveMembersMessage.hasError() && (orginalMessage = responseRemoveMembersMessage.getOrginalMessage()) != null && (orginalMessage instanceof RequestRemoveMembersMessage)) {
                RequestRemoveMembersMessage requestRemoveMembersMessage = (RequestRemoveMembersMessage) orginalMessage;
                if (requestRemoveMembersMessage.getGroupId() == this.e.getGroupId()) {
                    String userIds = requestRemoveMembersMessage.getUserIds();
                    if (!TextUtils.isEmpty(userIds) && (split = userIds.split(",")) != null && split.length != 0) {
                        String id = TiebaApplication.F().getID();
                        if (!TextUtils.isEmpty(id)) {
                            for (String str : split) {
                                if (id.equals(str)) {
                                    this.mLoadDataMode = 9;
                                    this.mLoadDataCallBack.a(null);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Message message) {
        if (message instanceof ResponsedMessage) {
            ResponsedMessage responsedMessage = (ResponsedMessage) message;
            if (responsedMessage.hasError() && responsedMessage.getErrNo() == 110000) {
                com.baidu.adp.lib.h.e.d("-------unlogin");
                this.mLoadDataMode = 11;
                this.mLoadDataCallBack.a(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.i != null && this.i.getChatMessages() != null && this.i.getChatMessages().size() != 0) {
            this.i.getChatMessages().clear();
            this.mLoadDataMode = 12;
            this.mLoadDataCallBack.a(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        if (!(message instanceof ResponseUpdateGroupMessage)) {
            com.baidu.adp.lib.h.e.d("transform error");
            return;
        }
        ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) message;
        if (responseUpdateGroupMessage.hasError()) {
            com.baidu.adp.lib.h.e.a("has error");
        } else if (responseUpdateGroupMessage.getUpdateGroupInfo() != null) {
            this.mLoadDataMode = 10;
            this.mLoadDataCallBack.a(responseUpdateGroupMessage.getUpdateGroupInfo().getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(List<ChatMessage> list, List<ChatMessage> list2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<ChatMessage> list, List<ChatMessage> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size2 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = size - 1; i >= 0 && i >= 0; i--) {
                    ChatMessage chatMessage = list.get(i);
                    if (chatMessage != null && chatMessage.getUserInfo() != null && !TextUtils.isEmpty(chatMessage.getUserInfo().getId()) && chatMessage.getUserInfo().getId().equals(TiebaApplication.B()) && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() != 3) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                ChatMessage chatMessage2 = list2.get(i2);
                                if (chatMessage2 != null && chatMessage2.getUserInfo() != null && !TextUtils.isEmpty(chatMessage2.getUserInfo().getId()) && chatMessage2.getUserInfo().getId().equals(TiebaApplication.B()) && chatMessage2.getRecordId() == chatMessage.getRecordId()) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ChatMessage> list) {
        if (list != null && list.size() != 0) {
            com.baidu.adp.lib.h.e.d("*****start updateMsgStatusTimeOut");
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 1) {
                    if ((System.currentTimeMillis() / 1000) - chatMessage.getTime() > 1800) {
                        chatMessage.getLocalData().setStatus((short) 2);
                        com.baidu.adp.lib.h.e.d("*****create time out");
                    } else if (com.baidu.tieba.im.messageCenter.e.a().c(chatMessage)) {
                        com.baidu.adp.lib.h.e.d("***** find in queues");
                    } else {
                        chatMessage.getLocalData().setStatus((short) 2);
                        com.baidu.adp.lib.h.e.d("*****no find in queues");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChatResponsedMessage chatResponsedMessage) {
        if (chatResponsedMessage == null) {
            com.baidu.adp.lib.h.e.a("SHANG sendMsgSuc msg == null");
        } else if (chatResponsedMessage.getGroupId() != null && chatResponsedMessage.getGroupId().equals(String.valueOf(this.e.getGroupId()))) {
            com.baidu.adp.lib.h.e.d("SHANG sendMsgSuc msgId " + chatResponsedMessage.getMsgId() + " rid " + chatResponsedMessage.getRecordId());
            List<ChatMessage> chatMessages = this.i.getChatMessages();
            long recordId = chatResponsedMessage.getRecordId();
            long msgId = chatResponsedMessage.getMsgId();
            this.i.setNewAddNum(0);
            this.i.setIsNewAdd(false);
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
            this.mLoadDataCallBack.a(this.i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ChatMessage chatMessage) {
        if (chatMessage == null) {
            com.baidu.adp.lib.h.e.a("SHANG sendMsgFail chatmessage == null");
        } else if (chatMessage.getGroupId() != null && chatMessage.getGroupId().equals(String.valueOf(this.e.getGroupId()))) {
            chatMessage.setIsUploading(false);
            if (chatMessage.getLocalData() == null) {
                MsgLocalData msgLocalData = new MsgLocalData();
                msgLocalData.setStatus((short) 1);
                msgLocalData.setErrno(0L);
                msgLocalData.setRetry(0L);
                msgLocalData.setUpload_offset(null);
                chatMessage.setLocalData(msgLocalData);
            }
            com.baidu.adp.lib.h.e.d("SHANG sendMsgFail msgId " + chatMessage.getMsgId() + "recordId " + chatMessage.getRecordId());
            chatMessage.getLocalData().setStatus((short) 2);
            List<ChatMessage> chatMessages = this.i.getChatMessages();
            if (chatMessages != null && chatMessages.size() != 0) {
                long recordId = chatMessage.getRecordId();
                int size = chatMessages.size() - 1;
                while (size >= 0 && chatMessages.get(size).getMsgId() != recordId) {
                    size--;
                }
                if (size >= 0) {
                    chatMessages.remove(size);
                    chatMessages.add(size, chatMessage);
                    this.i.setNewAddNum(0);
                    this.i.setIsNewAdd(false);
                    this.mLoadDataMode = 5;
                    this.mLoadDataCallBack.a(this.i);
                }
            }
        }
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        ag.a().a(String.valueOf(this.e.getGroupId()), aVar);
        RequestMarkReadedMessage requestMarkReadedMessage = new RequestMarkReadedMessage();
        requestMarkReadedMessage.setGroupId(String.valueOf(this.e.getGroupId()));
        com.baidu.tieba.im.messageCenter.e.a().a(requestMarkReadedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return "";
        }
        int msgType = chatMessage.getMsgType();
        String string = TiebaApplication.h().getString(R.string.websocket_type);
        switch (msgType) {
            case 1:
                return string + TiebaApplication.h().getString(R.string.log_msg_text);
            case 2:
                return string + TiebaApplication.h().getString(R.string.log_msg_pic);
            case 3:
                return string + TiebaApplication.h().getString(R.string.log_msg_voice);
            default:
                return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(List<ChatMessage> list) {
        int firstVisiblePosition = this.o.c().getFirstVisiblePosition();
        int lastVisiblePosition = this.o.c().getLastVisiblePosition();
        List<ChatMessage> chatMessages = this.i.getChatMessages();
        int size = chatMessages.size();
        if (firstVisiblePosition >= 0 && lastVisiblePosition < size) {
            for (ChatMessage chatMessage : list) {
                long userId = chatMessage.getUserId();
                String portrait = chatMessage.getUserInfo().getPortrait();
                for (int i = firstVisiblePosition; i <= lastVisiblePosition; i++) {
                    ChatMessage chatMessage2 = chatMessages.get(i);
                    if (userId == chatMessage2.getUserId()) {
                        String portrait2 = chatMessage2.getUserInfo().getPortrait();
                        if (portrait != null && !portrait.equals(portrait2)) {
                            chatMessage2.getUserInfo().setPortrait(portrait);
                        }
                    }
                }
            }
        }
    }
}
