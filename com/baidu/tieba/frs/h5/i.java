package com.baidu.tieba.frs.h5;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.ce;
import com.baidu.tieba.frs.cf;
import com.baidu.tieba.frs.cm;
import com.baidu.tieba.frs.cp;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements ce {
    private cf bQg;

    public void setTag(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(int i, int i2, cm cmVar) {
        if (i > 100 && this.bQg != null && cmVar != null && cmVar.bVI != null && (cmVar.bVI instanceof String)) {
            ArrayList<v> arrayList = new ArrayList<>();
            h hVar = new h((String) cmVar.bVI);
            hVar.stType = cmVar.stType;
            arrayList.add(hVar);
            cp cpVar = new cp();
            cpVar.hasMore = false;
            cpVar.bVK = false;
            cpVar.bVL = false;
            cpVar.pn = cmVar.pn;
            cpVar.bVI = cmVar.bVI;
            this.bQg.a(i, i2, cpVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.ce
    public void a(cf cfVar) {
        this.bQg = cfVar;
    }

    @Override // com.baidu.tieba.frs.ce
    public void init() {
    }

    @Override // com.baidu.tieba.frs.ce
    public void abv() {
    }
}
