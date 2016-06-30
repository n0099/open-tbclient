package com.baidu.tieba.frs.f;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.dv;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dm {
    final /* synthetic */ a bQd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bQd = aVar;
    }

    @Override // com.baidu.tieba.frs.dm
    public void a(int i, int i2, dv dvVar, ArrayList<v> arrayList) {
        int i3;
        dm dmVar;
        p pVar;
        p pVar2;
        p pVar3;
        dm dmVar2;
        this.bQd.bPS = false;
        i3 = this.bQd.bPO;
        if (i != i3) {
            return;
        }
        dmVar = this.bQd.bPZ;
        if (dmVar != null) {
            this.bQd.bPR = dvVar;
            this.bQd.b(i, i2, dvVar);
            ArrayList<v> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            pVar = this.bQd.bCF;
            pVar.ay(arrayList2);
            if (i == 1 || i == 2 || i == 5) {
                pVar2 = this.bQd.bCF;
                pVar2.baZ();
                pVar3 = this.bQd.bCF;
                pVar3.bba();
            }
            dmVar2 = this.bQd.bPZ;
            dmVar2.a(i, i2, dvVar, arrayList);
        }
    }
}
