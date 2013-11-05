package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.aa;
import com.baidu.tieba.im.data.GroupData;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.VoiceMsgData;
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
import com.google.gson.Gson;
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
    private com.baidu.tieba.im.chat.y j;
    private q n;
    private MsglistActivity o;
    private final int c = 1800;
    private final int d = 20;
    private GroupData e = null;
    private boolean f = true;
    private boolean g = true;

    /* renamed from: a  reason: collision with root package name */
    com.baidu.adp.a.g f1656a = new k(this);
    private final HashMap<String, r> k = new HashMap<>();
    private final u m = new i(this);
    private final y l = new y();

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
        this.j = new p(this, null);
        this.l.setLoadDataCallBack(this.f1656a);
        k();
    }

    private void k() {
        com.baidu.tieba.im.chat.a.b().a(this.j);
        this.n = new q(this, null);
        com.baidu.tieba.im.messageCenter.f.a().a(103112, this.n);
        com.baidu.tieba.im.messageCenter.f.a().a(103102, this.n);
        com.baidu.tieba.im.messageCenter.f.a().a(202003, this.n);
    }

    private void l() {
        com.baidu.tieba.im.chat.a.b().c();
        com.baidu.tieba.im.messageCenter.f.a().a(this.n);
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
        return this.f;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean d() {
        return this.g;
    }

    public void b(boolean z) {
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

    public void e() {
        synchronized (MsglistModel.class) {
            if (this.k != null) {
                for (Map.Entry<String, r> entry : this.k.entrySet()) {
                    r value = entry.getValue();
                    if (value != null) {
                        value.b();
                    }
                }
                this.k.clear();
            }
        }
        l();
    }

    public boolean f() {
        com.baidu.adp.lib.h.d.d("start loadFirst");
        if (this.e == null || this.e.getGroupId() == 0) {
            return false;
        }
        LoadHistoryMessage loadHistoryMessage = new LoadHistoryMessage();
        loadHistoryMessage.setGroupId(String.valueOf(this.e.getGroupId()));
        loadHistoryMessage.setLimit(20);
        loadHistoryMessage.setLastMsgId(null);
        com.baidu.tieba.im.messageCenter.f.a().a(loadHistoryMessage);
        return true;
    }

    public boolean g() {
        com.baidu.adp.lib.h.d.d("start loadPrepage");
        if (this.e == null || this.e.getGroupId() == 0) {
            return false;
        }
        LoadHistoryMessage loadHistoryMessage = new LoadHistoryMessage();
        loadHistoryMessage.setGroupId(String.valueOf(this.e.getGroupId()));
        long j = 0;
        if (this.i != null && this.i.getChatMessages() != null && this.i.getChatMessages().size() > 0 && this.i.getChatMessages().get(0) != null) {
            j = this.i.getChatMessages().get(0).getMsgId();
        }
        loadHistoryMessage.setLimit(20);
        loadHistoryMessage.setLastMsgId(String.valueOf(j));
        com.baidu.tieba.im.messageCenter.f.a().a(loadHistoryMessage);
        return true;
    }

    public boolean h() {
        if (this.e == null || this.e.getGroupId() == 0) {
            return false;
        }
        LoadDraftMessage loadDraftMessage = new LoadDraftMessage();
        loadDraftMessage.setGroupId(String.valueOf(this.e.getGroupId()));
        com.baidu.tieba.im.messageCenter.f.a().a(loadDraftMessage);
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
            com.baidu.tieba.im.messageCenter.f.a().a(saveDraftMessage);
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
        long a2 = aa.a(i());
        chatMessage.setMsgId(a2);
        chatMessage.setRecordId(a2);
        chatMessage.setTime(System.currentTimeMillis() / 1000);
        UserData userData = new UserData();
        userData.setName(TiebaApplication.H());
        userData.setId(TiebaApplication.C());
        userData.setPortrait(com.baidu.tieba.im.i.b());
        chatMessage.setUserInfo(userData);
        try {
            j = Long.valueOf(TiebaApplication.C()).longValue();
        } catch (Exception e) {
            com.baidu.adp.lib.h.d.a("transform error" + e.getMessage());
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

    public long i() {
        List<ChatMessage> chatMessages = this.i.getChatMessages();
        if (chatMessages == null || chatMessages.size() <= 0) {
            return 0L;
        }
        return chatMessages.get(chatMessages.size() - 1).getMsgId();
    }

    public void c(String str) {
        com.baidu.adp.lib.h.d.d("SHANG sendTextMessage");
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
        com.baidu.tieba.im.db.a.a().a(a2.getGroupId(), linkedList, false, new m(this, a2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChatMessage chatMessage) {
        VoiceMsgData e = com.baidu.tieba.im.d.c.e(chatMessage);
        if (e != null) {
            chatMessage.setLogTime(System.currentTimeMillis());
            this.l.a(e.getVoice_md5(), chatMessage.getRecordId());
        }
    }

    public void a(String str, Bitmap bitmap) {
        ChatMessage a2 = a((short) 2, a(str, str, bitmap.getWidth(), bitmap.getHeight()));
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
        com.baidu.tieba.im.db.a.a().a(a2.getGroupId(), linkedList, false, new n(this, a2, str));
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
        com.baidu.adp.lib.h.d.d("pic msg content:" + json);
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChatMessage chatMessage, String str) {
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
            } else if (optString.startsWith("http")) {
                com.baidu.tieba.im.chat.a.b().a(chatMessage);
            } else {
                r rVar = this.k.get(optString);
                if (rVar == null) {
                    rVar = new r(optString, 0, 0, 0, 0);
                    rVar.a(chatMessage);
                    rVar.a(this.m);
                    rVar.a(chatMessage.getGroupId());
                    synchronized (MsglistModel.class) {
                        this.k.put(optString, rVar);
                    }
                }
                chatMessage.setLogTime(System.currentTimeMillis());
                rVar.a();
            }
        }
    }

    public void a(int i) {
        ChatMessage b2 = b(i);
        if (b2 == null || b2.getLocalData() == null || b2.getLocalData().getStatus() == null) {
            com.baidu.adp.lib.h.d.b(b, "reSendMsg", "data error");
            return;
        }
        short shortValue = b2.getLocalData().getStatus().shortValue();
        if (shortValue != 2) {
            com.baidu.adp.lib.h.d.b(b, "reSendMsg", "status error:" + ((int) shortValue));
            return;
        }
        b2.setRecordId(b2.getMsgId());
        b2.getLocalData().setStatus((short) 1);
        b2.setTime(System.currentTimeMillis() / 1000);
        switch (b2.getMsgType()) {
            case 1:
                b(b2);
                break;
            case 2:
                a(b2, (String) null);
                break;
            case 3:
                a(b2);
                break;
        }
        this.mLoadDataMode = 6;
        this.mLoadDataCallBack.a(this.i);
        a(i, b2);
    }

    public ChatMessage b(int i) {
        if (this.i == null || this.i.getChatMessages() == null || i < 0 || i >= this.i.getChatMessages().size()) {
            return null;
        }
        return this.i.getChatMessages().get(i);
    }

    public void c(int i) {
        int size = this.i.getChatMessages().size();
        if (i >= 0 && i < size) {
            ChatMessage chatMessage = this.i.getChatMessages().get(i);
            if (this.e != null && chatMessage != null) {
                com.baidu.tieba.im.db.a.a().a(String.valueOf(this.e.getGroupId()), String.valueOf(chatMessage.getMsgId()), new o(this));
            }
            this.i.getChatMessages().remove(i);
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
                        String id = TiebaApplication.G().getID();
                        if (!TextUtils.isEmpty(id)) {
                            for (String str : split) {
                                if (id.equals(str)) {
                                    this.mLoadDataMode = 9;
                                    a(false);
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
                com.baidu.adp.lib.h.d.d("-------unlogin");
                this.mLoadDataMode = 11;
                this.mLoadDataCallBack.a(null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Message message) {
        if (!(message instanceof ResponseUpdateGroupMessage)) {
            com.baidu.adp.lib.h.d.d("transform error");
            return;
        }
        ResponseUpdateGroupMessage responseUpdateGroupMessage = (ResponseUpdateGroupMessage) message;
        if (responseUpdateGroupMessage.hasError()) {
            com.baidu.adp.lib.h.d.a("has error");
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
            Long valueOf = Long.valueOf(list.get(i2).getMsgId());
            ChatMessage chatMessage = list2.get(i);
            Long valueOf2 = Long.valueOf(chatMessage.getMsgId());
            if (valueOf.longValue() > valueOf2.longValue()) {
                i2--;
            } else if (valueOf.longValue() < valueOf2.longValue()) {
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
                    if (chatMessage != null && chatMessage.getUserInfo() != null && !TextUtils.isEmpty(chatMessage.getUserInfo().getId()) && chatMessage.getUserInfo().getId().equals(TiebaApplication.C()) && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() != 3) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                ChatMessage chatMessage2 = list2.get(i2);
                                if (chatMessage2 != null && chatMessage2.getUserInfo() != null && !TextUtils.isEmpty(chatMessage2.getUserInfo().getId()) && chatMessage2.getUserInfo().getId().equals(TiebaApplication.C()) && chatMessage2.getRecordId() == chatMessage.getRecordId()) {
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
            com.baidu.adp.lib.h.d.d("*****start updateMsgStatusTimeOut");
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 1) {
                    if ((System.currentTimeMillis() / 1000) - chatMessage.getTime() > 1800) {
                        chatMessage.getLocalData().setStatus((short) 2);
                        com.baidu.adp.lib.h.d.d("*****create time out");
                    } else if (com.baidu.tieba.im.messageCenter.f.a().c(chatMessage)) {
                        com.baidu.adp.lib.h.d.d("***** find in queues");
                    } else {
                        chatMessage.getLocalData().setStatus((short) 2);
                        com.baidu.adp.lib.h.d.d("*****no find in queues");
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChatResponsedMessage chatResponsedMessage) {
        if (chatResponsedMessage == null) {
            com.baidu.adp.lib.h.d.a("SHANG sendMsgSuc msg == null");
        } else if (chatResponsedMessage.getGroupId() != null && chatResponsedMessage.getGroupId().equals(String.valueOf(this.e.getGroupId()))) {
            com.baidu.adp.lib.h.d.d("SHANG sendMsgSuc msgId " + chatResponsedMessage.getMsgId() + " rid " + chatResponsedMessage.getRecordId());
            List<ChatMessage> chatMessages = this.i.getChatMessages();
            long recordId = chatResponsedMessage.getRecordId();
            long msgId = chatResponsedMessage.getMsgId();
            this.i.setNewAddNum(0);
            this.i.setIsNewAdd(false);
            int size = chatMessages.size();
            int i = size - 1;
            while (i >= 0 && recordId != chatMessages.get(i).getMsgId()) {
                i--;
            }
            if (i >= 0) {
                ChatMessage chatMessage = chatMessages.get(i);
                chatMessages.remove(i);
                int i2 = (size - 1) - 1;
                while (i2 >= 0 && chatMessages.get(i2).getMsgId() >= msgId) {
                    i2--;
                }
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
                chatMessages.add(i2 + 1, chatMessage);
                this.mLoadDataMode = 5;
                this.mLoadDataCallBack.a(this.i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ChatMessage chatMessage) {
        if (chatMessage == null) {
            com.baidu.adp.lib.h.d.a("SHANG sendMsgFail chatmessage == null");
        } else if (chatMessage.getGroupId() != null && chatMessage.getGroupId().equals(String.valueOf(this.e.getGroupId()))) {
            if (chatMessage.getLocalData() == null) {
                MsgLocalData msgLocalData = new MsgLocalData();
                msgLocalData.setStatus((short) 1);
                msgLocalData.setErrno(0L);
                msgLocalData.setRetry(0L);
                msgLocalData.setUpload_offset(null);
                chatMessage.setLocalData(msgLocalData);
            }
            com.baidu.adp.lib.h.d.d("SHANG sendMsgFail msgId " + chatMessage.getMsgId() + "recordId " + chatMessage.getRecordId());
            chatMessage.getLocalData().setStatus((short) 2);
            List<ChatMessage> chatMessages = this.i.getChatMessages();
            long recordId = chatMessage.getRecordId();
            int size = chatMessages.size() - 1;
            while (size >= 0 && chatMessages.get(size).getMsgId() != recordId) {
                size--;
            }
            if (size >= 0) {
                chatMessages.remove(size);
                chatMessages.add(size, chatMessage);
            }
            this.i.setNewAddNum(0);
            this.i.setIsNewAdd(false);
            this.mLoadDataMode = 5;
            this.mLoadDataCallBack.a(this.i);
        }
    }

    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.db.aa.a().a(String.valueOf(this.e.getGroupId()), aVar);
        RequestMarkReadedMessage requestMarkReadedMessage = new RequestMarkReadedMessage();
        requestMarkReadedMessage.setGroupId(String.valueOf(this.e.getGroupId()));
        com.baidu.tieba.im.messageCenter.f.a().a(requestMarkReadedMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return "";
        }
        int msgType = chatMessage.getMsgType();
        String string = TiebaApplication.g().getString(R.string.websocket_type);
        switch (msgType) {
            case 1:
                return string + TiebaApplication.g().getString(R.string.log_msg_text);
            case 2:
                return string + TiebaApplication.g().getString(R.string.log_msg_pic);
            case 3:
                return string + TiebaApplication.g().getString(R.string.log_msg_voice);
            default:
                return "";
        }
    }
}
