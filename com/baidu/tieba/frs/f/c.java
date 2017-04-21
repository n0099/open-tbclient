package com.baidu.tieba.frs.f;

import android.view.LayoutInflater;
import android.view.View;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b ccc;
    private final /* synthetic */ View ccd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, View view) {
        this.ccc = bVar;
        this.ccd = view;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return this.ccd;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return 5;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fb() {
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
