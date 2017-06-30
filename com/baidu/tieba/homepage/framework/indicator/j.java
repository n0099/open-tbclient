package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.u;
import com.baidu.tieba.homepage.framework.v;
/* loaded from: classes.dex */
class j implements u {
    final /* synthetic */ ScrollFragmentTabHost cIe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIe = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.u
    public void ko(int i) {
        l lVar;
        v vVar;
        lVar = this.cIe.cIb;
        vVar = this.cIe.cIc;
        lVar.a(i, vVar);
    }
}
