package com.baidu.tieba.frs.frsgood;

import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.ed;
import com.baidu.tieba.frs.eg;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements ed {
    final /* synthetic */ af baF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.baF = afVar;
    }

    @Override // com.baidu.tieba.frs.ed
    public void a(int i, int i2, eg egVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        SparseArray sparseArray;
        x xVar;
        sparseArray = this.baF.baB;
        o.a aVar = (o.a) sparseArray.get(i);
        if (aVar != null) {
            xVar = this.baF.aZZ;
            xVar.getListView().setSelectionFromTop(aVar.bcM, aVar.top);
        }
    }
}
