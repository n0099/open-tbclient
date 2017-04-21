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
    private ce bNf;

    public void setTag(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(int i, int i2, cl clVar) {
        if (i > 100 && this.bNf != null && clVar != null && clVar.bSx != null && (clVar.bSx instanceof String)) {
            ArrayList<v> arrayList = new ArrayList<>();
            h hVar = new h((String) clVar.bSx);
            hVar.stType = clVar.stType;
            arrayList.add(hVar);
            co coVar = new co();
            coVar.hasMore = false;
            coVar.bSz = false;
            coVar.bSA = false;
            coVar.pn = clVar.pn;
            coVar.bSx = clVar.bSx;
            this.bNf.a(i, i2, coVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.cd
    public void a(ce ceVar) {
        this.bNf = ceVar;
    }

    @Override // com.baidu.tieba.frs.cd
    public void init() {
    }

    @Override // com.baidu.tieba.frs.cd
    public void Nx() {
    }
}
