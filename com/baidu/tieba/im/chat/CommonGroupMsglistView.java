package com.baidu.tieba.im.chat;

import com.baidu.tbadk.editortools.v;
/* loaded from: classes.dex */
public class CommonGroupMsglistView extends AbsMsglistView {
    public CommonGroupMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initExpression(TalkableActivity talkableActivity) {
        super.initExpression(talkableActivity);
        v dL = this.mTool.dL(5);
        if (dL != null && (dL.aox instanceof com.baidu.tbadk.editortools.emotiontool.j)) {
            ((com.baidu.tbadk.editortools.emotiontool.j) dL.aox).setFrom(3);
        }
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
