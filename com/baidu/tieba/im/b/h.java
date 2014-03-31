package com.baidu.tieba.im.b;

import com.baidu.tieba.im.m;
/* loaded from: classes.dex */
final class h extends m<Void> {
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(String str) {
        this.b = str;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* bridge */ /* synthetic */ Void a() {
        com.baidu.tieba.im.db.g.a();
        com.baidu.tieba.im.db.g.a(this.b, false);
        return null;
    }
}
