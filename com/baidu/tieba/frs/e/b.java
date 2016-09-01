package com.baidu.tieba.frs.e;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dq;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements dh {
    final /* synthetic */ a ccW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ccW = aVar;
    }

    @Override // com.baidu.tieba.frs.dh
    public void a(int i, int i2, dq dqVar, ArrayList<v> arrayList) {
        int i3;
        dh dhVar;
        p pVar;
        p pVar2;
        p pVar3;
        dh dhVar2;
        this.ccW.ccL = false;
        i3 = this.ccW.ccH;
        if (i != i3) {
            return;
        }
        dhVar = this.ccW.ccS;
        if (dhVar != null) {
            this.ccW.ccK = dqVar;
            this.ccW.b(i, i2, dqVar);
            ArrayList<v> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            pVar = this.ccW.bPq;
            pVar.aA(arrayList2);
            if ((i == 1 || i == 2 || i == 5) && !this.ccW.aeS()) {
                pVar2 = this.ccW.bPq;
                pVar2.bhT();
                pVar3 = this.ccW.bPq;
                pVar3.bhU();
            }
            dhVar2 = this.ccW.ccS;
            dhVar2.a(i, i2, dqVar, arrayList);
        }
    }
}
