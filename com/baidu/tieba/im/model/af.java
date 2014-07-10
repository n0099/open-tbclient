package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class af extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ad b;
    private final /* synthetic */ PersonalChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(ad adVar, PersonalChatMessage personalChatMessage) {
        this.b = adVar;
        this.c = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.p.d().a(this.c.getUserId(), this.c.getToUserId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), 2));
    }
}
