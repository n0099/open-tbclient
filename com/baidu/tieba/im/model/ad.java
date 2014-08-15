package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ CommonGroupChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(MsglistModel msglistModel, CommonGroupChatMessage commonGroupChatMessage) {
        this.a = msglistModel;
        this.b = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.d(this.b);
    }
}
