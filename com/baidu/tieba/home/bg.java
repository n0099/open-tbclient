package com.baidu.tieba.home;

import com.baidu.tieba.view.ADImageViewDrawer;
/* loaded from: classes.dex */
class bg implements com.baidu.tbadk.a.d {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TopicPagerAdapter f1146a;
    private final /* synthetic */ ADImageViewDrawer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(TopicPagerAdapter topicPagerAdapter, ADImageViewDrawer aDImageViewDrawer) {
        this.f1146a = topicPagerAdapter;
        this.b = aDImageViewDrawer;
    }

    @Override // com.baidu.tbadk.a.d
    public void a(com.baidu.adp.widget.a.b bVar, String str, boolean z) {
        if (bVar != null && this.b != null) {
            this.b.invalidate();
        }
    }
}
