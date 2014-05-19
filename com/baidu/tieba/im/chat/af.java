package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x b;
    private final /* synthetic */ CommonGroupChatMessage c;
    private final /* synthetic */ ChatMessage d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(x xVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.b = xVar;
        this.c = commonGroupChatMessage;
        this.d = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().b(this.c.getGroupId(), String.valueOf(this.d.getRecordId()), String.valueOf(this.d.getMsgId()), 2));
    }
}
