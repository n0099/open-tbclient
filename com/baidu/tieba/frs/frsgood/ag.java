package com.baidu.tieba.frs.frsgood;

import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements ev {
    final /* synthetic */ af bkO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bkO = afVar;
    }

    @Override // com.baidu.tieba.frs.ev
    public void a(int i, int i2, ey eyVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        SparseArray sparseArray;
        x xVar;
        sparseArray = this.bkO.bkK;
        o.a aVar = (o.a) sparseArray.get(i);
        if (aVar != null) {
            xVar = this.bkO.bkj;
            xVar.getListView().setSelectionFromTop(aVar.atN, aVar.top);
        }
    }
}
