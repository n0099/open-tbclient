package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class ae extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ad b;
    private final /* synthetic */ CommonGroupChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ad adVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.b = adVar;
        this.c = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().b(this.c.getGroupId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), 2));
    }
}
