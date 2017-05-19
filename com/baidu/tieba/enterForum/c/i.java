package com.baidu.tieba.enterForum.c;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.adp.lib.guide.b {
    final /* synthetic */ c bHP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.bHP = cVar;
    }

    @Override // com.baidu.adp.lib.guide.b
    public View a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(w.j.drag_to_sort_forum_tip_layout, (ViewGroup) null, false);
    }

    @Override // com.baidu.adp.lib.guide.b
    public int fa() {
        return 4;
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
