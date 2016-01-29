package com.baidu.tieba.frs.frsgood;

import android.util.SparseArray;
import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fi;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements ff {
    final /* synthetic */ ag bnL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.bnL = agVar;
    }

    @Override // com.baidu.tieba.frs.ff
    public void a(int i, int i2, fi fiVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        SparseArray sparseArray;
        y yVar;
        sparseArray = this.bnL.bnH;
        o.a aVar = (o.a) sparseArray.get(i);
        if (aVar != null) {
            yVar = this.bnL.bng;
            yVar.KM().setSelectionFromTop(aVar.auF, aVar.top);
        }
    }
}
