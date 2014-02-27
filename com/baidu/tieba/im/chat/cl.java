package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* loaded from: classes.dex */
final class cl extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ ck a;
    private final /* synthetic */ LinkedList c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar, LinkedList linkedList) {
        this.a = ckVar;
        this.c = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ Void a() {
        return com.baidu.tieba.im.db.q.a().a(this.c);
    }
}
