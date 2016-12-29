package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.r;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ ScrollFragmentTabHost cnS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cnS = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.r.a
    public void aiC() {
        o oVar;
        r rVar;
        r rVar2;
        o oVar2;
        oVar = this.cnS.cnF;
        if (oVar != null) {
            oVar2 = this.cnS.cnF;
            oVar2.aiE();
        }
        rVar = this.cnS.cnJ;
        if (rVar != null) {
            rVar2 = this.cnS.cnJ;
            rVar2.a((r.a) null);
            this.cnS.cnK = true;
            this.cnS.cnJ = null;
        }
    }
}
