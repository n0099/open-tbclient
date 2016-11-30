package com.baidu.tieba.im.chat;

import com.baidu.tbadk.img.a;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bv implements a.InterfaceC0045a<ChatMessage> {
    final /* synthetic */ TalkableActivity dbD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(TalkableActivity talkableActivity) {
        this.dbD = talkableActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.img.a.InterfaceC0045a
    /* renamed from: a */
    public void b(int i, ChatMessage chatMessage) {
        this.dbD.dbp.updateAdapter(i, chatMessage);
    }
}
