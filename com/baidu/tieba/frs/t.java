package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class t implements cf {
    final /* synthetic */ FrsActivity bTa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(FrsActivity frsActivity) {
        this.bTa = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cf
    public void a(int i, int i2, cp cpVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.adp.lib.h.h.eG().post(new u(this));
    }
}
