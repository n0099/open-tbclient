package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.r;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.homepage.framework.y {
    final /* synthetic */ ScrollFragmentTabHost cuU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cuU = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.y
    public void ka(int i) {
        a aVar;
        ((SlidingTabLayout) this.cuU.findViewById(r.h.tab_container).findViewById(r.h.tab_widget_sliding_tab)).aq(i, 0);
        this.cuU.setCurrentTab(i);
        aVar = this.cuU.cuI;
        aVar.kb(i);
    }
}
