package com.baidu.tieba.frs.frsgood;

import android.util.SparseArray;
import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.df;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements dc {
    final /* synthetic */ af aZP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.aZP = afVar;
    }

    @Override // com.baidu.tieba.frs.dc
    public void a(int i, int i2, df dfVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        SparseArray sparseArray;
        x xVar;
        sparseArray = this.aZP.aZL;
        n.a aVar = (n.a) sparseArray.get(i);
        if (aVar != null) {
            xVar = this.aZP.aZj;
            xVar.getListView().setSelectionFromTop(aVar.bbI, aVar.top);
        }
    }
}
