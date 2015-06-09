package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ ao aMF;
    private final /* synthetic */ View aMG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, View view) {
        this.aMF = aoVar;
        this.aMG = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aMG;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gE() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gF() {
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
