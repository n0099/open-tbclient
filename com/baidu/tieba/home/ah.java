package com.baidu.tieba.home;

import com.baidu.tieba.view.ImageViewDrawer;
/* loaded from: classes.dex */
class ah implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RecommendPagerAdapter f896a;
    private final /* synthetic */ ImageViewDrawer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(RecommendPagerAdapter recommendPagerAdapter, ImageViewDrawer imageViewDrawer) {
        this.f896a = recommendPagerAdapter;
        this.b = imageViewDrawer;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.b.invalidate();
        }
    }
}
