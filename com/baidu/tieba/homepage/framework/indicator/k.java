package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.r;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ ScrollFragmentTabHost cxk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cxk = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.r.a
    public void ajR() {
        o oVar;
        r rVar;
        r rVar2;
        o oVar2;
        oVar = this.cxk.cwX;
        if (oVar != null) {
            oVar2 = this.cxk.cwX;
            oVar2.ajT();
        }
        rVar = this.cxk.cxb;
        if (rVar != null) {
            rVar2 = this.cxk.cxb;
            rVar2.a((r.a) null);
            this.cxk.cxc = true;
            this.cxk.cxb = null;
        }
    }
}
