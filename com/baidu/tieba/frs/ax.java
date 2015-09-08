package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ax implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ aw aWm;
    private final /* synthetic */ View aWn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(aw awVar, View view) {
        this.aWm = awVar;
        this.aWn = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aWn;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gw() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int gx() {
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
