package com.baidu.tieba.im.model;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ OfficialChatMessage b;
    private final /* synthetic */ String c;
    private final /* synthetic */ com.baidu.tbadk.img.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(MsglistModel msglistModel, OfficialChatMessage officialChatMessage, String str, com.baidu.tbadk.img.b bVar) {
        this.a = msglistModel;
        this.b = officialChatMessage;
        this.c = str;
        this.d = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a(this.b, this.c, this.d);
    }
}
