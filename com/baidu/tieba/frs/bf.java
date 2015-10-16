package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ be aVI;
    private final /* synthetic */ View aVJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(be beVar, View view) {
        this.aVI = beVar;
        this.aVJ = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.aVJ;
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
