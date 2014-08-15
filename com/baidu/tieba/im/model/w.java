package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ CommonGroupChatMessage b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MsglistModel msglistModel, CommonGroupChatMessage commonGroupChatMessage, String str) {
        this.a = msglistModel;
        this.b = commonGroupChatMessage;
        this.c = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a(this.b, this.c);
    }
}
