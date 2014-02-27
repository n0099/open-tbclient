package com.baidu.tieba.im.db;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ l a;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l lVar, LinkedList linkedList) {
        this.a = lVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ Void a() {
        k.a().a(this.c);
        return null;
    }
}
