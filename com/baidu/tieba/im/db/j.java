package com.baidu.tieba.im.db;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class j extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ h a;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(h hVar, LinkedList linkedList) {
        this.a = hVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ Void a() {
        return q.a().a(this.c);
    }
}
