package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements com.baidu.tbadk.img.b<ChatMessage> {
    final /* synthetic */ TalkableActivity aTf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(TalkableActivity talkableActivity) {
        this.aTf = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.img.b
    public void a(int i, ChatMessage chatMessage) {
        this.aTf.mListView.updateAdapter(i, chatMessage);
    }
}
