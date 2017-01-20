package com.baidu.tieba.frs.utils;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b bTY;
    private final /* synthetic */ View bTZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.bTY = bVar;
        this.bTZ = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bTZ;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dM() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dN() {
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
