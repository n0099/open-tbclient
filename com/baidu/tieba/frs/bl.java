package com.baidu.tieba.frs;

import android.view.LayoutInflater;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bl implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ bk bmo;
    private final /* synthetic */ View bmq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(bk bkVar, View view) {
        this.bmo = bkVar;
        this.bmq = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bmq;
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
