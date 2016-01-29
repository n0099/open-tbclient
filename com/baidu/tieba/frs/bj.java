package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bj implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bi bhC;
    private final /* synthetic */ View bhD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(bi biVar, View view) {
        this.bhC = biVar;
        this.bhD = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bhD;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gF() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gG() {
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
