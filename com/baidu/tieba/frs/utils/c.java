package com.baidu.tieba.frs.utils;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b cbk;
    private final /* synthetic */ View cbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.cbk = bVar;
        this.cbl = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.cbl;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int eU() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int eV() {
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
