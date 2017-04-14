package com.baidu.tieba.frs.b;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.cd;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cl;
import com.baidu.tieba.frs.co;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements cd {
    private ce bKO;

    public void setTag(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        if (i > 100 && this.bKO != null && clVar != null && clVar.bQg != null && (clVar.bQg instanceof String)) {
            ArrayList<v> arrayList = new ArrayList<>();
            h hVar = new h((String) clVar.bQg);
            hVar.stType = clVar.stType;
            arrayList.add(hVar);
            co coVar = new co();
            coVar.hasMore = false;
            coVar.bQi = false;
            coVar.bQj = false;
            coVar.pn = clVar.pn;
            coVar.bQg = clVar.bQg;
            this.bKO.a(i, i2, coVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
        this.bKO = ceVar;
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cd
    public void Np() {
    }
}
