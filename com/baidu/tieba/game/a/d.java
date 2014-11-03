package com.baidu.tieba.game.a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ b aKp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.aKp = bVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(w.game_center_tip_view, (ViewGroup) null, false);
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
