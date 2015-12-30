package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bh implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bg bfe;
    private final /* synthetic */ View bff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(bg bgVar, View view) {
        this.bfe = bgVar;
        this.bff = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bff;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gx() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gy() {
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
