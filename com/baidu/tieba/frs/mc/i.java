package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.co;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ce {
    final /* synthetic */ FrsModelController bYe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsModelController frsModelController) {
        this.bYe = frsModelController;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, co coVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i3;
        ce ceVar;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        ce ceVar2;
        this.bYe.bXU = false;
        i3 = this.bYe.bXQ;
        if (i == i3) {
            ceVar = this.bYe.bXX;
            if (ceVar != null) {
                this.bYe.bXT = coVar;
                this.bYe.b(i, i2, coVar);
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                nVar = this.bYe.bME;
                nVar.ax(arrayList2);
                if ((i == 1 || i == 5) && !this.bYe.acW()) {
                    nVar2 = this.bYe.bME;
                    nVar2.bhg();
                    nVar3 = this.bYe.bME;
                    nVar3.bhh();
                }
                ceVar2 = this.bYe.bXX;
                ceVar2.a(i, i2, coVar, arrayList);
            }
        }
    }
}
