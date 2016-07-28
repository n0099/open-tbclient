package com.baidu.tieba.frs.f;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.dv;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dm {
    final /* synthetic */ a bRQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bRQ = aVar;
    }

    @Override // com.baidu.tieba.frs.dm
    public void a(int i, int i2, dv dvVar, ArrayList<v> arrayList) {
        int i3;
        dm dmVar;
        p pVar;
        p pVar2;
        p pVar3;
        dm dmVar2;
        this.bRQ.bRF = false;
        i3 = this.bRQ.bRB;
        if (i != i3) {
            return;
        }
        dmVar = this.bRQ.bRM;
        if (dmVar != null) {
            this.bRQ.bRE = dvVar;
            this.bRQ.b(i, i2, dvVar);
            ArrayList<v> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            pVar = this.bRQ.bDM;
            pVar.aB(arrayList2);
            if ((i == 1 || i == 2 || i == 5) && !this.bRQ.aah()) {
                pVar2 = this.bRQ.bDM;
                pVar2.ben();
                pVar3 = this.bRQ.bDM;
                pVar3.beo();
            }
            dmVar2 = this.bRQ.bRM;
            dmVar2.a(i, i2, dvVar, arrayList);
        }
    }
}
