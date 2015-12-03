package com.baidu.tieba.frs.frsgood;

import android.util.SparseArray;
import com.baidu.tieba.frs.b.o;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ey;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag implements eu {
    final /* synthetic */ af bgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(af afVar) {
        this.bgX = afVar;
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ey eyVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        SparseArray sparseArray;
        x xVar;
        sparseArray = this.bgX.bgT;
        o.a aVar = (o.a) sparseArray.get(i);
        if (aVar != null) {
            xVar = this.bgX.bgr;
            xVar.getListView().setSelectionFromTop(aVar.asj, aVar.top);
        }
    }
}
