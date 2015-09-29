package com.baidu.tieba.frs.h5;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ee;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements ea {
    private eb aQY;

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
        if (i > 100 && this.aQY != null && ecVar != null && ecVar.aYN != null && (ecVar.aYN instanceof String)) {
            ArrayList<u> arrayList = new ArrayList<>();
            g gVar = new g((String) ecVar.aYN);
            gVar.stType = ecVar.stType;
            arrayList.add(gVar);
            ee eeVar = new ee();
            eeVar.hasMore = false;
            eeVar.aYP = false;
            eeVar.aYQ = false;
            eeVar.pn = ecVar.pn;
            eeVar.aYN = ecVar.aYN;
            this.aQY.a(i, i2, eeVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
        this.aQY = ebVar;
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ea
    public void Ku() {
    }
}
