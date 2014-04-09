package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class s extends com.baidu.tieba.im.m<Void> {
    final /* synthetic */ p b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(p pVar, boolean z, String str) {
        this.b = pVar;
        this.c = z;
        this.d = str;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        String c = this.c ? com.baidu.tieba.im.db.h.c(this.d) : this.d;
        com.baidu.tieba.im.db.h.a();
        com.baidu.tieba.im.db.h.a(c, true);
        return null;
    }
}
