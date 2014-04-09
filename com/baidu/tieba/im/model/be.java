package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class be extends com.baidu.tieba.im.m<Void> {
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(String str) {
        this.b = str;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        String c = com.baidu.tieba.im.db.h.c(this.b);
        com.baidu.tieba.im.db.h.a();
        com.baidu.tieba.im.db.h.a(c, true);
        return null;
    }
}
