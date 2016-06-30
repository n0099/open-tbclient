package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class g implements NoNetworkView.a {
    final /* synthetic */ ScrollFragmentTabHost cpc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cpc = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aD(boolean z) {
        a aVar;
        if (z) {
            aVar = this.cpc.coT;
            aVar.ev(true);
        }
    }
}
