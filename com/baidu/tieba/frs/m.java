package com.baidu.tieba.frs;

import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class m implements t.b {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aE(boolean z) {
        this.bDB.refresh();
    }
}
