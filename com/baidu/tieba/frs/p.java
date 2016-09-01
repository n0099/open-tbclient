package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class p implements t.b {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aI(boolean z) {
        bm bmVar;
        bm bmVar2;
        this.bQp.refresh();
        bmVar = this.bQp.bPo;
        if (bmVar != null) {
            bmVar2 = this.bQp.bPo;
            bmVar2.dH(true);
        }
    }
}
