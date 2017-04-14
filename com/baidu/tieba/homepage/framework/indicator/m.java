package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.w;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.homepage.framework.y {
    final /* synthetic */ ScrollFragmentTabHost cuT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cuT = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.y
    public void jG(int i) {
        a aVar;
        ((SlidingTabLayout) this.cuT.findViewById(w.h.tab_container).findViewById(w.h.tab_widget_sliding_tab)).ar(i, 0);
        this.cuT.setCurrentTab(i);
        aVar = this.cuT.cuH;
        aVar.jH(i);
    }
}
