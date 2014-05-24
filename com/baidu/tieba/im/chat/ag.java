package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w b;
    private final /* synthetic */ PersonalChatMessage c;
    private final /* synthetic */ ChatMessage d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(w wVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.b = wVar;
        this.c = personalChatMessage;
        this.d = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.d().a(this.c.getUserId(), this.c.getToUserId(), String.valueOf(this.d.getRecordId()), String.valueOf(this.d.getMsgId()), 2));
    }
}
