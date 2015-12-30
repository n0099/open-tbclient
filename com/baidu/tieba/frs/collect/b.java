package com.baidu.tieba.frs.collect;

import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class b implements r.a {
    final /* synthetic */ MyCollectFrsActivity bkc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MyCollectFrsActivity myCollectFrsActivity) {
        this.bkc = myCollectFrsActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        l lVar;
        if (!com.baidu.adp.lib.util.k.jh()) {
            lVar = this.bkc.bjX;
            lVar.completePullRefresh();
            return;
        }
        this.bkc.refresh();
    }
}
