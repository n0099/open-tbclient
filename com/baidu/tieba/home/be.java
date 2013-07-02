package com.baidu.tieba.home;

import com.baidu.tieba.view.ADImageViewDrawer;
/* loaded from: classes.dex */
class be implements com.baidu.tbadk.a.d {
    final /* synthetic */ TopicPagerAdapter a;
    private final /* synthetic */ ADImageViewDrawer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(TopicPagerAdapter topicPagerAdapter, ADImageViewDrawer aDImageViewDrawer) {
        this.a = topicPagerAdapter;
        this.b = aDImageViewDrawer;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null) {
            this.b.invalidate();
        }
    }
}
