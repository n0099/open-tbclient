package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class cm extends com.baidu.tieba.im.c<Void> {
    final /* synthetic */ cl a;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cm(cl clVar, LinkedList linkedList) {
        this.a = clVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        return com.baidu.tieba.im.db.q.a().a(this.c);
    }
}
