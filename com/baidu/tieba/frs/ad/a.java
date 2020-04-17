package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.frs.h;
import com.baidu.tieba.frs.o;
import com.baidu.tieba.frs.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aMd = new ArrayList();
    private FrsADFragment hcR;
    private BdTypeRecyclerView hcS;
    private d hcT;
    private o hcU;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hcR = frsADFragment;
        this.hcS = bdTypeRecyclerView;
        BC();
    }

    private void BC() {
        this.hcT = new d(this.hcR.getPageContext(), c.hdh, this.hcR.getUniqueId());
        this.hcU = new o(this.hcR.getPageContext(), p.hbj);
        this.aMd.add(this.hcT);
        this.aMd.add(this.hcU);
        bQI();
        this.hcS.addAdapters(this.aMd);
    }

    public void setData(ArrayList<m> arrayList) {
        this.hcS.setData(arrayList);
    }

    private void bQI() {
        if (!v.isEmpty(this.aMd) && this.hcR != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar instanceof h) {
                    ((h) aVar).a(this.hcR.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hcS.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
            if (aVar instanceof h) {
                ((h) aVar).release();
            }
        }
    }

    public void a(com.baidu.adp.widget.ListView.v vVar) {
        if (this.aMd != null && this.aMd.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aMd) {
                if (aVar != null && (aVar instanceof h)) {
                    aVar.a(vVar);
                }
            }
        }
    }
}
