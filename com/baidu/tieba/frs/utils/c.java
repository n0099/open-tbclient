package com.baidu.tieba.frs.utils;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b ciD;
    private final /* synthetic */ View ciE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.ciD = bVar;
        this.ciE = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.ciE;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dO() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dP() {
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
