package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.r;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ ScrollFragmentTabHost crx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.crx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.r.a
    public void ahi() {
        o oVar;
        r rVar;
        r rVar2;
        o oVar2;
        oVar = this.crx.crk;
        if (oVar != null) {
            oVar2 = this.crx.crk;
            oVar2.ahk();
        }
        rVar = this.crx.cro;
        if (rVar != null) {
            rVar2 = this.crx.cro;
            rVar2.a((r.a) null);
            this.crx.crp = true;
            this.crx.cro = null;
        }
    }
}
