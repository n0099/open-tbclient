package com.baidu.tieba.frs.b;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.df;
import com.baidu.tieba.tbadkCore.n;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dc {
    final /* synthetic */ a baF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.baF = aVar;
    }

    @Override // com.baidu.tieba.frs.dc
    public void a(int i, int i2, df dfVar, ArrayList<u> arrayList) {
        int i3;
        dc dcVar;
        n nVar;
        dc dcVar2;
        this.baF.baz = false;
        i3 = this.baF.aZH;
        if (i != i3) {
            return;
        }
        dcVar = this.baF.baD;
        if (dcVar != null) {
            this.baF.bay = dfVar;
            this.baF.b(i, i2, dfVar);
            ArrayList<u> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            nVar = this.baF.aUy;
            nVar.X(arrayList2);
            dcVar2 = this.baF.baD;
            dcVar2.a(i, i2, dfVar, arrayList);
        }
    }
}
