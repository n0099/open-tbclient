package com.baidu.tieba.game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class aa implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ y aHS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.aHS = yVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.w.game_center_tip_view, (ViewGroup) null, false);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dy() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int dz() {
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
