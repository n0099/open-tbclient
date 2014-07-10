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
        this.b = new bw(this, 0);
        f();
    }

    @Override // com.baidu.tieba.im.model.CommonGroupMsglistModel, com.baidu.tieba.im.model.MsglistModel
    public void a() {
        super.a();
        l();
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
    public boolean a(com.baidu.tieba.im.chat.bv bvVar) {
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

    private void l() {
        MessageManager.getInstance().unRegisterListener(this.b);
    }
}
