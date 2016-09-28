package com.baidu.tieba.frs.e;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dq;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dh {
    final /* synthetic */ a ccV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ccV = aVar;
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dq dqVar, ArrayList<v> arrayList) {
        int i3;
        dh dhVar;
        p pVar;
        p pVar2;
        p pVar3;
        dh dhVar2;
        this.ccV.ccK = false;
        i3 = this.ccV.ccG;
        if (i != i3) {
            return;
        }
        dhVar = this.ccV.ccR;
        if (dhVar != null) {
            this.ccV.ccJ = dqVar;
            this.ccV.b(i, i2, dqVar);
            ArrayList<v> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            pVar = this.ccV.bPk;
            pVar.aA(arrayList2);
            if ((i == 1 || i == 2 || i == 5) && !this.ccV.afg()) {
                pVar2 = this.ccV.bPk;
                pVar2.biD();
                pVar3 = this.ccV.bPk;
                pVar3.biE();
            }
            dhVar2 = this.ccV.ccR;
            dhVar2.a(i, i2, dqVar, arrayList);
        }
    }
}
