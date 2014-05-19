package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class bg extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ OfficialBarMsglistModel b;
    private final /* synthetic */ ChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(OfficialBarMsglistModel officialBarMsglistModel, ChatMessage chatMessage) {
        this.b = officialBarMsglistModel;
        this.c = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.d().b(String.valueOf(this.b.a.getUserId()), String.valueOf(this.c.getMsgId())));
    }
}
