package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cv implements com.baidu.tbadk.img.b<ChatMessage> {
    final /* synthetic */ TalkableActivity aRW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(TalkableActivity talkableActivity) {
        this.aRW = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.img.b
    public void a(int i, ChatMessage chatMessage) {
        this.aRW.mListView.updateAdapter(i, chatMessage);
    }
}
