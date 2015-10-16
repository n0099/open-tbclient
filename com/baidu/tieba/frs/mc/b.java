package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements eb {
    final /* synthetic */ a bbd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bbd = aVar;
    }

    @Override // com.baidu.tieba.frs.eb
    public void a(int i, int i2, ee eeVar, ArrayList<u> arrayList) {
        int i3;
        eb ebVar;
        o oVar;
        o oVar2;
        eb ebVar2;
        this.bbd.baX = false;
        i3 = this.bbd.bad;
        if (i != i3) {
            return;
        }
        ebVar = this.bbd.bbb;
        if (ebVar != null) {
            this.bbd.baW = eeVar;
            this.bbd.b(i, i2, eeVar);
            ArrayList<u> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            oVar = this.bbd.aTW;
            oVar.af(arrayList2);
            oVar2 = this.bbd.aTW;
            oVar2.avU();
            ebVar2 = this.bbd.bbb;
            ebVar2.a(i, i2, eeVar, arrayList);
        }
    }
}
