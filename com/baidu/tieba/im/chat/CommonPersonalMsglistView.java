package com.baidu.tieba.im.chat;
/* loaded from: classes4.dex */
public abstract class CommonPersonalMsglistView extends AbsMsglistView {
    public CommonPersonalMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void setNeedShowName() {
        this.mNeedShowName = false;
    }
}
