package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
class ct extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ cs b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(cs csVar, LinkedList linkedList) {
        this.b = csVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        return com.baidu.tieba.im.db.p.d().a(this.c);
    }
}
