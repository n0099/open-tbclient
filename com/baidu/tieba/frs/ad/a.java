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
    private List<com.baidu.adp.widget.ListView.a> asF = new ArrayList();
    private FrsADFragment gtc;
    private BdTypeRecyclerView gtd;
    private d gte;
    private m gtf;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.gtc = frsADFragment;
        this.gtd = bdTypeRecyclerView;
        wM();
    }

    private void wM() {
        this.gte = new d(this.gtc.getPageContext(), c.gts, this.gtc.getUniqueId());
        this.gtf = new m(this.gtc.getPageContext(), n.grn);
        this.asF.add(this.gte);
        this.asF.add(this.gtf);
        bFV();
        this.gtd.addAdapters(this.asF);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.m> arrayList) {
        this.gtd.setData(arrayList);
    }

    private void bFV() {
        if (!v.isEmpty(this.asF) && this.gtc != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.gtc.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.gtd.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(s sVar) {
        if (this.asF != null && this.asF.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.asF) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(sVar);
                }
            }
        }
    }
}
