package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class w implements ce {
    final /* synthetic */ FrsActivity bNJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.bNJ = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, co coVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.adp.lib.g.h.fR().post(new x(this));
    }
}
