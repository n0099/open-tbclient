package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bbu = new ArrayList();
    private FrsADFragment hYP;
    private BdTypeRecyclerView hYQ;
    private d hYR;
    private r hYS;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hYP = frsADFragment;
        this.hYQ = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.hYR = new d(this.hYP.getPageContext(), c.hZf, this.hYP.getUniqueId());
        this.hYS = new r(this.hYP.getPageContext(), s.hWl);
        this.bbu.add(this.hYR);
        this.bbu.add(this.hYS);
        cot();
        this.hYQ.addAdapters(this.bbu);
    }

    public void setData(ArrayList<q> arrayList) {
        this.hYQ.setData(arrayList);
    }

    private void cot() {
        if (!y.isEmpty(this.bbu) && this.hYP != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.hYP.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hYQ.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(ab abVar) {
        if (this.bbu != null && this.bbu.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbu) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(abVar);
                }
            }
        }
    }
}
