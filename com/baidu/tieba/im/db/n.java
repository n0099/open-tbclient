package com.baidu.tieba.im.db;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n extends com.baidu.tieba.im.c<Void> {
    final /* synthetic */ l a;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, LinkedList linkedList) {
        this.a = lVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        k.a().a(this.c);
        return null;
    }
}
