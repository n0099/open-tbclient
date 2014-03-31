package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
final class bk implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bj a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar, View view) {
        this.a = bjVar;
        this.b = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final View a(LayoutInflater layoutInflater) {
        return this.b;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int a() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int b() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int c() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public final int d() {
        return 0;
    }
}
