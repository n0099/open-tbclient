package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class bb implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ ba aEu;
    private final /* synthetic */ View aEv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar, View view) {
        this.aEu = baVar;
        this.aEv = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aEv;
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
