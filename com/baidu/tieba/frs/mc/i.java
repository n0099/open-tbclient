package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.co;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements ce {
    final /* synthetic */ FrsModelController cav;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsModelController frsModelController) {
        this.cav = frsModelController;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, co coVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i3;
        ce ceVar;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        ce ceVar2;
        this.cav.cal = false;
        i3 = this.cav.cah;
        if (i == i3) {
            ceVar = this.cav.cao;
            if (ceVar != null) {
                this.cav.cak = coVar;
                this.cav.b(i, i2, coVar);
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                nVar = this.cav.bOV;
                nVar.ax(arrayList2);
                if ((i == 1 || i == 5) && !this.cav.adX()) {
                    nVar2 = this.cav.bOV;
                    nVar2.bih();
                    nVar3 = this.cav.bOV;
                    nVar3.bii();
                }
                ceVar2 = this.cav.cao;
                ceVar2.a(i, i2, coVar, arrayList);
            }
        }
    }
}
