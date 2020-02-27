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
    private FrsADFragment gsN;
    private BdTypeRecyclerView gsO;
    private d gsP;
    private m gsQ;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gsN = frsADFragment;
        this.gsO = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.gsP = new d(this.gsN.getPageContext(), c.gtd, this.gsN.getUniqueId());
        this.gsQ = new m(this.gsN.getPageContext(), n.gqY);
        this.asE.add(this.gsP);
        this.asE.add(this.gsQ);
        bFS();
        this.gsO.addAdapters(this.asE);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.gsO.setData(arrayList);
    }

    private void bFS() {
        if (!v.isEmpty(this.asE) && this.gsN != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asE) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gsN.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gsO.getAdapter().notifyDataSetChanged();
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
