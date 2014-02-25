package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae extends com.baidu.tieba.im.c<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.g c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(q qVar, com.baidu.tieba.im.message.g gVar, LinkedList linkedList) {
        this.a = qVar;
        this.c = gVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Boolean b() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().a(this.c.u(), this.d, false));
    }
}
