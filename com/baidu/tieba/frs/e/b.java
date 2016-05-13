package com.baidu.tieba.frs.e;

import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.fi;
import com.baidu.tieba.frs.fq;
import com.baidu.tieba.tbadkCore.o;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements fi {
    final /* synthetic */ a bsy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bsy = aVar;
    }

    @Override // com.baidu.tieba.frs.fi
    public void a(int i, int i2, fq fqVar, ArrayList<v> arrayList) {
        int i3;
        fi fiVar;
        o oVar;
        o oVar2;
        o oVar3;
        fi fiVar2;
        this.bsy.bso = false;
        i3 = this.bsy.bsk;
        if (i != i3) {
            return;
        }
        fiVar = this.bsy.bsu;
        if (fiVar != null) {
            this.bsy.bsn = fqVar;
            this.bsy.b(i, i2, fqVar);
            ArrayList<v> arrayList2 = new ArrayList<>();
            if (arrayList != null) {
                arrayList2.addAll(arrayList);
            }
            oVar = this.bsy.bgq;
            oVar.an(arrayList2);
            if (i == 1 || i == 2 || i == 5) {
                oVar2 = this.bsy.bgq;
                oVar2.aSN();
                oVar3 = this.bsy.bgq;
                oVar3.aSO();
            }
            fiVar2 = this.bsy.bsu;
            fiVar2.a(i, i2, fqVar, arrayList);
        }
    }
}
