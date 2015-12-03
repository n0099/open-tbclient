package com.baidu.tieba.frs.collect;

import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class b implements q.a {
    final /* synthetic */ MyCollectFrsActivity bgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MyCollectFrsActivity myCollectFrsActivity) {
        this.bgk = myCollectFrsActivity;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        l lVar;
        if (!com.baidu.adp.lib.util.k.jg()) {
            lVar = this.bgk.bgf;
            lVar.completePullRefresh();
            return;
        }
        this.bgk.refresh();
    }
}
