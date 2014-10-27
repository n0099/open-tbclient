package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
public class CommonGroupMsglistView extends AbsMsglistView {
    public CommonGroupMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initExpression(TalkableActivity talkableActivity) {
        super.initExpression(talkableActivity);
        this.mFaceView.setFrom(3);
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
