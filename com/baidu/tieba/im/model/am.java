package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class am implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ PersonalChatMessage b;
    private final /* synthetic */ String c;
    private final /* synthetic */ com.baidu.tbadk.img.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(MsglistModel msglistModel, PersonalChatMessage personalChatMessage, String str, com.baidu.tbadk.img.b bVar) {
        this.a = msglistModel;
        this.b = personalChatMessage;
        this.c = str;
        this.d = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a(this.b, this.c, this.d);
    }
}
