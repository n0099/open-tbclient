package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w a;
    private final /* synthetic */ PersonalChatMessage b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(w wVar, PersonalChatMessage personalChatMessage, LinkedList linkedList) {
        this.a = wVar;
        this.b = personalChatMessage;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.c().a(com.baidu.tieba.im.d.j.a(this.b), this.c, false));
    }
}
