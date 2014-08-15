package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ac extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x a;
    private final /* synthetic */ OfficialChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar, OfficialChatMessage officialChatMessage) {
        this.a = xVar;
        this.b = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.c().a(this.b.getUserId(), this.b.getToUserId(), String.valueOf(this.b.getRecordId()), String.valueOf(this.b.getMsgId()), 2));
    }
}
