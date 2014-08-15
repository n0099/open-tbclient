package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class ap extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ OfficialBarMsglistModel a;
    private final /* synthetic */ ChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(OfficialBarMsglistModel officialBarMsglistModel, ChatMessage chatMessage) {
        this.a = officialBarMsglistModel;
        this.b = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.c().b(String.valueOf(this.a.a.getUserId()), String.valueOf(this.b.getMsgId())));
    }
}
