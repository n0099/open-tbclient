package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.v;
/* loaded from: classes.dex */
class i implements v {
    final /* synthetic */ ScrollFragmentTabHost cua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cua = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.v
    public void jF(int i) {
        a aVar;
        this.cua.g(i, false);
        aVar = this.cua.ctU;
        aVar.jI(i);
    }
}
