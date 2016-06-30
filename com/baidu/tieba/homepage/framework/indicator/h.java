package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tieba.homepage.framework.indicator.m;
/* loaded from: classes.dex */
class h implements m.a {
    final /* synthetic */ ScrollFragmentTabHost cpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cpc = scrollFragmentTabHost;
    }

    @Override // com.baidu.tieba.homepage.framework.indicator.m.a
    public void agC() {
        j jVar;
        m mVar;
        m mVar2;
        j jVar2;
        jVar = this.cpc.coS;
        if (jVar != null) {
            jVar2 = this.cpc.coS;
            jVar2.agE();
        }
        mVar = this.cpc.coW;
        if (mVar != null) {
            mVar2 = this.cpc.coW;
            mVar2.a((m.a) null);
            this.cpc.coX = true;
            this.cpc.coW = null;
        }
    }
}
