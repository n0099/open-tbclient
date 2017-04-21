package com.baidu.tieba.homepage.framework.indicator;

import com.baidu.tbadk.core.view.NoNetworkView;
/* loaded from: classes.dex */
class j implements NoNetworkView.a {
    final /* synthetic */ ScrollFragmentTabHost cxk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.cxk = scrollFragmentTabHost;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aM(boolean z) {
        a aVar;
        if (z && com.baidu.tieba.homepage.framework.a.a.ajV().cyf) {
            aVar = this.cxk.cwY;
            aVar.eY(true);
        }
    }
}
