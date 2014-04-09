package com.baidu.tieba.im.db;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ i b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(i iVar, LinkedList linkedList) {
        this.b = iVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* bridge */ /* synthetic */ Void a() {
        h.a().a(this.c);
        return null;
    }
}
