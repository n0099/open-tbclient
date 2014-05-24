package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class cq extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ cp b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(cp cpVar, LinkedList linkedList) {
        this.b = cpVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        return com.baidu.tieba.im.db.o.d().a(this.c);
    }
}
