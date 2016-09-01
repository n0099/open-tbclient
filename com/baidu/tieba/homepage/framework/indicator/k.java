package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.r;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ ScrollFragmentTabHost cCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cCF = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.r.a
    public void alT() {
        o oVar;
        r rVar;
        r rVar2;
        o oVar2;
        oVar = this.cCF.cCs;
        if (oVar != null) {
            oVar2 = this.cCF.cCs;
            oVar2.alV();
        }
        rVar = this.cCF.cCw;
        if (rVar != null) {
            rVar2 = this.cCF.cCw;
            rVar2.a((r.a) null);
            this.cCF.cCx = true;
            this.cCF.cCw = null;
        }
    }
}
