package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.adp.lib.guide.b;
/* loaded from: classes.dex */
class bc implements b {
    final /* synthetic */ bb bDS;
    private final /* synthetic */ View bDT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, View view) {
        this.bDS = bbVar;
        this.bDT = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bDT;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cV() {
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
