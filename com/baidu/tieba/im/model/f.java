package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class f extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ CommonGroupMsglistModel a;
    private final /* synthetic */ ChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(CommonGroupMsglistModel commonGroupMsglistModel, ChatMessage chatMessage) {
        this.a = commonGroupMsglistModel;
        this.b = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().a(String.valueOf(this.a.a.getGroupId()), String.valueOf(this.b.getMsgId())));
    }
}
