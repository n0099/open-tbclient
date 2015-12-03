package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bd bbf;
    private final /* synthetic */ View bbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, View view) {
        this.bbf = bdVar;
        this.bbg = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bbg;
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
