package com.baidu.tieba.frs.frsgood;

import android.util.SparseArray;
import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fr;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements fp {
    final /* synthetic */ ag bsI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.bsI = agVar;
    }

    @Override // com.baidu.tieba.frs.fp
    public void a(int i, int i2, fr frVar, ArrayList<com.baidu.adp.widget.ListView.u> arrayList) {
        SparseArray sparseArray;
        y yVar;
        sparseArray = this.bsI.bsE;
        o.a aVar = (o.a) sparseArray.get(i);
        if (aVar != null) {
            yVar = this.bsI.bsd;
            yVar.Mg().setSelectionFromTop(aVar.avf, aVar.top);
        }
    }
}
