package com.baidu.tieba.im.f;
/* loaded from: classes.dex */
final class n extends com.baidu.tieba.im.m<Void> {
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Void a() {
        com.baidu.tieba.im.db.h.a();
        com.baidu.tieba.im.db.h.b(this.b, this.c);
        return null;
    }
}
