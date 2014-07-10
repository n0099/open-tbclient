package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ag extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ad b;
    private final /* synthetic */ OfficialChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ad adVar, OfficialChatMessage officialChatMessage) {
        this.b = adVar;
        this.c = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.d().a(this.c.getUserId(), this.c.getToUserId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), 2));
    }
}
