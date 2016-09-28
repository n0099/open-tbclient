package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.y;
/* loaded from: classes.dex */
class p implements y.b {
    final /* synthetic */ FrsActivity bQi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.bQi = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.y.b
    public void aI(boolean z) {
        bm bmVar;
        bm bmVar2;
        this.bQi.refresh();
        bmVar = this.bQi.bPi;
        if (bmVar != null) {
            bmVar2 = this.bQi.bPi;
            bmVar2.dI(true);
        }
    }
}
