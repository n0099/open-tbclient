package com.baidu.tieba.im.chat.officialBar;

import java.util.LinkedList;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ q a;
    private final /* synthetic */ LinkedList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar, LinkedList linkedList) {
        this.a = qVar;
        this.b = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        return com.baidu.tieba.im.db.n.c().a(this.b);
    }
}
