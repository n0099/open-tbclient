package com.baidu.tieba.frs.collect;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.p;
/* loaded from: classes.dex */
class e implements NoNetworkView.a {
    final /* synthetic */ MyCollectFrsActivity bkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MyCollectFrsActivity myCollectFrsActivity) {
        this.bkc = myCollectFrsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ax(boolean z) {
        p pVar;
        l lVar;
        boolean z2;
        l lVar2;
        p pVar2;
        if (z) {
            pVar = this.bkc.bdo;
            if (pVar != null) {
                pVar2 = this.bkc.bdo;
                if (pVar2.getThreadList().size() != 0) {
                    return;
                }
            }
            MyCollectFrsActivity myCollectFrsActivity = this.bkc;
            lVar = this.bkc.bjX;
            myCollectFrsActivity.hideNetRefreshView(lVar.getRootView());
            z2 = this.bkc.bcZ;
            if (!z2) {
                MyCollectFrsActivity myCollectFrsActivity2 = this.bkc;
                lVar2 = this.bkc.bjX;
                myCollectFrsActivity2.showLoadingView(lVar2.getRootView(), true);
            }
            this.bkc.refresh();
            return;
        }
        this.bkc.hu(this.bkc.getResources().getString(n.j.no_network_guide));
    }
}
