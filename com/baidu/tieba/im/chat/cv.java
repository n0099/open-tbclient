package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class cv extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ cu a;
    private final /* synthetic */ LinkedList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cv(cu cuVar, LinkedList linkedList) {
        this.a = cuVar;
        this.b = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        return com.baidu.tieba.im.db.o.c().a(this.b);
    }
}
