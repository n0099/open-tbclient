package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.adp.lib.guide.b;
/* loaded from: classes.dex */
class bc implements b {
    private final /* synthetic */ View bQA;
    final /* synthetic */ bb bQz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, View view) {
        this.bQz = bbVar;
        this.bQA = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bQA;
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
