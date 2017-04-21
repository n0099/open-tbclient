package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.w;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.homepage.framework.y {
    final /* synthetic */ ScrollFragmentTabHost cxk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cxk = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.y
    public void jM(int i) {
        a aVar;
        ((SlidingTabLayout) this.cxk.findViewById(w.h.tab_container).findViewById(w.h.tab_widget_sliding_tab)).ar(i, 0);
        this.cxk.setCurrentTab(i);
        aVar = this.cxk.cwY;
        aVar.jN(i);
    }
}
