package com.baidu.tieba.frs.frsgood;

import android.util.SparseArray;
import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dl;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements di {
    final /* synthetic */ af bah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bah = afVar;
    }

    @Override // com.baidu.tieba.frs.di
    public void a(int i, int i2, dl dlVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        SparseArray sparseArray;
        x xVar;
        sparseArray = this.bah.bad;
        n.a aVar = (n.a) sparseArray.get(i);
        if (aVar != null) {
            xVar = this.bah.aZC;
            xVar.getListView().setSelectionFromTop(aVar.bcc, aVar.top);
        }
    }
}
