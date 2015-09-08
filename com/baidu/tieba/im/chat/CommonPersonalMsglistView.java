package com.baidu.tieba.im.chat;

import com.baidu.tbadk.editortools.v;
/* loaded from: classes.dex */
public abstract class CommonPersonalMsglistView extends AbsMsglistView {
    public CommonPersonalMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initExpression(TalkableActivity talkableActivity) {
        super.initExpression(talkableActivity);
        v dT = this.mTool.dT(5);
        if (dT != null && (dT.aqi instanceof com.baidu.tbadk.editortools.emotiontool.j)) {
            ((com.baidu.tbadk.editortools.emotiontool.j) dT.aqi).setFrom(2);
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected void setNeedShowName() {
        this.mNeedShowName = false;
    }
}
