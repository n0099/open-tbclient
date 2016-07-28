package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class m implements t.b {
    final /* synthetic */ FrsActivity bEL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.bEL = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aH(boolean z) {
        this.bEL.refresh();
    }
}
