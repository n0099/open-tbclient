package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
public abstract class CommonPersonalMsglistView extends AbsMsglistView {
    public CommonPersonalMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initExpression(TalkableActivity talkableActivity) {
        super.initExpression(talkableActivity);
        this.mTool.b(new com.baidu.tbadk.editortools.a(34, 5, 2));
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void setNeedShowName() {
        this.mNeedShowName = false;
    }
}
