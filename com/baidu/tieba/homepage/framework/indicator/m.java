package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.w;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.homepage.framework.y {
    final /* synthetic */ ScrollFragmentTabHost cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cwt = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.y
    public void jF(int i) {
        a aVar;
        ((SlidingTabLayout) this.cwt.findViewById(w.h.tab_container).findViewById(w.h.tab_widget_sliding_tab)).at(i, 0);
        this.cwt.setCurrentTab(i);
        aVar = this.cwt.cwh;
        aVar.jG(i);
    }
}
