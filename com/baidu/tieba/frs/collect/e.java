package com.baidu.tieba.frs.collect;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.p;
/* loaded from: classes.dex */
class e implements NoNetworkView.a {
    final /* synthetic */ MyCollectFrsActivity bgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MyCollectFrsActivity myCollectFrsActivity) {
        this.bgk = myCollectFrsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void aA(boolean z) {
        p pVar;
        l lVar;
        boolean z2;
        l lVar2;
        p pVar2;
        if (z) {
            pVar = this.bgk.aZs;
            if (pVar != null) {
                pVar2 = this.bgk.aZs;
                if (pVar2.getThreadList().size() != 0) {
                    return;
                }
            }
            MyCollectFrsActivity myCollectFrsActivity = this.bgk;
            lVar = this.bgk.bgf;
            myCollectFrsActivity.hideNetRefreshView(lVar.getRootView());
            z2 = this.bgk.aZd;
            if (!z2) {
                MyCollectFrsActivity myCollectFrsActivity2 = this.bgk;
                lVar2 = this.bgk.bgf;
                myCollectFrsActivity2.showLoadingView(lVar2.getRootView(), true);
            }
            this.bgk.refresh();
            return;
        }
        this.bgk.hj(this.bgk.getResources().getString(n.i.no_network_guide));
    }
}
