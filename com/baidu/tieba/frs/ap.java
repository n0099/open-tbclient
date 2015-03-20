package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ ao aKn;
    private final /* synthetic */ View aKo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ao aoVar, View view) {
        this.aKn = aoVar;
        this.aKo = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aKo;
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
