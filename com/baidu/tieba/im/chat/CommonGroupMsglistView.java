package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
public class CommonGroupMsglistView extends g {
    public CommonGroupMsglistView(MsglistActivity msglistActivity, boolean z) {
        super(msglistActivity, z);
    }

    @Override // com.baidu.tieba.im.chat.g
    protected void a(TalkableActivity talkableActivity) {
        super.a(talkableActivity);
        this.e.setFrom(3);
    }

    @Override // com.baidu.tieba.im.chat.g
    protected void d() {
        this.i = true;
    }
}
