package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class ag extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ae b;
    private final /* synthetic */ PersonalChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar, PersonalChatMessage personalChatMessage) {
        this.b = aeVar;
        this.c = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.d().a(this.c.getUserId(), this.c.getToUserId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), 2));
    }
}
