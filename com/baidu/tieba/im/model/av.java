package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class av extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ as b;
    private final /* synthetic */ OfficialChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(as asVar, OfficialChatMessage officialChatMessage) {
        this.b = asVar;
        this.c = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.d().a(this.c.getUserId(), this.c.getToUserId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), 2));
    }
}
