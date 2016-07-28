package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class j implements NoNetworkView.a {
    final /* synthetic */ ScrollFragmentTabHost crx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.crx = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aG(boolean z) {
        a aVar;
        if (z && com.baidu.tieba.homepage.framework.a.a.ahm().css) {
            aVar = this.crx.crl;
            aVar.ew(true);
        }
    }
}
