package com.baidu.tieba.frs.b;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.di;
import com.baidu.tieba.frs.dl;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements di {
    final /* synthetic */ a baZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.baZ = aVar;
    }

    @Override // com.baidu.tieba.frs.di
    public void a(int i, int i2, dl dlVar, ArrayList<u> arrayList) {
        int i3;
        di diVar;
        o oVar;
        o oVar2;
        di diVar2;
        this.baZ.baT = false;
        i3 = this.baZ.aZZ;
        if (i != i3) {
            return;
        }
        diVar = this.baZ.baX;
        if (diVar != null) {
            this.baZ.baS = dlVar;
            this.baZ.b(i, i2, dlVar);
            ArrayList<u> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            oVar = this.baZ.aUN;
            oVar.ad(arrayList2);
            oVar2 = this.baZ.aUN;
            oVar2.atw();
            diVar2 = this.baZ.baX;
            diVar2.a(i, i2, dlVar, arrayList);
        }
    }
}
