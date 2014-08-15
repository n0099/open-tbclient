package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bt;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.LoadOfficialBarDraftMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.OfficialBarSaveDraftMessage;
import com.baidu.tieba.im.message.RequestOfficialBarMenuLocalMessage;
import com.baidu.tieba.im.message.RequestOfficialBarMenuMessage;
import com.baidu.tieba.im.message.RequestSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarMsglistModel extends CommonPersonalMsglistModel {
    private final int b;
    private boolean c;
    private com.baidu.tieba.im.data.m d;
    private CustomMessageListener e;

    public OfficialBarMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.b = 10;
        this.c = false;
        this.e = new ao(this, 0);
        n();
        this.v = 4;
    }

    public com.baidu.tieba.im.data.m f() {
        return this.d;
    }

    public void a(com.baidu.tieba.im.data.m mVar) {
        this.d = mVar;
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        o();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage g() {
        if (this.a == null) {
            return null;
        }
        OfficialChatMessage officialChatMessage = new OfficialChatMessage();
        officialChatMessage.setBornTime(System.currentTimeMillis());
        officialChatMessage.setToUserId(this.a.getUserIdLong());
        UserData userData = new UserData();
        userData.setUserId(String.valueOf(this.a.getUserId()));
        userData.setUserName(this.a.getUserName());
        userData.setPortrait(this.a.getPortrait());
        userData.setUserType(1);
        officialChatMessage.setToUserInfo(userData);
        return officialChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean a(bt btVar) {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.c cVar = new com.baidu.tieba.im.message.c();
        cVar.c = 10;
        cVar.a = null;
        cVar.b = null;
        cVar.d = new StringBuilder(String.valueOf(this.a.getUserIdLong())).toString();
        super.sendMessage(new LoadOfficialHistoryMessage(cVar));
        return true;
    }

    public String m() {
        UserData c = c();
        return c != null ? c.getUserId() : "";
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean d() {
        long j;
        long j2 = 0;
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.c cVar = new com.baidu.tieba.im.message.c();
        cVar.c = 10;
        if (this.s == null || this.s.getChatMessages() == null || this.s.getChatMessages().size() <= 0 || this.s.getChatMessages().get(0) == null) {
            j = 0;
        } else {
            j = this.s.getChatMessages().get(0).getMsgId();
            j2 = this.s.getChatMessages().get(0).getRecordId();
        }
        cVar.a = String.valueOf(j);
        cVar.b = String.valueOf(j2);
        cVar.d = new StringBuilder(String.valueOf(this.a.getUserIdLong())).toString();
        super.sendMessage(new LoadOfficialHistoryMessage(cVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean e() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.a aVar = new com.baidu.tieba.im.message.a();
        aVar.a = this.a.getUserId();
        super.sendMessage(new LoadOfficialBarDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean a(String str) {
        com.baidu.tieba.im.message.q qVar = new com.baidu.tieba.im.message.q();
        if (this.a == null) {
            return false;
        }
        qVar.b = String.valueOf(String.valueOf(this.a.getUserId()));
        qVar.a = str;
        super.sendMessage(new OfficialBarSaveDraftMessage(qVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void a(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.e.a(new ap(this, chatMessage), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void b(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.e.a(new aq(this, chatMessage), null);
        }
    }

    private void n() {
        MessageManager.getInstance().registerListener(2013003, this.e);
        MessageManager.getInstance().registerListener(2001148, this.e);
        MessageManager.getInstance().registerListener(2001151, this.e);
        MessageManager.getInstance().registerListener(2001155, this.e);
    }

    private void o() {
        MessageManager.getInstance().unRegisterListener(this.e);
    }

    public void a(String str, long j) {
        RequestOfficialBarMenuMessage requestOfficialBarMenuMessage = new RequestOfficialBarMenuMessage();
        requestOfficialBarMenuMessage.setForum_id(str);
        requestOfficialBarMenuMessage.setTimestamp(j);
        sendMessage(requestOfficialBarMenuMessage);
    }

    public void f(String str) {
        RequestOfficialBarMenuLocalMessage requestOfficialBarMenuLocalMessage = new RequestOfficialBarMenuLocalMessage();
        requestOfficialBarMenuLocalMessage.setForum_id(str);
        sendMessage(requestOfficialBarMenuLocalMessage);
    }

    public void a(String str, String str2, String str3) {
        RequestSendOfficialBarMenuMessage requestSendOfficialBarMenuMessage = new RequestSendOfficialBarMenuMessage();
        requestSendOfficialBarMenuMessage.setRid(str);
        requestSendOfficialBarMenuMessage.setUser_id(str2);
        requestSendOfficialBarMenuMessage.setForum_id(str3);
        sendMessage(requestSendOfficialBarMenuMessage);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() != null) {
                List list = loadHistoryResponsedMessage.getData().b;
                if (list == null) {
                    list = new LinkedList();
                }
                if (list.size() < 10 && !this.c) {
                    ChatMessage p = p();
                    p.setRecordId(-1L);
                    list.add(0, p);
                    this.c = true;
                }
                a(loadHistoryResponsedMessage);
            }
        }
    }

    private ChatMessage p() {
        if (this.a == null) {
            return null;
        }
        String format = String.format(this.t.getString(com.baidu.tieba.x.official_fake_message), this.a.getUserName());
        HashMap hashMap = new HashMap();
        hashMap.put("eventId", "-10001");
        hashMap.put("userMsg", format);
        return a((short) 11, new Gson().toJson(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (c() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof OfficialChatMessage) {
                        if (chatMessage.getToUserId() == c().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        } else if (chatMessage.getUserId() == c().getUserIdLong()) {
                            linkedList.add(chatMessage);
                        }
                    }
                }
                a(linkedList);
            }
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected aj h() {
        if (this.a == null) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.a = this.a.getUserId();
        ajVar.b = 4;
        return ajVar;
    }
}
