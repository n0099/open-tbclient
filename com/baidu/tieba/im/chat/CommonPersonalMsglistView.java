package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
public class CommonPersonalMsglistView extends g {
    public CommonPersonalMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.g
    public void a(TalkableActivity talkableActivity) {
        super.a(talkableActivity);
        this.e.setFrom(2);
    }

    @Override // com.baidu.tieba.im.chat.g
    protected void d() {
        this.i = false;
    }
}
