package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class av extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ PersonalMsglistModel a;
    private final /* synthetic */ ChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.a = personalMsglistModel;
        this.b = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.c().a(String.valueOf(this.a.a.getUserId()), String.valueOf(this.b.getMsgId())));
    }
}
