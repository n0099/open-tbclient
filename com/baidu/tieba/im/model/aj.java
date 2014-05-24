package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ OfficialChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MsglistModel msglistModel, OfficialChatMessage officialChatMessage) {
        this.a = msglistModel;
        this.b = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.c(this.b);
    }
}
