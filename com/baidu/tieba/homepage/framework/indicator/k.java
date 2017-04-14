package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.r;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ ScrollFragmentTabHost cuT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cuT = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.r.a
    public void aiQ() {
        o oVar;
        r rVar;
        r rVar2;
        o oVar2;
        oVar = this.cuT.cuG;
        if (oVar != null) {
            oVar2 = this.cuT.cuG;
            oVar2.aiS();
        }
        rVar = this.cuT.cuK;
        if (rVar != null) {
            rVar2 = this.cuT.cuK;
            rVar2.a((r.a) null);
            this.cuT.cuL = true;
            this.cuT.cuK = null;
        }
    }
}
