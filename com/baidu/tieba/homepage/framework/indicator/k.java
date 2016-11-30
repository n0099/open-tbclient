package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.r;
/* loaded from: classes.dex */
class k implements r.a {
    final /* synthetic */ ScrollFragmentTabHost cIx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.r.a
    public void aoc() {
        o oVar;
        r rVar;
        r rVar2;
        o oVar2;
        oVar = this.cIx.cIk;
        if (oVar != null) {
            oVar2 = this.cIx.cIk;
            oVar2.aoe();
        }
        rVar = this.cIx.cIo;
        if (rVar != null) {
            rVar2 = this.cIx.cIo;
            rVar2.a((r.a) null);
            this.cIx.cIp = true;
            this.cIx.cIo = null;
        }
    }
}
