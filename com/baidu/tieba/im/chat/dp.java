package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ TalkableActivity a;

    private dp(TalkableActivity talkableActivity) {
        this.a = talkableActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ dp(TalkableActivity talkableActivity, dp dpVar) {
        this(talkableActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.i().b(false, (com.baidu.tieba.im.a<Void>) null);
    }
}
