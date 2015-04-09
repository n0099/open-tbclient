package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ ao aKx;
    private final /* synthetic */ View aKy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, View view) {
        this.aKx = aoVar;
        this.aKy = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aKy;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gT() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gU() {
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
