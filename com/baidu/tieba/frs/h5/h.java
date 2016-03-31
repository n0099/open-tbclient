package com.baidu.tieba.frs.h5;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.fo;
import com.baidu.tieba.frs.fp;
import com.baidu.tieba.frs.fq;
import com.baidu.tieba.frs.fr;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements fo {
    private fp bhC;

    @Override // com.baidu.tieba.frs.fo
    public void a(int i, int i2, fq fqVar) {
        if (i > 100 && this.bhC != null && fqVar != null && fqVar.brs != null && (fqVar.brs instanceof String)) {
            ArrayList<u> arrayList = new ArrayList<>();
            g gVar = new g((String) fqVar.brs);
            gVar.stType = fqVar.stType;
            arrayList.add(gVar);
            fr frVar = new fr();
            frVar.hasMore = false;
            frVar.brt = false;
            frVar.bru = false;
            frVar.pn = fqVar.pn;
            frVar.brs = fqVar.brs;
            this.bhC.a(i, i2, frVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.fo
    public void a(fp fpVar) {
        this.bhC = fpVar;
    }

    @Override // com.baidu.tieba.frs.fo
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fo
    public void Qe() {
    }
}
