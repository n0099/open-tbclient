package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.ca;
import com.baidu.tieba.frs.ci;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ca {
    final /* synthetic */ FrsModelController cmL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsModelController frsModelController) {
        this.cmL = frsModelController;
    }

    @Override // com.baidu.tieba.frs.ca
    public void a(int i, int i2, ci ciVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i3;
        ca caVar;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        ca caVar2;
        this.cmL.cmz = false;
        i3 = this.cmL.cmv;
        if (i == i3) {
            caVar = this.cmL.cmC;
            if (caVar != null) {
                this.cmL.cmy = ciVar;
                this.cmL.b(i, i2, ciVar);
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                nVar = this.cmL.cbN;
                nVar.az(arrayList2);
                if ((i == 1 || i == 5) && !this.cmL.agY()) {
                    nVar2 = this.cmL.cbN;
                    nVar2.blp();
                    nVar3 = this.cmL.cbN;
                    nVar3.blq();
                }
                caVar2 = this.cmL.cmC;
                caVar2.a(i, i2, ciVar, arrayList);
            }
        }
    }
}
