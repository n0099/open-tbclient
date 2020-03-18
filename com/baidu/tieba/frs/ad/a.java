package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.n;
import com.baidu.tieba.frs.o;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asP = new ArrayList();
    private FrsADFragment gtG;
    private BdTypeRecyclerView gtH;
    private d gtI;
    private n gtJ;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gtG = frsADFragment;
        this.gtH = bdTypeRecyclerView;
        wR();
    }

    private void wR() {
        this.gtI = new d(this.gtG.getPageContext(), c.gtW, this.gtG.getUniqueId());
        this.gtJ = new n(this.gtG.getPageContext(), o.grX);
        this.asP.add(this.gtI);
        this.asP.add(this.gtJ);
        bGg();
        this.gtH.addAdapters(this.asP);
    }

    public void setData(ArrayList<m> arrayList) {
        this.gtH.setData(arrayList);
    }

    private void bGg() {
        if (!v.isEmpty(this.asP) && this.gtG != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gtG.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gtH.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(s sVar) {
        if (this.asP != null && this.asP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asP) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(sVar);
                }
            }
        }
    }
}
