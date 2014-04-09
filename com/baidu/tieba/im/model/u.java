package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ p b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar) {
        this.b = pVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        com.baidu.tieba.im.pushNotify.a.d().b(false, new v(this.b));
        return null;
    }
}
