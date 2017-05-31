package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.v;
/* loaded from: classes.dex */
class i implements v {
    final /* synthetic */ ScrollFragmentTabHost cAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cAs = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.v
    public void ke(int i) {
        a aVar;
        this.cAs.g(i, false);
        aVar = this.cAs.cAm;
        aVar.kh(i);
    }
}
