package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bns = new ArrayList();
    private r jmA;
    private FrsADFragment jmx;
    private BdTypeRecyclerView jmy;
    private d jmz;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jmx = frsADFragment;
        this.jmy = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.jmz = new d(this.jmx.getPageContext(), c.jmN, this.jmx.getUniqueId());
        this.jmA = new r(this.jmx.getPageContext(), s.jjT);
        this.bns.add(this.jmz);
        this.bns.add(this.jmA);
        cFe();
        this.jmy.addAdapters(this.bns);
    }

    public void setData(ArrayList<n> arrayList) {
        this.jmy.setData(arrayList);
    }

    private void cFe() {
        if (!y.isEmpty(this.bns) && this.jmx != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jmx.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.jmy.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(w wVar) {
        if (this.bns != null && this.bns.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(wVar);
                }
            }
        }
    }
}
