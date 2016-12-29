package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.r;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.homepage.framework.y {
    final /* synthetic */ ScrollFragmentTabHost cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cnS = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.y
    public void jn(int i) {
        a aVar;
        ((SlidingTabLayout) this.cnS.findViewById(r.g.tab_container).findViewById(r.g.tab_widget_sliding_tab)).aq(i, 0);
        this.cnS.setCurrentTab(i);
        aVar = this.cnS.cnG;
        aVar.jo(i);
    }
}
