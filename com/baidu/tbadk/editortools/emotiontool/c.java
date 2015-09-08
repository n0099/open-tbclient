package com.baidu.tbadk.editortools.emotiontool;

import android.widget.GridView;
import android.widget.ListAdapter;
/* loaded from: classes.dex */
class c implements com.baidu.adp.lib.e.c<GridView> {
    final /* synthetic */ EmotionTabContentView art;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(EmotionTabContentView emotionTabContentView) {
        this.art = emotionTabContentView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.lib.e.c
    /* renamed from: AY */
    public GridView gY() {
        return new GridView(this.art.getContext());
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
