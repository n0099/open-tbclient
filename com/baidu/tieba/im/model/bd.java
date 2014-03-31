package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class bd extends com.baidu.tieba.im.m<Void> {
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(String str) {
        this.b = str;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        String c = com.baidu.tieba.im.db.g.c(this.b);
        com.baidu.tieba.im.db.g.a();
        com.baidu.tieba.im.db.g.a(c, true);
        return null;
    }
}
