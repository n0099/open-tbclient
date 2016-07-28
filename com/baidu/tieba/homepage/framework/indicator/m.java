package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.u;
/* loaded from: classes.dex */
class m implements com.baidu.tieba.homepage.framework.y {
    final /* synthetic */ ScrollFragmentTabHost crx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.crx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.y
    public void jn(int i) {
        a aVar;
        ((SlidingTabLayout) this.crx.findViewById(u.g.tab_container).findViewById(u.g.tab_widget_sliding_tab)).ao(i, 0);
        this.crx.setCurrentTab(i);
        aVar = this.crx.crl;
        aVar.jo(i);
    }
}
