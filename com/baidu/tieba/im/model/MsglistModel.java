package com.baidu.tieba.im.model;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.Message;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.gson.Gson;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.cy;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.data.MsgPageData;
import com.baidu.tieba.im.data.VoiceMsgData;
import com.baidu.tieba.im.db.pojo.CommonMsgPojo;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.LoadDraftResponsedMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.ResponseCommitMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class MsglistModel extends com.baidu.adp.base.b {
    private static final String a = MsglistModel.class.getName();
    private String d;
    private final HashMap<String, com.baidu.tbadk.img.a<ChatMessage>> e;
    private final bz f;
    private final com.baidu.tbadk.img.d g;
    private bc h;
    protected MsgPageData s;
    protected MsglistActivity t;
    protected long u;
    private final int b = 1800;
    private boolean c = true;
    com.baidu.adp.base.e v = new ae(this);
    private final CustomMessageListener i = new aq(this, 0);
    private CustomMessageListener j = new ar(this, 0);

    /* loaded from: classes.dex */
    public class PicMessageData implements Serializable {
        private static final long serialVersionUID = -2120837602853869652L;
        public String big_src;
        public String bsize;
        public String src;
        public String type;
    }

    protected abstract ImMessageCenterPojo a(com.baidu.tieba.im.db.e eVar);

    public abstract void a(com.baidu.tieba.im.a<Void> aVar);

    protected abstract void a(ChatMessage chatMessage);

    public abstract boolean a(String str);

    protected abstract void b(ChatMessage chatMessage);

    public abstract boolean d();

    public abstract boolean e();

    protected abstract ChatMessage g();

    public abstract boolean g_();

    public MsglistModel(MsglistActivity msglistActivity) {
        this.s = null;
        setUniqueId(msglistActivity.getUniqueId());
        this.t = msglistActivity;
        this.s = new MsgPageData();
        this.e = new HashMap<>();
        this.g = new as(this);
        this.f = new bz();
        this.f.setLoadDataCallBack(this.v);
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        com.baidu.adp.widget.a.a c = com.baidu.tbadk.imageManager.e.a().c(str);
        String str3 = String.valueOf(str2) + 10;
        if (c != null && c.i()) {
            a(str3, c);
        } else {
            new aw(this, str, str3).execute(new Void[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, com.baidu.adp.widget.a.a aVar) {
        com.baidu.tbadk.imageManager.e.a().b(str, aVar);
        com.baidu.adp.lib.Disk.ops.c cVar = new com.baidu.adp.lib.Disk.ops.c(TbConfig.IMAGE_CACHE_DIR_NAME, com.baidu.tbadk.core.util.be.f(str), DiskFileOperate.Action.WRITE);
        cVar.a(DiskFileOperate.OperateType.TRY_SUCCESS);
        cVar.b(true);
        cVar.a(aVar.l());
        cVar.f(false);
        com.baidu.adp.lib.Disk.d.a().b(cVar);
    }

    private void b() {
        MessageManager.getInstance().registerListener(MessageTypes.CMD_UN_LOGIN, this.j);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_DELETE_MSG, this.i);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_CHAT_FAKE_SYSTEM_MESSAGE, this.i);
    }

    private void f() {
        MessageManager.getInstance().unRegisterListener(this.j);
        MessageManager.getInstance().unRegisterListener(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChatMessage a(long j) {
        if (this.s != null && this.s.getChatMessages() != null && this.s.getChatMessages().size() > 0) {
            for (ChatMessage chatMessage : this.s.getChatMessages()) {
                if (chatMessage.getRecordId() == j) {
                    return chatMessage;
                }
            }
        }
        return null;
    }

    public MsgPageData h() {
        return this.s;
    }

    public boolean i() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public void b(String str) {
        this.d = str;
    }

    @Override // com.baidu.adp.base.b
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.b
    public boolean cancelLoadData() {
        return false;
    }

    public void a() {
        com.baidu.tbadk.img.a<ChatMessage> remove;
        synchronized (MsglistModel.class) {
            if (this.e != null) {
                while (!this.e.isEmpty()) {
                    Set<Map.Entry<String, com.baidu.tbadk.img.a<ChatMessage>>> entrySet = this.e.entrySet();
                    if (!entrySet.isEmpty() && (remove = this.e.remove(entrySet.iterator().next().getKey())) != null) {
                        remove.b();
                    }
                }
            }
        }
        f();
    }

    public boolean c(String str) {
        if (this.d == null || !this.d.equals(str)) {
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
        g.setMsgType(s);
        g.setContent(str);
        long a2 = com.baidu.tieba.im.chat.bv.a(j());
        g.setMsgId(a2);
        g.setRecordId(a2);
        g.setTime(System.currentTimeMillis() / 1000);
        UserData userData = new UserData();
        userData.setUserName(TbadkApplication.getCurrentAccountName());
        userData.setUserId(TbadkApplication.getCurrentAccount());
        userData.setPortrait(com.baidu.tieba.im.e.b());
        g.setUserInfo(userData);
        try {
            j = com.baidu.adp.lib.f.b.a(TbadkApplication.getCurrentAccount(), 0L);
        } catch (Exception e) {
            BdLog.e("transform error" + e.getMessage());
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

    public long j() {
        List<ChatMessage> chatMessages = this.s.getChatMessages();
        if (chatMessages == null || chatMessages.size() <= 0) {
            return 0L;
        }
        return chatMessages.get(chatMessages.size() - 1).getMsgId();
    }

    public void d(String str) {
        BdLog.d("SHANG sendTextMessage");
        ChatMessage a2 = a((short) 1, str);
        if (a2 != null) {
            this.s.getChatMessages().add(a2);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.s);
            d(a2);
        }
    }

    public void a(com.baidu.tbadk.coreExtra.data.d dVar) {
        ChatMessage a2;
        String b = b(dVar);
        if (b != null && (a2 = a((short) 4, b)) != null) {
            this.s.getChatMessages().add(a2);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.s);
            d(a2);
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
        ChatMessage a2 = a((short) 3, "[" + new Gson().toJson(voiceMsgData) + "]");
        if (a2 != null) {
            a2.setCacheData(null);
            this.s.getChatMessages().add(a2);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.s);
            if (a2 instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) a2;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                com.baidu.tieba.im.i.a(new ax(this, commonGroupChatMessage, linkedList), new ay(this, commonGroupChatMessage));
            } else if (a2 instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) a2;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(personalChatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                com.baidu.tieba.im.i.a(new az(this, personalChatMessage, linkedList2), new ba(this, personalChatMessage));
            } else if (a2 instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) a2;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(officialChatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                com.baidu.tieba.im.i.a(new ai(this, officialChatMessage, linkedList3), new aj(this, officialChatMessage));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ChatMessage chatMessage) {
        VoiceMsgData g = com.baidu.tieba.im.f.r.g(chatMessage);
        if (g != null) {
            chatMessage.setLogTime(System.currentTimeMillis());
            this.f.a(g.getVoice_md5(), chatMessage.getRecordId());
        }
    }

    public void a(String str, Bitmap bitmap, com.baidu.tbadk.img.b<ChatMessage> bVar) {
        if (bitmap == null) {
            BdLog.e("chosedImage is null!!!");
            return;
        }
        ChatMessage a2 = a((short) 2, a(str, str, bitmap.getWidth(), bitmap.getHeight()));
        if (a2 != null) {
            a2.setIsUploading(true);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            a2.setWidth(width);
            a2.setHeight(height);
            this.s.getChatMessages().add(a2);
            this.mLoadDataMode = 4;
            this.mLoadDataCallBack.a(this.s);
            if (a2 instanceof CommonGroupChatMessage) {
                CommonGroupChatMessage commonGroupChatMessage = (CommonGroupChatMessage) a2;
                LinkedList linkedList = new LinkedList();
                CommonMsgPojo commonMsgPojo = new CommonMsgPojo(commonGroupChatMessage);
                commonMsgPojo.setRead_flag(0);
                linkedList.add(commonMsgPojo);
                com.baidu.tieba.im.i.a(new ak(this, commonGroupChatMessage, linkedList), new al(this, commonGroupChatMessage, str, bVar));
            } else if (a2 instanceof PersonalChatMessage) {
                PersonalChatMessage personalChatMessage = (PersonalChatMessage) a2;
                LinkedList linkedList2 = new LinkedList();
                CommonMsgPojo commonMsgPojo2 = new CommonMsgPojo(personalChatMessage);
                commonMsgPojo2.setRead_flag(0);
                linkedList2.add(commonMsgPojo2);
                com.baidu.tieba.im.i.a(new am(this, personalChatMessage, linkedList2), new an(this, personalChatMessage, str, bVar));
            } else if (a2 instanceof OfficialChatMessage) {
                OfficialChatMessage officialChatMessage = (OfficialChatMessage) a2;
                LinkedList linkedList3 = new LinkedList();
                CommonMsgPojo commonMsgPojo3 = new CommonMsgPojo(officialChatMessage);
                commonMsgPojo3.setRead_flag(0);
                linkedList3.add(commonMsgPojo3);
                com.baidu.tieba.im.i.a(new ao(this, officialChatMessage, linkedList3), new ap(this, officialChatMessage, str, bVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String a(String str, String str2, int i, int i2) {
        PicMessageData picMessageData = new PicMessageData();
        picMessageData.src = str2;
        picMessageData.big_src = str;
        picMessageData.type = TbConfig.ST_PARAM_PERSON_INFO_SEND_MESSAGE;
        if (i > 0) {
            picMessageData.bsize = String.valueOf(i) + "," + i2;
        }
        LinkedList linkedList = new LinkedList();
        linkedList.add(picMessageData);
        String json = new Gson().toJson(linkedList);
        BdLog.d("pic msg content:" + json);
        return json;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ChatMessage chatMessage, String str, com.baidu.tbadk.img.b<ChatMessage> bVar) {
        if (chatMessage != null) {
            if (chatMessage.getContent() == null) {
                e(chatMessage);
            }
            if (str == null) {
                try {
                    str = new JSONArray(chatMessage.getContent()).getJSONObject(0).optString("src");
                } catch (Exception e) {
                    e.printStackTrace();
                    e(chatMessage);
                    return;
                }
            }
            if (str == null) {
                e(chatMessage);
                return;
            }
            chatMessage.setProgressValue(0);
            chatMessage.setIsUploading(true);
            if (str.startsWith("http")) {
                com.baidu.tieba.im.chat.w.b().a(chatMessage);
                return;
            }
            com.baidu.tbadk.img.a<ChatMessage> aVar = this.e.get(str);
            if (aVar == null) {
                com.baidu.tbadk.img.a<ChatMessage> aVar2 = new com.baidu.tbadk.img.a<>(str, "IM");
                aVar2.d();
                aVar2.a((com.baidu.tbadk.img.a<ChatMessage>) chatMessage);
                aVar2.a(bVar);
                aVar2.a(this.g);
                if (chatMessage instanceof CommonGroupChatMessage) {
                    aVar2.a(((CommonGroupChatMessage) chatMessage).getGroupId());
                } else if (chatMessage instanceof PersonalChatMessage) {
                    aVar2.a(String.valueOf(com.baidu.tieba.im.chat.w.a));
                } else if (chatMessage instanceof OfficialChatMessage) {
                    aVar2.a(String.valueOf(com.baidu.tieba.im.chat.w.a));
                }
                synchronized (MsglistModel.class) {
                    this.e.put(str, aVar2);
                }
                aVar = aVar2;
            }
            chatMessage.setLogTime(System.currentTimeMillis());
            aVar.a();
        }
    }

    public void a(int i, com.baidu.tbadk.img.b<ChatMessage> bVar) {
        ChatMessage a2 = a(i);
        if (a2 == null || a2.getLocalData() == null || a2.getLocalData().getStatus() == null) {
            BdLog.e(a, "reSendMsg", "data error");
            return;
        }
        short shortValue = a2.getLocalData().getStatus().shortValue();
        if (shortValue != 2) {
            BdLog.e(a, "reSendMsg", "status error:" + ((int) shortValue));
            return;
        }
        a2.setRecordId(a2.getMsgId());
        a2.getLocalData().setStatus((short) 1);
        a2.setTime(System.currentTimeMillis() / 1000);
        switch (a2.getMsgType()) {
            case 1:
                d(a2);
                break;
            case 2:
                a(a2, (String) null, bVar);
                break;
            case 3:
                c(a2);
                break;
            case 4:
                d(a2);
                break;
        }
        this.mLoadDataMode = 6;
        this.mLoadDataCallBack.a(this.s);
        a(i, a2);
    }

    public ChatMessage a(int i) {
        if (this.s == null || this.s.getChatMessages() == null || i < 0 || i >= this.s.getChatMessages().size()) {
            return null;
        }
        return this.s.getChatMessages().get(i);
    }

    public void b(int i) {
        int size = this.s.getChatMessages().size();
        if (i >= 0 && i < size) {
            a(this.s.getChatMessages().get(i));
            this.s.getChatMessages().remove(i);
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
    }

    public void c(int i) {
        ImMessageCenterPojo a2;
        int size = this.s.getChatMessages().size();
        if (i >= 0 && i < size) {
            ChatMessage chatMessage = this.s.getChatMessages().get(i);
            ChatMessage chatMessage2 = i + (-1) >= 0 ? this.s.getChatMessages().get(i - 1) : null;
            b(chatMessage);
            this.s.getChatMessages().remove(i);
            if (i == size - 1 && (a2 = a((com.baidu.tieba.im.db.e) null)) != null) {
                if (chatMessage2 != null) {
                    a2.setLast_content_time(chatMessage2.getTime() * 1000);
                    a2.setLast_content(com.baidu.tieba.im.f.r.i(chatMessage2));
                    a2.setLast_user_name(chatMessage2.getUserInfo().getUserName());
                    a2.setLast_rid(chatMessage2.getRecordId());
                } else {
                    a2.setLast_content(" ");
                    a2.setLast_user_name(" ");
                }
            }
        }
        this.mLoadDataMode = 7;
        this.mLoadDataCallBack.a(null);
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

    private void d(ChatMessage chatMessage) {
        com.baidu.tieba.im.chat.w.b().a(chatMessage);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() != null) {
                if (this.u == 0 || this.u == com.baidu.adp.lib.f.b.a(loadHistoryResponsedMessage.getData().a, 0L)) {
                    List<ChatMessage> list = loadHistoryResponsedMessage.getData().b;
                    boolean z = loadHistoryResponsedMessage.getData().c;
                    int a2 = a(this.s.getChatMessages(), list);
                    if (a2 > 0) {
                        this.s.setIsNewAdd(true);
                        this.s.setNewAddNum(a2);
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
                    } else if (this.s.getIsNewAdd()) {
                        this.mLoadDataMode = 2;
                        this.mLoadDataCallBack.a(null);
                    }
                }
            }
        }
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
        Collections.sort(list, new bb(this, null));
        int a2 = a(this.s.getChatMessages(), list);
        if (a2 > 0) {
            this.s.setIsNewAdd(true);
            this.s.setNewAddNum(a2);
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
                if (responseCommitMessage.getError() > 0) {
                    this.t.showToast(responseCommitMessage.getErrorString());
                    if (chatMessage.getRecordId() != responseCommitMessage.getRecordId()) {
                        responseCommitMessage.setRecordId(chatMessage.getRecordId());
                        TiebaStatic.imLog(responseCommitMessage.getCmd(), 0, "orginalRecordId != serverRecordId", "", (String) null, responseCommitMessage.getError(), responseCommitMessage.getErrorString());
                    }
                }
                e(chatMessage);
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
    public void k() {
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
        boolean z;
        if (list != null && list.size() != 0) {
            BdLog.d("*****start updateMsgStatusTimeOut");
            for (ChatMessage chatMessage : list) {
                if (chatMessage != null && chatMessage.getLocalData() != null && chatMessage.getLocalData().getStatus().shortValue() == 1) {
                    if ((System.currentTimeMillis() / 1000) - chatMessage.getTime() > 1800) {
                        chatMessage.getLocalData().setStatus((short) 2);
                        BdLog.d("*****create time out");
                    } else {
                        Iterator<? extends Message> it = MessageManager.getInstance().findMessage(chatMessage.getCmd(), this.t.getUniqueId()).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            Message next = it.next();
                            if ((next instanceof ChatMessage) && ((ChatMessage) next).getSquencedId() == chatMessage.getSquencedId()) {
                                z = true;
                                break;
                            }
                        }
                        if (z) {
                            BdLog.d("***** find in queues");
                        } else {
                            chatMessage.getLocalData().setStatus((short) 2);
                            BdLog.d("*****no find in queues");
                        }
                    }
                }
            }
        }
    }

    private void b(ResponseCommitMessage responseCommitMessage) {
        if (responseCommitMessage == null) {
            BdLog.e("SHANG sendMsgSuc msg == null");
            return;
        }
        BdLog.d("SHANG sendMsgSuc msgId " + responseCommitMessage.getMsgId() + " rid " + responseCommitMessage.getRecordId());
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
        if (this.h != null) {
            BdLog.d("simon", "send message", "send text");
            this.h.a(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(ChatMessage chatMessage) {
        if (chatMessage == null) {
            BdLog.e("sendMsgFail chatmessage == null");
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
        BdLog.d("sendMsgFail msgId " + chatMessage.getMsgId() + "recordId " + chatMessage.getRecordId());
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

    private String f(ChatMessage chatMessage) {
        if (chatMessage == null) {
            return "";
        }
        int msgType = chatMessage.getMsgType();
        String string = TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.websocket_type);
        switch (msgType) {
            case 1:
                return String.valueOf(string) + TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.log_msg_text);
            case 2:
                return String.valueOf(string) + TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.log_msg_pic);
            case 3:
                return String.valueOf(string) + TbadkApplication.m252getInst().getApp().getString(com.baidu.tieba.y.log_msg_voice);
            default:
                return "";
        }
    }

    private void c(List<ChatMessage> list) {
        int i;
        int i2;
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
                    cy.a = com.baidu.tbadk.editortool.ab.b();
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

    public void a(bc bcVar) {
        this.h = bcVar;
    }
}
