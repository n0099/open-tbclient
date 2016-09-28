package com.baidu.tieba.frs.h5;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tieba.frs.dg;
import com.baidu.tieba.frs.dh;
import com.baidu.tieba.frs.dn;
import com.baidu.tieba.frs.dq;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class i implements dg {
    private dh bNn;

    public void setTag(BdUniqueId bdUniqueId) {
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(int i, int i2, dn dnVar) {
        if (i > 100 && this.bNn != null && dnVar != null && dnVar.bTy != null && (dnVar.bTy instanceof String)) {
            ArrayList<v> arrayList = new ArrayList<>();
            h hVar = new h((String) dnVar.bTy);
            hVar.stType = dnVar.stType;
            arrayList.add(hVar);
            dq dqVar = new dq();
            dqVar.hasMore = false;
            dqVar.bTA = false;
            dqVar.bTB = false;
            dqVar.pn = dnVar.pn;
            dqVar.bTy = dnVar.bTy;
            this.bNn.a(i, i2, dqVar, arrayList);
        }
    }

    @Override // com.baidu.tieba.frs.dg
    public void a(dh dhVar) {
        this.bNn = dhVar;
    }

    @Override // com.baidu.tieba.frs.dg
    public void init() {
    }

    @Override // com.baidu.tieba.frs.dg
    public void aat() {
    }
}
