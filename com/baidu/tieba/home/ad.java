package com.baidu.tieba.home;

import com.baidu.tieba.view.ImageViewDrawer;
/* loaded from: classes.dex */
class ad implements com.baidu.tbadk.a.d {
    final /* synthetic */ RecommendPagerAdapter a;
    private final /* synthetic */ ImageViewDrawer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(RecommendPagerAdapter recommendPagerAdapter, ImageViewDrawer imageViewDrawer) {
        this.a = recommendPagerAdapter;
        this.b = imageViewDrawer;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.b.invalidate();
        }
    }
}
