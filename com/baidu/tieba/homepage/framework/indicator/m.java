package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.homepage.framework.y {
    final /* synthetic */ ScrollFragmentTabHost cCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cCF = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.y
    public void jP(int i) {
        a aVar;
        ((SlidingTabLayout) this.cCF.findViewById(t.g.tab_container).findViewById(t.g.tab_widget_sliding_tab)).at(i, 0);
        this.cCF.setCurrentTab(i);
        aVar = this.cCF.cCt;
        aVar.jQ(i);
    }
}
