package com.baidu.tieba.emotion.editortool;

import android.widget.GridView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class j implements com.baidu.adp.lib.e.c<GridView> {
    final /* synthetic */ EmotionTabContentView bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(EmotionTabContentView emotionTabContentView) {
        this.bKT = emotionTabContentView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: WC */
    public GridView fL() {
        return new GridView(this.bKT.getContext());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void o(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public GridView p(GridView gridView) {
        return gridView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public GridView q(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
        return gridView;
    }
}
