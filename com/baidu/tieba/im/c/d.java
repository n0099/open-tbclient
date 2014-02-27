package com.baidu.tieba.im.c;

import java.util.LinkedHashMap;
/* loaded from: classes.dex */
final class d extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ LinkedHashMap a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(LinkedHashMap linkedHashMap) {
        this.a = linkedHashMap;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* bridge */ /* synthetic */ Void a() {
        return com.baidu.tieba.im.db.b.a().a(this.a);
    }
}
