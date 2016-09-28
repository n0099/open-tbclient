package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.r;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ ScrollFragmentTabHost cDk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cDk = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.r.a
    public void amh() {
        o oVar;
        r rVar;
        r rVar2;
        o oVar2;
        oVar = this.cDk.cCX;
        if (oVar != null) {
            oVar2 = this.cDk.cCX;
            oVar2.amj();
        }
        rVar = this.cDk.cDb;
        if (rVar != null) {
            rVar2 = this.cDk.cDb;
            rVar2.a((r.a) null);
            this.cDk.cDc = true;
            this.cDk.cDb = null;
        }
    }
}
