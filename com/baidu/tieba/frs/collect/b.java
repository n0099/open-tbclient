package com.baidu.tieba.frs.collect;

import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class b implements r.a {
    final /* synthetic */ MyCollectFrsActivity bmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MyCollectFrsActivity myCollectFrsActivity) {
        this.bmY = myCollectFrsActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        l lVar;
        if (!com.baidu.adp.lib.util.k.jq()) {
            lVar = this.bmY.bmT;
            lVar.nr();
            return;
        }
        this.bmY.refresh();
    }
}
