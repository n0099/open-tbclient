package com.baidu.tieba.emotion.editortool;

import android.widget.GridView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class i implements com.baidu.adp.lib.f.c<GridView> {
    final /* synthetic */ EmotionTabContentView bnU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(EmotionTabContentView emotionTabContentView) {
        this.bnU = emotionTabContentView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: Sl */
    public GridView ez() {
        return new GridView(this.bnU.getContext());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: a */
    public void o(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: b */
    public GridView p(GridView gridView) {
        return gridView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.f.c
    /* renamed from: c */
    public GridView q(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
        return gridView;
    }
}
