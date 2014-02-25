package com.baidu.tieba.im.b;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class j extends com.baidu.tieba.im.c<Void> {
    final /* synthetic */ i a;
    private final /* synthetic */ LinkedHashMap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, LinkedHashMap linkedHashMap) {
        this.a = iVar;
        this.c = linkedHashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        return com.baidu.tieba.im.db.b.a().a(this.c);
    }
}
