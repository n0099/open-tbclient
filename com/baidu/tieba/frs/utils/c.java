package com.baidu.tieba.frs.utils;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b bNK;
    private final /* synthetic */ View bNL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.bNK = bVar;
        this.bNL = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bNL;
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
