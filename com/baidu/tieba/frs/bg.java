package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class bg implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bf aBH;
    private final /* synthetic */ View aBI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar, View view) {
        this.aBH = bfVar;
        this.aBI = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aBI;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dz() {
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
