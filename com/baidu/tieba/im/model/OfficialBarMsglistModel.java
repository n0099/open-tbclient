package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.gson.Gson;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.snapGroup.SnapGroupChatActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.LoadOfficialBarDraftMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.OfficialBarSaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class OfficialBarMsglistModel extends CommonPersonalMsglistModel {
    private final int b;
    private boolean c;
    private CustomMessageListener d;

    public OfficialBarMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.b = 10;
        this.c = false;
        this.d = new bf(this, 0);
        f();
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        m();
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
    public boolean g_() {
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
        com.baidu.tieba.im.message.g gVar = new com.baidu.tieba.im.message.g();
        if (this.a == null) {
            return false;
        }
        gVar.b = String.valueOf(String.valueOf(this.a.getUserId()));
        gVar.a = str;
        super.sendMessage(new OfficialBarSaveDraftMessage(gVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ImMessageCenterPojo a(com.baidu.tieba.im.db.e eVar) {
        return null;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.db.i.a().c(SnapGroupChatActivity.b);
        aVar.a(null);
        com.baidu.tieba.im.i.a(new bg(this), aVar);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void a(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.i.a(new bh(this, chatMessage), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void b(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.i.a(new bi(this, chatMessage), null);
        }
    }

    private void f() {
        MessageManager.getInstance().registerListener(2015003, this.d);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_LOAD_DRAFT_OFFICIAL, this.d);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_LOAD_HISTORY_OFFICICAL, this.d);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_DEL_OFFICIAL_DB, this.d);
    }

    private void m() {
        MessageManager.getInstance().unRegisterListener(this.d);
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
                    ChatMessage n = n();
                    n.setRecordId(-1L);
                    n.setMsgId(-1L);
                    list.add(0, n);
                    this.c = true;
                }
                a((CustomResponsedMessage<?>) loadHistoryResponsedMessage);
            }
        }
    }

    private ChatMessage n() {
        if (this.a == null) {
            return null;
        }
        String format = String.format(this.t.getString(com.baidu.tieba.y.official_fake_message), this.a.getUserName());
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
}
