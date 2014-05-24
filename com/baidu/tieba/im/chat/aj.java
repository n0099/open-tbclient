package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w b;
    private final /* synthetic */ OfficialChatMessage c;
    private final /* synthetic */ ChatMessage d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.b = wVar;
        this.c = officialChatMessage;
        this.d = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.d().a(this.c.getUserId(), this.c.getToUserId(), String.valueOf(this.d.getRecordId()), String.valueOf(this.d.getMsgId()), 2));
    }
}
