package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.u;
import com.baidu.tieba.homepage.framework.v;
/* loaded from: classes.dex */
class j implements u {
    final /* synthetic */ ScrollFragmentTabHost cAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cAs = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.u
    public void kd(int i) {
        l lVar;
        v vVar;
        lVar = this.cAs.cAp;
        vVar = this.cAs.cAq;
        lVar.a(i, vVar);
    }
}
