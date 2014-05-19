package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class bq extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ PersonalMsglistModel b;
    private final /* synthetic */ ChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(PersonalMsglistModel personalMsglistModel, ChatMessage chatMessage) {
        this.b = personalMsglistModel;
        this.c = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.d().a(String.valueOf(this.b.a.getUserId()), String.valueOf(this.c.getMsgId())));
    }
}
