package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.ev;
import com.baidu.tieba.frs.ey;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ev {
    final /* synthetic */ a blT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.blT = aVar;
    }

    @Override // com.baidu.tieba.frs.ev
    public void a(int i, int i2, ey eyVar, ArrayList<u> arrayList) {
        int i3;
        ev evVar;
        p pVar;
        p pVar2;
        ev evVar2;
        this.blT.blM = false;
        i3 = this.blT.blI;
        if (i != i3) {
            return;
        }
        evVar = this.blT.blQ;
        if (evVar != null) {
            this.blT.blL = eyVar;
            this.blT.b(i, i2, eyVar);
            ArrayList<u> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            pVar = this.blT.bdo;
            pVar.am(arrayList2);
            pVar2 = this.blT.bdo;
            pVar2.aEo();
            evVar2 = this.blT.blQ;
            evVar2.a(i, i2, eyVar, arrayList);
        }
    }
}
