package com.baidu.tieba.frs;

import java.util.ArrayList;
/* loaded from: classes.dex */
class w implements cc {
    final /* synthetic */ FrsActivity bGL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FrsActivity frsActivity) {
        this.bGL = frsActivity;
    }

    @Override // com.baidu.tieba.frs.cc
    public void a(int i, int i2, cm cmVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        com.baidu.adp.lib.g.h.eE().post(new x(this));
    }
}
