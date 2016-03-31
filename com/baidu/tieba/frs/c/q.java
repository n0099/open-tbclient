package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.c.o;
import com.baidu.tieba.frs.cs;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fr;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements fp {
    final /* synthetic */ o buW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar) {
        this.buW = oVar;
    }

    @Override // com.baidu.tieba.frs.fp
    public void a(int i, int i2, fr frVar, ArrayList<u> arrayList) {
        SparseArray sparseArray;
        int Z;
        cs csVar;
        sparseArray = this.buW.bsE;
        Z = this.buW.Z(i, i2);
        o.a aVar = (o.a) sparseArray.get(Z);
        if (aVar != null) {
            csVar = this.buW.bko;
            csVar.Mg().setSelectionFromTop(aVar.avf, aVar.top);
        }
        com.baidu.adp.lib.h.h.hx().post(new r(this));
    }
}
