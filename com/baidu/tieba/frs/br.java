package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class br implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bq a;
    private final /* synthetic */ View b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar, View view) {
        this.a = bqVar;
        this.b = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.b;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return 0;
    }
}
