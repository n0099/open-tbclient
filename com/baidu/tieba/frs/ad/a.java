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
    private FrsADFragment jmi;
    private BdTypeRecyclerView jmj;
    private d jmk;
    private r jml;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jmi = frsADFragment;
        this.jmj = bdTypeRecyclerView;
        Kw();
    }

    private void Kw() {
        this.jmk = new d(this.jmi.getPageContext(), c.jmz, this.jmi.getUniqueId());
        this.jml = new r(this.jmi.getPageContext(), s.jjF);
        this.bns.add(this.jmk);
        this.bns.add(this.jml);
        cEX();
        this.jmj.addAdapters(this.bns);
    }

    public void setData(ArrayList<n> arrayList) {
        this.jmj.setData(arrayList);
    }

    private void cEX() {
        if (!y.isEmpty(this.bns) && this.jmi != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bns) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jmi.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.jmj.getAdapter().notifyDataSetChanged();
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
