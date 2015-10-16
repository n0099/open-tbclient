package com.baidu.tieba.frs.frsgood;

import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ee;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements eb {
    final /* synthetic */ af bal;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bal = afVar;
    }

    @Override // com.baidu.tieba.frs.eb
    public void a(int i, int i2, ee eeVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        SparseArray sparseArray;
        x xVar;
        sparseArray = this.bal.bah;
        o.a aVar = (o.a) sparseArray.get(i);
        if (aVar != null) {
            xVar = this.bal.aZG;
            xVar.getListView().setSelectionFromTop(aVar.bch, aVar.top);
        }
    }
}
