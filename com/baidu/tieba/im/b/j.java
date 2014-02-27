package com.baidu.tieba.im.b;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
final class j extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ i a;
    private final /* synthetic */ LinkedHashMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, LinkedHashMap linkedHashMap) {
        this.a = iVar;
        this.c = linkedHashMap;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ Void a() {
        return com.baidu.tieba.im.db.b.a().a(this.c);
    }
}
