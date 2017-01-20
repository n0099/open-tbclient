package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.r;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ ScrollFragmentTabHost cuU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cuU = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.r.a
    public void ajK() {
        o oVar;
        r rVar;
        r rVar2;
        o oVar2;
        oVar = this.cuU.cuH;
        if (oVar != null) {
            oVar2 = this.cuU.cuH;
            oVar2.ajM();
        }
        rVar = this.cuU.cuL;
        if (rVar != null) {
            rVar2 = this.cuU.cuL;
            rVar2.a((r.a) null);
            this.cuU.cuM = true;
            this.cuU.cuL = null;
        }
    }
}
