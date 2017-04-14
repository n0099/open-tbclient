package com.baidu.tieba.frs.f;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b bZL;
    private final /* synthetic */ View bZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.bZL = bVar;
        this.bZM = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.bZM;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int eZ() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
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
