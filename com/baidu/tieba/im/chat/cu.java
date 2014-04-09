package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
final class cu extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ ct b;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cu(ct ctVar, LinkedList linkedList) {
        this.b = ctVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        return com.baidu.tieba.im.db.o.d().a(this.c);
    }
}
