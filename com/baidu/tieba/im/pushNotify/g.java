package com.baidu.tieba.im.pushNotify;

import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends com.baidu.tieba.im.m<Void> {
    private final /* synthetic */ LinkedHashMap b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(LinkedHashMap linkedHashMap) {
        this.b = linkedHashMap;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* bridge */ /* synthetic */ Void a() {
        return com.baidu.tieba.im.db.c.a().a(this.b);
    }
}
