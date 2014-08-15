package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class cu extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ ct a;
    private final /* synthetic */ LinkedList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ct ctVar, LinkedList linkedList) {
        this.a = ctVar;
        this.b = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        return com.baidu.tieba.im.db.o.c().a(this.b);
    }
}
