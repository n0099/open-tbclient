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
/* loaded from: classes21.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> biN = new ArrayList();
    private FrsADFragment iOc;
    private BdTypeRecyclerView iOd;
    private d iOe;
    private r iOf;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iOc = frsADFragment;
        this.iOd = bdTypeRecyclerView;
        Lp();
    }

    private void Lp() {
        this.iOe = new d(this.iOc.getPageContext(), c.iOs, this.iOc.getUniqueId());
        this.iOf = new r(this.iOc.getPageContext(), s.iLy);
        this.biN.add(this.iOe);
        this.biN.add(this.iOf);
        cAq();
        this.iOd.addAdapters(this.biN);
    }

    public void setData(ArrayList<q> arrayList) {
        this.iOd.setData(arrayList);
    }

    private void cAq() {
        if (!y.isEmpty(this.biN) && this.iOc != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.iOc.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iOd.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(ab abVar) {
        if (this.biN != null && this.biN.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.biN) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(abVar);
                }
            }
        }
    }
}
