package com.baidu.tieba.emotion.editortool;

import android.widget.GridView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class i implements com.baidu.adp.lib.f.c<GridView> {
    final /* synthetic */ EmotionTabContentView aUR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView) {
        this.aUR = emotionTabContentView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Ll */
    public GridView hk() {
        return new GridView(this.aUR.getContext());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void l(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public GridView m(GridView gridView) {
        return gridView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public GridView n(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
        return gridView;
    }
}
