package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ ao aME;
    private final /* synthetic */ View aMF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, View view) {
        this.aME = aoVar;
        this.aMF = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aMF;
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
