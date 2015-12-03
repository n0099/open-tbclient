package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements eu {
    final /* synthetic */ o bjp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.bjp = oVar;
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ey eyVar, ArrayList<u> arrayList) {
        SparseArray sparseArray;
        int ac;
        cd cdVar;
        sparseArray = this.bjp.bgT;
        ac = this.bjp.ac(i, i2);
        o.a aVar = (o.a) sparseArray.get(ac);
        if (aVar != null) {
            cdVar = this.bjp.aZq;
            cdVar.getListView().setSelectionFromTop(aVar.asj, aVar.top);
        }
        com.baidu.adp.lib.h.h.hj().post(new r(this));
    }
}
