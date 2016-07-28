package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
import com.baidu.adp.lib.guide.b;
/* loaded from: classes.dex */
class bc implements b {
    final /* synthetic */ bb bFc;
    private final /* synthetic */ View bFd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar, View view) {
        this.bFc = bbVar;
        this.bFd = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bFd;
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
