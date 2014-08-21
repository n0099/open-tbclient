package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
public class CommonGroupMsglistView extends g {
    public CommonGroupMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.g
    public void a(TalkableActivity talkableActivity) {
        super.a(talkableActivity);
        this.e.setFrom(3);
    }

    @Override // com.baidu.tieba.im.chat.g
    protected void d() {
        this.j = true;
    }
}
