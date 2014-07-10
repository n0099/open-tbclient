package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dl implements com.baidu.tbadk.img.b<ChatMessage> {
    final /* synthetic */ TalkableActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dl(TalkableActivity talkableActivity) {
        this.a = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.img.b
    public void a(int i, ChatMessage chatMessage) {
        this.a.d.a(i, chatMessage);
    }
}
