package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w a;
    private final /* synthetic */ OfficialChatMessage b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(w wVar, OfficialChatMessage officialChatMessage, LinkedList linkedList) {
        this.a = wVar;
        this.b = officialChatMessage;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.c().a(com.baidu.tieba.im.d.j.a(this.b), this.c, false));
    }
}
