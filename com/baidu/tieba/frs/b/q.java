package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.cg;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements ev {
    final /* synthetic */ o bng;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.bng = oVar;
    }

    @Override // com.baidu.tieba.frs.ev
    public void a(int i, int i2, ey eyVar, ArrayList<u> arrayList) {
        SparseArray sparseArray;
        int ac;
        cg cgVar;
        sparseArray = this.bng.bkK;
        ac = this.bng.ac(i, i2);
        o.a aVar = (o.a) sparseArray.get(ac);
        if (aVar != null) {
            cgVar = this.bng.bdm;
            cgVar.getListView().setSelectionFromTop(aVar.atN, aVar.top);
        }
        com.baidu.adp.lib.h.h.hj().post(new r(this));
    }
}
