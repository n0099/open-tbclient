package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.bl;
import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.df;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements dc {
    final /* synthetic */ n bbG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bbG = nVar;
    }

    @Override // com.baidu.tieba.frs.dc
    public void a(int i, int i2, df dfVar, ArrayList<u> arrayList) {
        SparseArray sparseArray;
        int Y;
        bl blVar;
        sparseArray = this.bbG.aZL;
        Y = this.bbG.Y(i, i2);
        n.a aVar = (n.a) sparseArray.get(Y);
        if (aVar != null) {
            blVar = this.bbG.aUw;
            blVar.getListView().setSelectionFromTop(aVar.bbI, aVar.top);
        }
        com.baidu.adp.lib.g.h.hi().post(new q(this));
    }
}
