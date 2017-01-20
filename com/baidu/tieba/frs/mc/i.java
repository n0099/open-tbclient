package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.cc;
import com.baidu.tieba.frs.cm;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements cc {
    final /* synthetic */ FrsModelController bSw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsModelController frsModelController) {
        this.bSw = frsModelController;
    }

    @Override // com.baidu.tieba.frs.cc
    public void a(int i, int i2, cm cmVar, ArrayList<v> arrayList) {
        int i3;
        cc ccVar;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        cc ccVar2;
        this.bSw.bSn = false;
        i3 = this.bSw.bSj;
        if (i == i3) {
            ccVar = this.bSw.bSq;
            if (ccVar != null) {
                this.bSw.bSm = cmVar;
                this.bSw.b(i, i2, cmVar);
                ArrayList<v> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                nVar = this.bSw.bFG;
                nVar.ax(arrayList2);
                if ((i == 1 || i == 2 || i == 5) && !this.bSw.acf()) {
                    nVar2 = this.bSw.bFG;
                    nVar2.bgG();
                    nVar3 = this.bSw.bFG;
                    nVar3.bgH();
                }
                ccVar2 = this.bSw.bSq;
                ccVar2.a(i, i2, cmVar, arrayList);
            }
        }
    }
}
