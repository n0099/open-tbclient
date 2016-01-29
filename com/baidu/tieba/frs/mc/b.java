package com.baidu.tieba.frs.mc;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fi;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements ff {
    final /* synthetic */ a boI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.boI = aVar;
    }

    @Override // com.baidu.tieba.frs.ff
    public void a(int i, int i2, fi fiVar, ArrayList<u> arrayList) {
        int i3;
        ff ffVar;
        o oVar;
        o oVar2;
        ff ffVar2;
        this.boI.boB = false;
        i3 = this.boI.box;
        if (i != i3) {
            return;
        }
        ffVar = this.boI.boF;
        if (ffVar != null) {
            this.boI.boA = fiVar;
            this.boI.b(i, i2, fiVar);
            ArrayList<u> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            oVar = this.boI.bfF;
            oVar.an(arrayList2);
            oVar2 = this.boI.bfF;
            oVar2.aLt();
            ffVar2 = this.boI.boF;
            ffVar2.a(i, i2, fiVar, arrayList);
        }
    }
}
