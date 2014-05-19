package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.frameworkData.MessageTypes;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.GroupSaveDraftMessage;
import com.baidu.tieba.im.message.LoadGroupDraftMessage;
import com.baidu.tieba.im.message.LoadGroupHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.GroupChatMessage;
/* loaded from: classes.dex */
public class GroupMsglistModel extends CommonGroupMsglistModel {
    private final int b;
    private CustomMessageListener c;

    public GroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.b = 20;
        this.c = new o(this, 0);
        m();
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        f();
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
        cVar.d = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
        super.sendMessage(new LoadGroupHistoryMessage(cVar));
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
            cVar.d = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
            super.sendMessage(new LoadGroupHistoryMessage(cVar));
        }
        return false;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean e() {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.a aVar = new com.baidu.tieba.im.message.a();
        aVar.a = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
        super.sendMessage(new LoadGroupDraftMessage(aVar));
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean a(String str) {
        com.baidu.tieba.im.message.g gVar = new com.baidu.tieba.im.message.g();
        if (this.a == null || this.a.getGroupId() == 0) {
            return false;
        }
        gVar.b = String.valueOf(this.a.getGroupId());
        gVar.a = str;
        super.sendMessage(new GroupSaveDraftMessage(gVar));
        return true;
    }

    private void m() {
        MessageManager.getInstance().registerListener(2015005, this.c);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_LOAD_DRAFT_GROUP, this.c);
        MessageManager.getInstance().registerListener(MessageTypes.CMD_LOAD_HISTORY_GROUP, this.c);
    }

    protected void f() {
        MessageManager.getInstance().unRegisterListener(this.c);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage g() {
        GroupChatMessage groupChatMessage = new GroupChatMessage();
        groupChatMessage.setBornTime(System.currentTimeMillis());
        if (b() == null) {
            return null;
        }
        groupChatMessage.setGroupId(String.valueOf(b().getGroupId()));
        return groupChatMessage;
    }
}
