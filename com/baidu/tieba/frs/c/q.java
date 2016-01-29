package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.frs.cn;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fi;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements ff {
    final /* synthetic */ o bpV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.bpV = oVar;
    }

    @Override // com.baidu.tieba.frs.ff
    public void a(int i, int i2, fi fiVar, ArrayList<u> arrayList) {
        SparseArray sparseArray;
        int ac;
        cn cnVar;
        sparseArray = this.bpV.bnH;
        ac = this.bpV.ac(i, i2);
        o.a aVar = (o.a) sparseArray.get(ac);
        if (aVar != null) {
            cnVar = this.bpV.bfD;
            cnVar.KM().setSelectionFromTop(aVar.auF, aVar.top);
        }
        com.baidu.adp.lib.h.h.hr().post(new r(this));
    }
}
