package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.PersonalChatActivity;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.LoadPersonalDraftMessage;
import com.baidu.tieba.im.message.LoadPersonalHistoryMessage;
import com.baidu.tieba.im.message.PersonalSaveDraftMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class PersonalMsglistModel extends CommonPersonalMsglistModel {
    private final int b;
    private CustomMessageListener c;

    public PersonalMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.b = 20;
        this.c = new bo(this, 0);
        m();
    }

    @Override // com.baidu.tieba.im.model.CommonPersonalMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        f();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage g() {
        if (this.a == null) {
            return null;
        }
        PersonalChatMessage personalChatMessage = new PersonalChatMessage();
        personalChatMessage.setBornTime(System.currentTimeMillis());
        personalChatMessage.setToUserId(this.a.getUserIdLong());
        UserData userData = new UserData();
        userData.setUserId(String.valueOf(this.a.getUserId()));
        userData.setUserName(this.a.getUserName());
        userData.setPortrait(this.a.getPortrait());
        personalChatMessage.setToUserInfo(userData);
        return personalChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean g_() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.c cVar = new com.baidu.tieba.im.message.c();
        cVar.c = 20;
        cVar.a = null;
        cVar.b = null;
        cVar.d = new StringBuilder(String.valueOf(this.a.getUserIdLong())).toString();
        super.sendMessage(new LoadPersonalHistoryMessage(cVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean d() {
        long j;
        long j2 = 0;
        if (this.a != null) {
            com.baidu.tieba.im.message.c cVar = new com.baidu.tieba.im.message.c();
            cVar.c = 20;
            if (this.s == null || this.s.getChatMessages() == null || this.s.getChatMessages().size() <= 0 || this.s.getChatMessages().get(0) == null) {
                j = 0;
            } else {
                j = this.s.getChatMessages().get(0).getMsgId();
                j2 = this.s.getChatMessages().get(0).getRecordId();
            }
            cVar.a = String.valueOf(j);
            cVar.b = String.valueOf(j2);
            cVar.d = new StringBuilder(String.valueOf(this.a.getUserIdLong())).toString();
            super.sendMessage(new LoadPersonalHistoryMessage(cVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean e() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.a aVar = new com.baidu.tieba.im.message.a();
        aVar.a = this.a.getUserId();
        super.sendMessage(new LoadPersonalDraftMessage(aVar));
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
        super.sendMessage(new PersonalSaveDraftMessage(gVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void a(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.i.a(new bp(this, chatMessage), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected void b(ChatMessage chatMessage) {
        if (this.a != null && chatMessage != null) {
            com.baidu.tieba.im.i.a(new bq(this, chatMessage), null);
        }
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ImMessageCenterPojo a(com.baidu.tieba.im.db.e eVar) {
        if (eVar == null || this.a == null) {
            return null;
        }
        return eVar.a(String.valueOf(this.a.getUserId()));
    }

    private void m() {
        MessageManager.getInstance().registerListener(2015001, this.c);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_LOAD_DRAFT_PERSONAL, this.c);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_LOAD_HISTORY_PERSONAL, this.c);
    }

    protected void f() {
        MessageManager.getInstance().unRegisterListener(this.c);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public void a(com.baidu.tieba.im.a<Void> aVar) {
        com.baidu.tieba.im.db.i.a().c(PersonalChatActivity.b);
        aVar.a(null);
        com.baidu.tieba.im.i.a(new br(this), aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage instanceof GroupMsgData) {
            GroupMsgData groupMsgData = (GroupMsgData) customResponsedMessage;
            if (c() != null) {
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                LinkedList linkedList = new LinkedList();
                for (ChatMessage chatMessage : listMessage) {
                    if (chatMessage instanceof PersonalChatMessage) {
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
