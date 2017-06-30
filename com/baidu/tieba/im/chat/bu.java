package com.baidu.tieba.im.chat;

import com.baidu.tbadk.img.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bu implements a.InterfaceC0048a<ChatMessage> {
    final /* synthetic */ TalkableActivity cYu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(TalkableActivity talkableActivity) {
        this.cYu = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.img.a.InterfaceC0048a
    /* renamed from: a */
    public void b(int i, ChatMessage chatMessage) {
        this.cYu.cYg.updateAdapter(i, chatMessage);
    }
}
