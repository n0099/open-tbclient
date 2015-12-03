package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.eu;
import com.baidu.tieba.frs.ey;
import com.baidu.tieba.tbadkCore.p;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements eu {
    final /* synthetic */ a bib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bib = aVar;
    }

    @Override // com.baidu.tieba.frs.eu
    public void a(int i, int i2, ey eyVar, ArrayList<u> arrayList) {
        int i3;
        eu euVar;
        p pVar;
        p pVar2;
        eu euVar2;
        this.bib.bhV = false;
        i3 = this.bib.bhR;
        if (i != i3) {
            return;
        }
        euVar = this.bib.bhZ;
        if (euVar != null) {
            this.bib.bhU = eyVar;
            this.bib.b(i, i2, eyVar);
            ArrayList<u> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            pVar = this.bib.aZs;
            pVar.am(arrayList2);
            pVar2 = this.bib.aZs;
            pVar2.aCg();
            euVar2 = this.bib.bhZ;
            euVar2.a(i, i2, eyVar, arrayList);
        }
    }
}
