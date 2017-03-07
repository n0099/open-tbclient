package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class j implements NoNetworkView.a {
    final /* synthetic */ ScrollFragmentTabHost cwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cwt = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        a aVar;
        if (z && com.baidu.tieba.homepage.framework.a.a.aja().cxo) {
            aVar = this.cwt.cwh;
            aVar.eO(true);
        }
    }
}
