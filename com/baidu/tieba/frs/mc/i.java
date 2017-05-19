package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.by;
import com.baidu.tieba.frs.cg;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements by {
    final /* synthetic */ FrsModelController bYn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsModelController frsModelController) {
        this.bYn = frsModelController;
    }

    @Override // com.baidu.tieba.frs.by
    public void a(int i, int i2, cg cgVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i3;
        by byVar;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        by byVar2;
        this.bYn.bYb = false;
        i3 = this.bYn.bXX;
        if (i == i3) {
            byVar = this.bYn.bYe;
            if (byVar != null) {
                this.bYn.bYa = cgVar;
                this.bYn.b(i, i2, cgVar);
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                nVar = this.bYn.bNT;
                nVar.ay(arrayList2);
                if ((i == 1 || i == 5) && !this.bYn.acb()) {
                    nVar2 = this.bYn.bNT;
                    nVar2.bfF();
                    nVar3 = this.bYn.bNT;
                    nVar3.bfG();
                }
                byVar2 = this.bYn.bYe;
                byVar2.a(i, i2, cgVar, arrayList);
            }
        }
    }
}
