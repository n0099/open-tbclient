package com.baidu.tieba.im.chat;

import com.baidu.tbadk.img.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bs implements a.InterfaceC0050a<ChatMessage> {
    final /* synthetic */ TalkableActivity boV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(TalkableActivity talkableActivity) {
        this.boV = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.img.a.InterfaceC0050a
    /* renamed from: a */
    public void b(int i, ChatMessage chatMessage) {
        this.boV.mListView.updateAdapter(i, chatMessage);
    }
}
