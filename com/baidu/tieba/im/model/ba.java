package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ba implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ PersonalChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(MsglistModel msglistModel, PersonalChatMessage personalChatMessage) {
        this.a = msglistModel;
        this.b = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.c(this.b);
    }
}
