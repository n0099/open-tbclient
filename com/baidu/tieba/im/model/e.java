package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.ChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ CommonGroupMsglistModel b;
    private final /* synthetic */ ChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CommonGroupMsglistModel commonGroupMsglistModel, ChatMessage chatMessage) {
        this.b = commonGroupMsglistModel;
        this.c = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().a(String.valueOf(this.b.a.getGroupId()), String.valueOf(this.c.getMsgId())));
    }
}
