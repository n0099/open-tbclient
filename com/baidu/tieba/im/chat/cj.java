package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cj implements com.baidu.tbadk.img.b<ChatMessage> {
    final /* synthetic */ TalkableActivity aYt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(TalkableActivity talkableActivity) {
        this.aYt = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.img.b
    public void a(int i, ChatMessage chatMessage) {
        this.aYt.mListView.updateAdapter(i, chatMessage);
    }
}
