package com.baidu.tieba.frs.c;

import android.util.SparseArray;
import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.bi;
import com.baidu.tieba.frs.c.n;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dl;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements di {
    final /* synthetic */ n bca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bca = nVar;
    }

    @Override // com.baidu.tieba.frs.di
    public void a(int i, int i2, dl dlVar, ArrayList<u> arrayList) {
        SparseArray sparseArray;
        int Y;
        bi biVar;
        sparseArray = this.bca.bad;
        Y = this.bca.Y(i, i2);
        n.a aVar = (n.a) sparseArray.get(Y);
        if (aVar != null) {
            biVar = this.bca.aUL;
            biVar.getListView().setSelectionFromTop(aVar.bcc, aVar.top);
        }
        com.baidu.adp.lib.g.h.hf().post(new q(this));
    }
}
