package com.baidu.tieba.im.db;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.tieba.im.c<Void> {
    final /* synthetic */ h a;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, LinkedList linkedList) {
        this.a = hVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        return q.a().a(this.c);
    }
}
