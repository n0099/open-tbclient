package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aw implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ av aVV;
    private final /* synthetic */ View aVW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(av avVar, View view) {
        this.aVV = avVar;
        this.aVW = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aVW;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gz() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gA() {
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
