package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
        this.c = new m(this, 0);
        l();
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        f();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean a(com.baidu.tieba.im.chat.bv bvVar) {
        if (this.a == null) {
            return false;
        }
        com.baidu.tieba.im.message.c cVar = new com.baidu.tieba.im.message.c();
        cVar.c = 20;
        cVar.a = null;
        cVar.b = null;
        cVar.d = new StringBuilder(String.valueOf(this.a.getGroupId())).toString();
        LoadGroupHistoryMessage loadGroupHistoryMessage = new LoadGroupHistoryMessage(cVar);
        loadGroupHistoryMessage.setCallback(bvVar);
        super.sendMessage(loadGroupHistoryMessage);
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

    private void l() {
        MessageManager.getInstance().registerListener(2013005, this.c);
        MessageManager.getInstance().registerListener(2001146, this.c);
        MessageManager.getInstance().registerListener(2001149, this.c);
    }

    protected void f() {
        MessageManager.getInstance().unRegisterListener(this.c);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage g() {
        GroupChatMessage groupChatMessage = new GroupChatMessage();
        groupChatMessage.setBornTime(System.currentTimeMillis());
        if (c() == null) {
            return null;
        }
        groupChatMessage.setGroupId(String.valueOf(c().getGroupId()));
        return groupChatMessage;
    }
}
