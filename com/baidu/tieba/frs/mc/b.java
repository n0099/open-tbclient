package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ee;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements eb {
    final /* synthetic */ a baS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.baS = aVar;
    }

    @Override // com.baidu.tieba.frs.eb
    public void a(int i, int i2, ee eeVar, ArrayList<u> arrayList) {
        int i3;
        eb ebVar;
        o oVar;
        o oVar2;
        eb ebVar2;
        this.baS.baM = false;
        i3 = this.baS.aZS;
        if (i != i3) {
            return;
        }
        ebVar = this.baS.baQ;
        if (ebVar != null) {
            this.baS.baL = eeVar;
            this.baS.b(i, i2, eeVar);
            ArrayList<u> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            oVar = this.baS.aTL;
            oVar.af(arrayList2);
            oVar2 = this.baS.aTL;
            oVar2.avM();
            ebVar2 = this.baS.baQ;
            ebVar2.a(i, i2, eeVar, arrayList);
        }
    }
}
