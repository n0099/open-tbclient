package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
class d extends com.baidu.tieba.im.c<Void> {
    private final /* synthetic */ LinkedHashMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LinkedHashMap linkedHashMap) {
        this.a = linkedHashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.c
    /* renamed from: a */
    public Void b() {
        return com.baidu.tieba.im.db.b.a().a(this.a);
    }
}
