package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ee;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements eb {
    final /* synthetic */ o bbU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.bbU = oVar;
    }

    @Override // com.baidu.tieba.frs.eb
    public void a(int i, int i2, ee eeVar, ArrayList<u> arrayList) {
        SparseArray sparseArray;
        int Y;
        bs bsVar;
        sparseArray = this.bbU.aZW;
        Y = this.bbU.Y(i, i2);
        o.a aVar = (o.a) sparseArray.get(Y);
        if (aVar != null) {
            bsVar = this.bbU.aTJ;
            bsVar.getListView().setSelectionFromTop(aVar.bbW, aVar.top);
        }
        com.baidu.adp.lib.g.h.hg().post(new r(this));
    }
}
