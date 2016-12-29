package com.baidu.tieba.frs.d;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.co;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements ce {
    final /* synthetic */ i bMj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.bMj = iVar;
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, co coVar, ArrayList<v> arrayList) {
        int i3;
        ce ceVar;
        com.baidu.tieba.tbadkCore.o oVar;
        com.baidu.tieba.tbadkCore.o oVar2;
        com.baidu.tieba.tbadkCore.o oVar3;
        ce ceVar2;
        this.bMj.bLY = false;
        i3 = this.bMj.bLU;
        if (i == i3) {
            ceVar = this.bMj.bMd;
            if (ceVar != null) {
                this.bMj.bLX = coVar;
                this.bMj.b(i, i2, coVar);
                ArrayList<v> arrayList2 = new ArrayList<>();
                if (arrayList != null) {
                    arrayList2.addAll(arrayList);
                }
                oVar = this.bMj.byh;
                oVar.at(arrayList2);
                if ((i == 1 || i == 2 || i == 5) && !this.bMj.aaZ()) {
                    oVar2 = this.bMj.byh;
                    oVar2.beR();
                    oVar3 = this.bMj.byh;
                    oVar3.beS();
                }
                ceVar2 = this.bMj.bMd;
                ceVar2.a(i, i2, coVar, arrayList);
            }
        }
    }
}
