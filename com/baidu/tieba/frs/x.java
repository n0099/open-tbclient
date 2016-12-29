package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class x implements ce {
    final /* synthetic */ FrsActivity bzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(FrsActivity frsActivity) {
        this.bzl = frsActivity;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, co coVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.adp.lib.h.h.eG().post(new y(this));
    }
}
