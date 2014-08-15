package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x a;
    private final /* synthetic */ CommonGroupChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.a = xVar;
        this.b = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().b(this.b.getGroupId(), String.valueOf(this.b.getRecordId()), String.valueOf(this.b.getMsgId()), 2));
    }
}
