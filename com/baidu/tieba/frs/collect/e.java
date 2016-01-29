package com.baidu.tieba.frs.collect;

import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.o;
/* loaded from: classes.dex */
class e implements NoNetworkView.a {
    final /* synthetic */ MyCollectFrsActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(MyCollectFrsActivity myCollectFrsActivity) {
        this.bmY = myCollectFrsActivity;
    }

    @Override // com.baidu.tbadk.core.view.NoNetworkView.a
    public void ay(boolean z) {
        o oVar;
        l lVar;
        boolean z2;
        l lVar2;
        o oVar2;
        if (z) {
            oVar = this.bmY.bfF;
            if (oVar != null) {
                oVar2 = this.bmY.bfF;
                if (oVar2.getThreadList().size() != 0) {
                    return;
                }
            }
            MyCollectFrsActivity myCollectFrsActivity = this.bmY;
            lVar = this.bmY.bmT;
            myCollectFrsActivity.hideNetRefreshView(lVar.getRootView());
            z2 = this.bmY.bfq;
            if (!z2) {
                MyCollectFrsActivity myCollectFrsActivity2 = this.bmY;
                lVar2 = this.bmY.bmT;
                myCollectFrsActivity2.showLoadingView(lVar2.getRootView(), true);
            }
            this.bmY.refresh();
            return;
        }
        this.bmY.hv(this.bmY.getResources().getString(t.j.no_network_guide));
    }
}
