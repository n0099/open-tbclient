package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class as extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ ar b;
    private final /* synthetic */ CommonGroupChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ar arVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.b = arVar;
        this.c = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().b(this.c.getGroupId(), String.valueOf(this.c.getRecordId()), String.valueOf(this.c.getMsgId()), 2));
    }
}
