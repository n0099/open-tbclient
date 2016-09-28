package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.r;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.homepage.framework.y {
    final /* synthetic */ ScrollFragmentTabHost cDk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cDk = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.y
    public void jV(int i) {
        a aVar;
        ((SlidingTabLayout) this.cDk.findViewById(r.g.tab_container).findViewById(r.g.tab_widget_sliding_tab)).au(i, 0);
        this.cDk.setCurrentTab(i);
        aVar = this.cDk.cCY;
        aVar.jW(i);
    }
}
