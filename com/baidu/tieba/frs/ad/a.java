package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.s;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.m;
import com.baidu.tieba.frs.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> asE = new ArrayList();
    private FrsADFragment gsP;
    private BdTypeRecyclerView gsQ;
    private d gsR;
    private m gsS;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gsP = frsADFragment;
        this.gsQ = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.gsR = new d(this.gsP.getPageContext(), c.gtf, this.gsP.getUniqueId());
        this.gsS = new m(this.gsP.getPageContext(), n.gra);
        this.asE.add(this.gsR);
        this.asE.add(this.gsS);
        bFU();
        this.gsQ.addAdapters(this.asE);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.gsQ.setData(arrayList);
    }

    private void bFU() {
        if (!v.isEmpty(this.asE) && this.gsP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gsP.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gsQ.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(s sVar) {
        if (this.asE != null && this.asE.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(sVar);
                }
            }
        }
    }
}
