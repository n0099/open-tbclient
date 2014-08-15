package com.baidu.tieba.game;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
class s implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(n nVar) {
        this.a = nVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(com.baidu.tieba.v.game_center_tip_view, (ViewGroup) null, false);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int a() {
        return 4;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int b() {
        return 32;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int c() {
        return 0;
    }

    @Override // com.baidu.adp.lib.guide.b
    public int d() {
        return 0;
    }
}
