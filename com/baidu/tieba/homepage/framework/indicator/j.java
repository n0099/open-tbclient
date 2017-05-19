package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.u;
import com.baidu.tieba.homepage.framework.v;
/* loaded from: classes.dex */
class j implements u {
    final /* synthetic */ ScrollFragmentTabHost cua;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cua = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.u
    public void jE(int i) {
        l lVar;
        v vVar;
        lVar = this.cua.ctX;
        vVar = this.cua.ctY;
        lVar.a(i, vVar);
    }
}
