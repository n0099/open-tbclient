package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dp implements com.baidu.tbadk.img.b<ChatMessage> {
    final /* synthetic */ TalkableActivity aQq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dp(TalkableActivity talkableActivity) {
        this.aQq = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.img.b
    public void a(int i, ChatMessage chatMessage) {
        this.aQq.aQd.updateAdapter(i, chatMessage);
    }
}
