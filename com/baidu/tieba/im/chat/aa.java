package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x a;
    private final /* synthetic */ PersonalChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, PersonalChatMessage personalChatMessage) {
        this.a = xVar;
        this.b = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.c().a(this.b.getUserId(), this.b.getToUserId(), String.valueOf(this.b.getRecordId()), String.valueOf(this.b.getMsgId()), 2));
    }
}
