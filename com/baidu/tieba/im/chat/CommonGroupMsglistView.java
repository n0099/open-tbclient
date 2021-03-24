package com.baidu.tieba.im.chat;
/* loaded from: classes4.dex */
public class CommonGroupMsglistView extends AbsMsglistView {
    public CommonGroupMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public boolean isPersonal() {
        return false;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void setNeedShowName() {
        this.mNeedShowName = true;
    }
}
