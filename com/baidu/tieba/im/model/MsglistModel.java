package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bt;
import com.baidu.tieba.im.chat.bu;
import com.baidu.tieba.im.chat.dh;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class MsglistModel extends com.baidu.adp.base.e {
    private String c;
    private al d;
    protected MsgPageData s;
    protected MsglistActivity t;
    protected long u;
    protected int v;
    private final int a = 1800;
    private boolean b = true;
    private final CustomMessageListener e = new v(this, 0);
    private CustomMessageListener f = new ab(this, 0);

    /* loaded from: classes.dex */
    public class PicMessageData implements Serializable {
        private static final long serialVersionUID = -2120837602853869652L;
        public String big_src;
        public String bsize;
        public String src;
        public String type;
    }

    protected abstract void a(ChatMessage chatMessage);

    public abstract boolean a(bt btVar);

    public abstract boolean a(String str);

    protected abstract long b();

    protected abstract void b(ChatMessage chatMessage);

    public abstract boolean d();

    public abstract boolean e();

    protected abstract ChatMessage g();

    protected abstract aj h();

    public MsglistModel(MsglistActivity msglistActivity) {
        this.s = null;
        setUniqueId(msglistActivity.getUniqueId());
        this.t = msglistActivity;
        this.s = new MsgPageData();
        c();
    }

    private void c() {
        MessageManager.getInstance().registerListener(2001157, this.f);
        MessageManager.getInstance().registerListener(2001113, this.e);
        MessageManager.getInstance().registerListener(501126, this.e);
    }

    private void f() {
        MessageManager.getInstance().unRegisterListener(this.f);
        MessageManager.getInstance().unRegisterListener(this.e);
    }

    public MsgPageData i() {
        return this.s;
    }

    public boolean j() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void b(String str) {
        this.c = str;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void a() {
        com.baidu.tieba.im.chat.w.a().a((al) null);
        f();
    }

    public boolean c(String str) {
        if (this.c == null || !this.c.equals(str)) {
            return a(str);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ChatMessage a(short s, String str) {
        long j;
        ChatMessage g = g();
        if (g == null) {
            return null;
        }
        g.setCustomGroupType(this.v);
        g.setMsgType(s);
        g.setContent(str);
        long a = bu.a(k());
        g.setMsgId(a);
        g.setRecordId(a);
        g.setTime(System.currentTimeMillis() / 1000);
        UserData userData = new UserData();
        userData.setUserName(TbadkApplication.getCurrentAccountName());
        userData.setUserId(TbadkApplication.getCurrentAccount());
        userData.setPortrait(com.baidu.tieba.im.c.b());
        g.setUserInfo(userData);
        try {
            j = com.baidu.adp.lib.e.c.a(TbadkApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
            j = 0;
        }
        g.setUserId(j);
        MsgLocalData msgLocalData = new MsgLocalData();
        msgLocalData.setStatus((short) 1);
        msgLocalData.setErrno(0L);
        msgLocalData.setRetry(0L);
        msgLocalData.setUpload_offset(null);
        g.setLocalData(msgLocalData);
        return g;
    }

    public long k() {
        List<ChatMessage> chatMessages = this.s.getChatMessages();
        return (chatMessages == null || chatMessages.size() <= 0) ? b() : chatMessages.get(chatMessages.size() - 1).getMsgId();
    }

    public void d(String str) {
        ChatMessage a = a((short) 1, str);
        if (a != null) {
            this.s.getChatMessages().add(a);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.s);
            e(a);
        }
    }

    public void e(String str) {
        ChatMessage a = a((short) 9, str);
        if (a != null) {
            this.s.getChatMessages().add(a);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.s);
            e(a);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        ChatMessage a;
        String b = b(dVar);
        if (b != null && (a = a((short) 4, b)) != null) {
            this.s.getChatMessages().add(a);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.s);
            e(a);
        }
    }

    private String b(com.baidu.tbadk.coreExtra.data.d dVar) {
        try {
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("pid", dVar.d());
            jSONObject.put("packet_name", dVar.c());
            jSONObject.put("face_name", dVar.a());
            jSONObject.put("size_width", dVar.e());
            jSONObject.put("size_height", dVar.f());
            jSONArray.put(jSONObject);
            return jSONArray.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a(String str, int i) {
        VoiceMsgData voiceMsgData = new VoiceMsgData();
        voiceMsgData.setDuring_time(i);
        voiceMsgData.setVoice_md5(str);
        voiceMsgData.setHas_read(0);
        ChatMessage a = a((short) 3, "[" + new Gson().toJson(voiceMsgData) + "]");
        if (a != null) {
            a.setCacheData(null);
            this.s.getChatMessages().add(a);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.s);
            if (a instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) a;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                com.baidu.tieba.im.e.a(new ac(this, commonGroupChatMessage, linkedList), new ad(this, commonGroupChatMessage));
            } else if (a instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) a;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(personalChatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                com.baidu.tieba.im.e.a(new ae(this, personalChatMessage, linkedList2), new af(this, personalChatMessage));
            } else if (a instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) a;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(officialChatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                com.baidu.tieba.im.e.a(new ag(this, officialChatMessage, linkedList3), new ah(this, officialChatMessage));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ChatMessage chatMessage) {
        VoiceMsgData h = com.baidu.tieba.im.d.j.h(chatMessage);
        if (h != null) {
            chatMessage.setLogTime(System.currentTimeMillis());
            com.baidu.tieba.im.chat.w.a(chatMessage);
            com.baidu.tieba.im.chat.w.a().a(h, chatMessage);
        }
    }

    public void a(String str, Bitmap bitmap) {
        ChatMessage a;
        if (bitmap != null && (a = a((short) 2, com.baidu.tieba.im.chat.w.a(str, str, bitmap.getWidth(), bitmap.getHeight()))) != null) {
            a.setIsUploading(true);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            a.setWidth(width);
            a.setHeight(height);
            this.s.getChatMessages().add(a);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.s);
            if (a instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) a;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                com.baidu.tieba.im.e.a(new ai(this, commonGroupChatMessage, linkedList), new w(this, commonGroupChatMessage, str));
            } else if (a instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) a;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(personalChatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                com.baidu.tieba.im.e.a(new x(this, personalChatMessage, linkedList2), new y(this, personalChatMessage, str));
            } else if (a instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) a;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(officialChatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                com.baidu.tieba.im.e.a(new z(this, officialChatMessage, linkedList3), new aa(this, officialChatMessage, str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChatMessage chatMessage, String str) {
        if (chatMessage != null) {
            if (chatMessage.getContent() == null) {
                c(chatMessage);
            }
            if (str == null) {
                try {
                    str = new JSONArray(chatMessage.getContent()).getJSONObject(0).optString("src");
                } catch (Exception e) {
                    e.printStackTrace();
                    c(chatMessage);
                    return;
                }
            }
            if (str == null) {
                c(chatMessage);
                return;
            }
            chatMessage.setProgressValue(0);
            chatMessage.setIsUploading(true);
            if (str.startsWith("http")) {
                com.baidu.tieba.im.chat.w.a().d(chatMessage);
            } else {
                com.baidu.tieba.im.chat.w.a().a(chatMessage, str);
            }
        }
    }

    public void a(int i) {
        ChatMessage b = b(i);
        if (b != null && b.getLocalData() != null && b.getLocalData().getStatus() != null && b.getLocalData().getStatus().shortValue() == 2) {
            b.setRecordId(b.getMsgId());
            b.getLocalData().setStatus((short) 1);
            b.setTime(System.currentTimeMillis() / 1000);
            b.setCustomGroupType(this.v);
            switch (b.getMsgType()) {
                case 1:
                    e(b);
                    break;
                case 2:
                    a(b, (String) null);
                    break;
                case 3:
                    d(b);
                    break;
                case 4:
                    e(b);
                    break;
                case 9:
                    e(b);
                    break;
            }
            this.mLoadDataMode = 6;
            this.mLoadDataCallBack.a(this.s);
            a(i, b);
        }
    }

    public ChatMessage b(int i) {
        if (this.s == null || this.s.getChatMessages() == null || i < 0 || i >= this.s.getChatMessages().size()) {
            return null;
        }
        return this.s.getChatMessages().get(i);
    }

    public void c(int i) {
        a(1, i);
    }

    private void a(int i, int i2) {
        aj h;
        int size = this.s.getChatMessages().size();
        if (i2 >= 0 && i2 < size) {
            ChatMessage chatMessage = this.s.getChatMessages().get(i2);
            switch (i) {
                case 1:
                    a(chatMessage);
                    break;
                case 2:
                    b(chatMessage);
                    break;
            }
            ChatMessage chatMessage2 = i2 + (-1) >= 0 ? this.s.getChatMessages().get(i2 - 1) : null;
            b(chatMessage);
            this.s.getChatMessages().remove(i2);
            if (i2 == size - 1 && (h = h()) != null) {
                com.baidu.tieba.im.message.g gVar = new com.baidu.tieba.im.message.g();
                gVar.b = h.b;
                gVar.a = h.a;
                gVar.c = chatMessage2;
                gVar.d = 2;
                MessageManager.getInstance().dispatchResponsedMessageToUI(new MemoryModifyLastMsgMessage(gVar));
            }
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    public void d(int i) {
        a(2, i);
    }

    public void a(int i, ChatMessage chatMessage) {
        List<ChatMessage> chatMessages = this.s.getChatMessages();
        int size = chatMessages.size();
        if (i >= 0 && i < size) {
            chatMessages.remove(i);
            chatMessages.add(i, chatMessage);
            this.s.setIsNewAdd(false);
            this.s.setNewAddNum(0);
        }
    }

    private void e(ChatMessage chatMessage) {
        com.baidu.tieba.im.chat.w.a().d(chatMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() == null) {
                return true;
            }
            if (this.u == 0 || this.u == com.baidu.adp.lib.e.c.a(loadHistoryResponsedMessage.getData().a, 0L)) {
                List<ChatMessage> list = loadHistoryResponsedMessage.getData().b;
                boolean z = loadHistoryResponsedMessage.getData().c;
                int a = a(this.s.getChatMessages(), list);
                if (a > 0) {
                    this.s.setIsNewAdd(true);
                    this.s.setNewAddNum(a);
                } else {
                    this.s.setIsNewAdd(false);
                    this.s.setNewAddNum(0);
                }
                b(this.s.getChatMessages());
                if (z) {
                    if (this.s.getIsNewAdd()) {
                        this.mLoadDataMode = 1;
                        this.mLoadDataCallBack.a(null);
                    }
                    return true;
                }
                if (this.s.getIsNewAdd()) {
                    this.mLoadDataMode = 2;
                    this.mLoadDataCallBack.a(null);
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof LoadDraftResponsedMessage) {
            LoadDraftResponsedMessage loadDraftResponsedMessage = (LoadDraftResponsedMessage) customResponsedMessage;
            if (loadDraftResponsedMessage.getData() != null) {
                String str = loadDraftResponsedMessage.getData().a;
                this.mLoadDataMode = 8;
                this.mLoadDataCallBack.a(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<ChatMessage> a(List<ChatMessage> list) {
        c(list);
        b(this.s.getChatMessages(), list);
        Collections.sort(list, new ak(this, null));
        int a = a(this.s.getChatMessages(), list);
        if (a > 0) {
            this.s.setIsNewAdd(true);
            this.s.setNewAddNum(a);
            this.mLoadDataMode = 3;
            this.mLoadDataCallBack.a(this.s);
        } else {
            this.s.setIsNewAdd(false);
            this.s.setNewAddNum(0);
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ResponseCommitMessage responseCommitMessage) {
        if (responseCommitMessage != null) {
            if (responseCommitMessage.getOrginalMessage() == null || !(responseCommitMessage.getOrginalMessage() instanceof ChatMessage)) {
                TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "chatResMessage.getOrginalMessage()==null", "return", (String) null, 0, (String) null);
                return;
            }
            ChatMessage chatMessage = (ChatMessage) responseCommitMessage.getOrginalMessage();
            if (responseCommitMessage.getError() != 0) {
                TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "", "", String.valueOf(f(chatMessage)) + "rid" + chatMessage.getRecordId(), responseCommitMessage.getError(), responseCommitMessage.getErrorString(), System.currentTimeMillis() - chatMessage.getLogTime());
                if (responseCommitMessage.getError() > 0 && responseCommitMessage.getError() != 3160008) {
                    this.t.showToast(responseCommitMessage.getErrorString());
                    if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
                        responseCommitMessage.setRecordId(chatMessage.getRecordId());
                        TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "orginalRecordId != serverRecordId", "", (String) null, responseCommitMessage.getError(), responseCommitMessage.getErrorString());
                    }
                }
                c(chatMessage);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - chatMessage.getLogTime();
            long recordId = responseCommitMessage.getRecordId();
            long msgId = responseCommitMessage.getMsgId();
            TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "", "", "rid = " + recordId + "msgId = " + msgId + f(chatMessage), responseCommitMessage.getError(), responseCommitMessage.getErrorString(), currentTimeMillis);
            if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
                responseCommitMessage.setRecordId(chatMessage.getRecordId());
                TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "orginalRecordId != serverRecordId", "", (String) null, responseCommitMessage.getError(), responseCommitMessage.getErrorString());
            }
            b(responseCommitMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l() {
        if (this.s != null && this.s.getChatMessages() != null && this.s.getChatMessages().size() != 0) {
            this.s.getChatMessages().clear();
            this.mLoadDataMode = 12;
            this.mLoadDataCallBack.a(null);
        }
    }

    private int a(List<ChatMessage> list, List<ChatMessage> list2) {
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

    private void b(List<ChatMessage> list, List<ChatMessage> list2) {
        if (list != null && list2 != null) {
            int size = list.size();
            int size2 = list2.size();
            if (size2 != 0) {
                ArrayList arrayList = new ArrayList();
                for (int i = size - 1; i >= 0 && i >= 0; i--) {
                    ChatMessage chatMessage = list.get(i);
                    if (chatMessage != null && chatMessage.getUserInfo() != null && !TextUtils.isEmpty(chatMessage.getUserInfo().getUserId()) && chatMessage.getUserInfo().getUserId().equals(TbadkApplication.getCurrentAccount()) && chatMessage.getLocalData() != null && (chatMessage.getLocalData().getStatus().shortValue() != 3 || chatMessage.getMsgType() == 4)) {
                        int i2 = size2 - 1;
                        while (true) {
                            if (i2 >= 0 && i2 >= 0) {
                                ChatMessage chatMessage2 = list2.get(i2);
                                if (chatMessage2 != null && chatMessage2.getUserInfo() != null && !TextUtils.isEmpty(chatMessage2.getUserInfo().getUserId()) && chatMessage2.getUserInfo().getUserId().equals(TbadkApplication.getCurrentAccount()) && chatMessage2.getRecordId() == chatMessage.getRecordId()) {
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

    private void b(List<ChatMessage> list) {
        if (list != null && list.size() != 0) {
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 1) {
                    chatMessage.setCustomGroupType(this.v);
                    if ((System.currentTimeMillis() / 1000) - chatMessage.getTime() > 1800) {
                        chatMessage.getLocalData().setStatus((short) 2);
                    } else {
                        boolean z = false;
                        if (MessageManager.getInstance().getSocketClient() != null) {
                            z = MessageManager.getInstance().getSocketClient().a(chatMessage);
                        }
                        if (!z && (chatMessage.getMsgType() != 2 || !com.baidu.tieba.im.chat.w.a().b(chatMessage))) {
                            if (chatMessage.getMsgType() != 3 || !com.baidu.tieba.im.chat.w.a().c(chatMessage)) {
                                chatMessage.getLocalData().setStatus((short) 2);
                            }
                        }
                    }
                }
            }
        }
    }

    private void b(ResponseCommitMessage responseCommitMessage) {
        if (responseCommitMessage != null) {
            List<ChatMessage> chatMessages = this.s.getChatMessages();
            long recordId = responseCommitMessage.getRecordId();
            long msgId = responseCommitMessage.getMsgId();
            this.s.setNewAddNum(0);
            this.s.setIsNewAdd(false);
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
            this.mLoadDataCallBack.a(this.s);
            if (this.d != null) {
                this.d.a(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(ChatMessage chatMessage) {
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
            List<ChatMessage> chatMessages = this.s.getChatMessages();
            if (chatMessages != null && chatMessages.size() != 0) {
                long recordId = chatMessage.getRecordId();
                int size = chatMessages.size() - 1;
                while (size >= 0 && chatMessages.get(size).getMsgId() != recordId) {
                    size--;
                }
                if (size >= 0) {
                    chatMessages.remove(size);
                    chatMessages.add(size, chatMessage);
                    this.s.setNewAddNum(0);
                    this.s.setIsNewAdd(false);
                    this.mLoadDataMode = 5;
                    this.mLoadDataCallBack.a(this.s);
                }
            }
        }
    }

    private String f(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return "";
        }
        int msgType = chatMessage.getMsgType();
        String string = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.websocket_type);
        switch (msgType) {
            case 1:
                return String.valueOf(string) + TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.log_msg_text);
            case 2:
                return String.valueOf(string) + TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.log_msg_pic);
            case 3:
                return String.valueOf(string) + TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.log_msg_voice);
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return "";
            case 9:
                return String.valueOf(string) + TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.x.log_msg_extra);
        }
    }

    private void c(List<ChatMessage> list) {
        int i;
        int i2;
        if (list != null) {
            if (this.t.a() != null) {
                i2 = this.t.a().getFirstVisiblePosition();
                i = this.t.a().getLastVisiblePosition();
            } else {
                i = -1;
                i2 = -1;
            }
            List<ChatMessage> chatMessages = this.s.getChatMessages();
            int size = chatMessages.size();
            if (i2 >= 0 && i < size) {
                for (ChatMessage chatMessage : list) {
                    if (chatMessage.getMsgType() == 4) {
                        dh.a = com.baidu.tbadk.b.c.a();
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

    public void a(al alVar) {
        this.d = alVar;
        com.baidu.tieba.im.chat.w.a().a(alVar);
    }

    public void a(com.baidu.tbadk.img.b<ChatMessage> bVar) {
        com.baidu.tieba.im.chat.w.a().a(bVar);
    }
}
