package com.baidu.tieba.emotion.editortool;

import android.widget.GridView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class h implements com.baidu.adp.lib.e.c<GridView> {
    final /* synthetic */ EmotionTabContentView aKv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(EmotionTabContentView emotionTabContentView) {
        this.aKv = emotionTabContentView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: HN */
    public GridView ha() {
        return new GridView(this.aKv.getContext());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void l(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public GridView m(GridView gridView) {
        return gridView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public GridView n(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
        return gridView;
    }
}
