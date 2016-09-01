package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class j implements NoNetworkView.a {
    final /* synthetic */ ScrollFragmentTabHost cCF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cCF = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aH(boolean z) {
        a aVar;
        if (z && com.baidu.tieba.homepage.framework.a.a.alX().cDA) {
            aVar = this.cCF.cCt;
            aVar.eS(true);
        }
    }
}
