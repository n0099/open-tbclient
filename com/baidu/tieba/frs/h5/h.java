package com.baidu.tieba.frs.h5;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.fe;
import com.baidu.tieba.frs.ff;
import com.baidu.tieba.frs.fh;
import com.baidu.tieba.frs.fi;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements fe {
    private ff bcR;

    @Override // com.baidu.tieba.frs.fe
    public void a(int i, int i2, fh fhVar) {
        if (i > 100 && this.bcR != null && fhVar != null && fhVar.bmd != null && (fhVar.bmd instanceof String)) {
            ArrayList<u> arrayList = new ArrayList<>();
            g gVar = new g((String) fhVar.bmd);
            gVar.stType = fhVar.stType;
            arrayList.add(gVar);
            fi fiVar = new fi();
            fiVar.hasMore = false;
            fiVar.bme = false;
            fiVar.bmf = false;
            fiVar.pn = fhVar.pn;
            fiVar.bmd = fhVar.bmd;
            this.bcR.a(i, i2, fiVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.fe
    public void a(ff ffVar) {
        this.bcR = ffVar;
    }

    @Override // com.baidu.tieba.frs.fe
    public void init() {
    }

    @Override // com.baidu.tieba.frs.fe
    public void Op() {
    }
}
