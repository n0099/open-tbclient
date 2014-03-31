package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ab extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ x b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.f c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, com.baidu.tieba.im.message.a.f fVar, LinkedList linkedList) {
        this.b = xVar;
        this.c = fVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.d().a(this.c.x(), this.c.l(), this.d, false));
    }
}
