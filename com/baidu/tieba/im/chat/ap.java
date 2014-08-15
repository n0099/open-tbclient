package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ap extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ak a;
    private final /* synthetic */ OfficialChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ak akVar, OfficialChatMessage officialChatMessage) {
        this.a = akVar;
        this.b = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.c().a(this.b.getUserId(), this.b.getToUserId(), String.valueOf(this.b.getRecordId()), String.valueOf(this.b.getMsgId()), 2));
    }
}
