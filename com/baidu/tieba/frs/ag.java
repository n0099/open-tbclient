package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class ag implements dh {
    final /* synthetic */ FrsActivity bQp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(FrsActivity frsActivity) {
        this.bQp = frsActivity;
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dq dqVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.adp.lib.h.h.eG().post(new ah(this));
    }
}
