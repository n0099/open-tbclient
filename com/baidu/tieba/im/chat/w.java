package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.bp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(q qVar, com.baidu.tieba.im.message.bp bpVar) {
        this.a = qVar;
        this.c = bpVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().b(this.c.c(), String.valueOf(this.c.b()), String.valueOf(this.c.a()), 3));
    }
}
