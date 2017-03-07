package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.r;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ ScrollFragmentTabHost cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cwt = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.r.a
    public void aiW() {
        o oVar;
        r rVar;
        r rVar2;
        o oVar2;
        oVar = this.cwt.cwg;
        if (oVar != null) {
            oVar2 = this.cwt.cwg;
            oVar2.aiY();
        }
        rVar = this.cwt.cwk;
        if (rVar != null) {
            rVar2 = this.cwt.cwk;
            rVar2.a((r.a) null);
            this.cwt.cwl = true;
            this.cwt.cwk = null;
        }
    }
}
