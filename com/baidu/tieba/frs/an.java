package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class an implements com.baidu.adp.lib.guide.b {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ View f1370a;
    final /* synthetic */ am b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar, View view) {
        this.b = amVar;
        this.f1370a = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.f1370a;
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
