package com.baidu.tieba.im.model;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.SnapChatMessage;
/* loaded from: classes.dex */
public class SnapGroupMsglistModel extends CommonGroupMsglistModel {
    private CustomMessageListener b;

    public SnapGroupMsglistModel(MsglistActivity msglistActivity) {
        super(msglistActivity);
        this.b = new bx(this, 0);
        f();
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
        if (b() == null) {
            return null;
        }
        snapChatMessage.setGroupId(String.valueOf(b().getGroupId()));
        return snapChatMessage;
    }

    @Override // com.baidu.tieba.im.model.MsglistModel
    public boolean g_() {
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
        MessageManager.getInstance().registerListener(2015002, this.b);
    }

    private void m() {
        MessageManager.getInstance().unRegisterListener(this.b);
    }
}
