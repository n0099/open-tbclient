package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.bt;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.SnapChatMessage;
/* loaded from: classes.dex */
public class SnapGroupMsglistModel extends CommonGroupMsglistModel {
    private CustomMessageListener b;

    public SnapGroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.b = new ba(this, 0);
        f();
        this.v = 3;
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        m();
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected ChatMessage g() {
        SnapChatMessage snapChatMessage = new SnapChatMessage();
        snapChatMessage.setBornTime(System.currentTimeMillis());
        if (c() == null) {
            return null;
        }
        snapChatMessage.setGroupId(String.valueOf(c().getGroupId()));
        return snapChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean a(bt btVar) {
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean d() {
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean e() {
        return true;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean a(String str) {
        return true;
    }

    private void f() {
        MessageManager.getInstance().registerListener(2013002, this.b);
    }

    private void m() {
        MessageManager.getInstance().unRegisterListener(this.b);
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    protected aj h() {
        if (this.a == null) {
            return null;
        }
        aj ajVar = new aj();
        ajVar.b = 3;
        ajVar.a = String.valueOf(this.a.getGroupId());
        return ajVar;
    }
}
