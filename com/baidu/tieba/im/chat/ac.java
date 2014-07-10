package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w b;
    private final /* synthetic */ OfficialChatMessage c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(w wVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.b = wVar;
        this.c = officialChatMessage;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.d().a(this.c.getUserId(), this.c.getToUserId(), this.d, false));
    }
}
