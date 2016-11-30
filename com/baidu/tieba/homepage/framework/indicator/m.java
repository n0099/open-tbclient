package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.r;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.homepage.framework.y {
    final /* synthetic */ ScrollFragmentTabHost cIx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.y
    public void kc(int i) {
        a aVar;
        ((SlidingTabLayout) this.cIx.findViewById(r.g.tab_container).findViewById(r.g.tab_widget_sliding_tab)).av(i, 0);
        this.cIx.setCurrentTab(i);
        aVar = this.cIx.cIl;
        aVar.kd(i);
    }
}
