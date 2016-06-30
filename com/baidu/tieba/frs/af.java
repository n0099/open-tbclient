package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class af implements dm {
    final /* synthetic */ FrsActivity bDB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FrsActivity frsActivity) {
        this.bDB = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dm
    public void a(int i, int i2, dv dvVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.adp.lib.h.h.dM().post(new ag(this));
    }
}
