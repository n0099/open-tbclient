package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.adp.lib.guide.b;
/* loaded from: classes.dex */
class bk implements b {
    final /* synthetic */ bj bhL;
    private final /* synthetic */ View bhM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(bj bjVar, View view) {
        this.bhL = bjVar;
        this.bhM = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bhM;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cT() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int cU() {
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
