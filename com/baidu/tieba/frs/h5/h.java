package com.baidu.tieba.frs.h5;

import com.baidu.adp.widget.ListView.u;
import com.baidu.tieba.frs.ea;
import com.baidu.tieba.frs.eb;
import com.baidu.tieba.frs.ec;
import com.baidu.tieba.frs.ee;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class h implements ea {
    private eb aRj;

    @Override // com.baidu.tieba.frs.ea
    public void a(int i, int i2, ec ecVar) {
        if (i > 100 && this.aRj != null && ecVar != null && ecVar.aYY != null && (ecVar.aYY instanceof String)) {
            ArrayList<u> arrayList = new ArrayList<>();
            g gVar = new g((String) ecVar.aYY);
            gVar.stType = ecVar.stType;
            arrayList.add(gVar);
            ee eeVar = new ee();
            eeVar.hasMore = false;
            eeVar.aZa = false;
            eeVar.aZb = false;
            eeVar.pn = ecVar.pn;
            eeVar.aYY = ecVar.aYY;
            this.aRj.a(i, i2, eeVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.ea
    public void a(eb ebVar) {
        this.aRj = ebVar;
    }

    @Override // com.baidu.tieba.frs.ea
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ea
    public void Ku() {
    }
}
