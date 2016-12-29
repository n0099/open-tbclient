package com.baidu.tieba.frs.h5;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.co;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements cd {
    private ce bwk;

    public void setTag(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        if (i > 100 && this.bwk != null && clVar != null && clVar.bBQ != null && (clVar.bBQ instanceof String)) {
            ArrayList<v> arrayList = new ArrayList<>();
            h hVar = new h((String) clVar.bBQ);
            hVar.stType = clVar.stType;
            arrayList.add(hVar);
            co coVar = new co();
            coVar.hasMore = false;
            coVar.bBS = false;
            coVar.bBT = false;
            coVar.pn = clVar.pn;
            coVar.bBQ = clVar.bBQ;
            this.bwk.a(i, i2, coVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
        this.bwk = ceVar;
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cd
    public void VI() {
    }
}
