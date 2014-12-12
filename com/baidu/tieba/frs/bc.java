package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class bc implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bb aDt;
    private final /* synthetic */ View aDu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, View view) {
        this.aDt = bbVar;
        this.aDu = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aDu;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dx() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
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
