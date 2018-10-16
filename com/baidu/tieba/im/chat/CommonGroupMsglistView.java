package com.baidu.tieba.im.chat;
/* loaded from: classes6.dex */
public class CommonGroupMsglistView extends AbsMsglistView {
    public CommonGroupMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void setNeedShowName() {
        this.mNeedShowName = true;
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return false;
    }
}
