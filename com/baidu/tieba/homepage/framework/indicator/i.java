package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.v;
/* loaded from: classes.dex */
class i implements v {
    final /* synthetic */ ScrollFragmentTabHost cIe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIe = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.v
    public void kp(int i) {
        a aVar;
        this.cIe.g(i, false);
        aVar = this.cIe.cHY;
        aVar.ks(i);
    }
}
