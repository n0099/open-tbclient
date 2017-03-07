package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cm;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements cc {
    final /* synthetic */ FrsModelController bZF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsModelController frsModelController) {
        this.bZF = frsModelController;
    }

    @Override // com.baidu.tieba.frs.cc
    public void a(int i, int i2, cm cmVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i3;
        cc ccVar;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        cc ccVar2;
        this.bZF.bZv = false;
        i3 = this.bZF.bZr;
        if (i == i3) {
            ccVar = this.bZF.bZy;
            if (ccVar != null) {
                this.bZF.bZu = cmVar;
                this.bZF.b(i, i2, cmVar);
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                nVar = this.bZF.bMO;
                nVar.ax(arrayList2);
                if ((i == 1 || i == 2 || i == 5) && !this.bZF.adc()) {
                    nVar2 = this.bZF.bMO;
                    nVar2.bgt();
                    nVar3 = this.bZF.bMO;
                    nVar3.bgu();
                }
                ccVar2 = this.bZF.bZy;
                ccVar2.a(i, i2, cmVar, arrayList);
            }
        }
    }
}
