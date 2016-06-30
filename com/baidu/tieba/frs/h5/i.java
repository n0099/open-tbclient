package com.baidu.tieba.frs.h5;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.dl;
import com.baidu.tieba.frs.dm;
import com.baidu.tieba.frs.ds;
import com.baidu.tieba.frs.dv;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements dl {
    private dm bzz;

    public void setTag(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(int i, int i2, ds dsVar) {
        if (i > 100 && this.bzz != null && dsVar != null && dsVar.bHh != null && (dsVar.bHh instanceof String)) {
            ArrayList<v> arrayList = new ArrayList<>();
            h hVar = new h((String) dsVar.bHh);
            hVar.stType = dsVar.stType;
            arrayList.add(hVar);
            dv dvVar = new dv();
            dvVar.hasMore = false;
            dvVar.bHj = false;
            dvVar.bHk = false;
            dvVar.pn = dsVar.pn;
            dvVar.bHh = dsVar.bHh;
            this.bzz.a(i, i2, dvVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.dl
    public void a(dm dmVar) {
        this.bzz = dmVar;
    }

    @Override // com.baidu.tieba.frs.dl
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dl
    public void UC() {
    }
}
