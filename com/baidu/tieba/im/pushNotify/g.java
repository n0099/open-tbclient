package com.baidu.tieba.im.pushNotify;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ LinkedHashMap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LinkedHashMap linkedHashMap) {
        this.b = linkedHashMap;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        return com.baidu.tieba.im.db.c.a().a(this.b);
    }
}
