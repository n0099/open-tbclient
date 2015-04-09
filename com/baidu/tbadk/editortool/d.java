package com.baidu.tbadk.editortool;

import android.widget.GridView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class d implements com.baidu.adp.lib.e.c<GridView> {
    final /* synthetic */ EmotionTabContentView aiA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(EmotionTabContentView emotionTabContentView) {
        this.aiA = emotionTabContentView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: yB */
    public GridView hA() {
        return new GridView(this.aiA.getContext());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: a */
    public void k(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: b */
    public GridView l(GridView gridView) {
        return gridView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: c */
    public GridView m(GridView gridView) {
        gridView.setAdapter((ListAdapter) null);
        return gridView;
    }
}
