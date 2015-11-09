package com.baidu.tieba.frs.b;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.bs;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.eg;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements ed {
    final /* synthetic */ o bcK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.bcK = oVar;
    }

    @Override // com.baidu.tieba.frs.ed
    public void a(int i, int i2, eg egVar, ArrayList<u> arrayList) {
        SparseArray sparseArray;
        int aa;
        bs bsVar;
        sparseArray = this.bcK.baB;
        aa = this.bcK.aa(i, i2);
        o.a aVar = (o.a) sparseArray.get(aa);
        if (aVar != null) {
            bsVar = this.bcK.aUc;
            bsVar.getListView().setSelectionFromTop(aVar.bcM, aVar.top);
        }
        com.baidu.adp.lib.g.h.hh().post(new r(this));
    }
}
