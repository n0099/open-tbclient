package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class j implements NoNetworkView.a {
    final /* synthetic */ ScrollFragmentTabHost cIx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cIx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aK(boolean z) {
        a aVar;
        if (z && com.baidu.tieba.homepage.framework.a.a.aog().cJs) {
            aVar = this.cIx.cIl;
            aVar.fi(true);
        }
    }
}
