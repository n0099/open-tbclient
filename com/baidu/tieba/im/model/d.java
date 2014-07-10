package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class d extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ CommonGroupMsglistModel b;
    private final /* synthetic */ ChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CommonGroupMsglistModel commonGroupMsglistModel, ChatMessage chatMessage) {
        this.b = commonGroupMsglistModel;
        this.c = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().b(String.valueOf(this.b.a.getGroupId()), String.valueOf(this.c.getMsgId())));
    }
}
