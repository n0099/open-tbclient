package com.baidu.tieba.frs.mc;

import com.baidu.tieba.frs.bz;
import com.baidu.tieba.frs.ch;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements bz {
    final /* synthetic */ FrsModelController cey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(FrsModelController frsModelController) {
        this.cey = frsModelController;
    }

    @Override // com.baidu.tieba.frs.bz
    public void a(int i, int i2, ch chVar, ArrayList<com.baidu.adp.widget.ListView.v> arrayList) {
        int i3;
        bz bzVar;
        com.baidu.tieba.tbadkCore.n nVar;
        com.baidu.tieba.tbadkCore.n nVar2;
        com.baidu.tieba.tbadkCore.n nVar3;
        bz bzVar2;
        this.cey.cem = false;
        i3 = this.cey.cei;
        if (i == i3) {
            bzVar = this.cey.cep;
            if (bzVar != null) {
                this.cey.cel = chVar;
                this.cey.b(i, i2, chVar);
                ArrayList<com.baidu.adp.widget.ListView.v> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                nVar = this.cey.bTF;
                nVar.ay(arrayList2);
                if ((i == 1 || i == 5) && !this.cey.adf()) {
                    nVar2 = this.cey.bTF;
                    nVar2.bhb();
                    nVar3 = this.cey.bTF;
                    nVar3.bhc();
                }
                bzVar2 = this.cey.cep;
                bzVar2.a(i, i2, chVar, arrayList);
            }
        }
    }
}
