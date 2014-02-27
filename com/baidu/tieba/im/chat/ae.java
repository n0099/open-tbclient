package com.baidu.tieba.im.chat;

import java.util.LinkedList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.g c;
    private final /* synthetic */ LinkedList d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(q qVar, com.baidu.tieba.im.message.g gVar, LinkedList linkedList) {
        this.a = qVar;
        this.c = gVar;
        this.d = linkedList;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().a(this.c.u(), this.d, false));
    }
}
