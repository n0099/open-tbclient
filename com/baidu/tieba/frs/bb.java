package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class bb implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ ba aEr;
    private final /* synthetic */ View aEs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, View view) {
        this.aEr = baVar;
        this.aEs = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aEs;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dv() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dw() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getXOffset() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int getYOffset() {
        return 0;
    }
}
