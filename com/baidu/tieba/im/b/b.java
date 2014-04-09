package com.baidu.tieba.im.b;

import com.baidu.tieba.im.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b extends m<Void> {
    final /* synthetic */ a b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, String str) {
        this.b = aVar;
        this.c = str;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* bridge */ /* synthetic */ Void a() {
        com.baidu.tieba.im.db.h.a();
        com.baidu.tieba.im.db.h.a(this.c, false);
        return null;
    }
}
