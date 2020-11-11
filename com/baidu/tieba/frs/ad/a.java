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
/* loaded from: classes22.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bky = new ArrayList();
    private FrsADFragment iNp;
    private BdTypeRecyclerView iNq;
    private d iNr;
    private r iNs;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iNp = frsADFragment;
        this.iNq = bdTypeRecyclerView;
        LY();
    }

    private void LY() {
        this.iNr = new d(this.iNp.getPageContext(), c.iNF, this.iNp.getUniqueId());
        this.iNs = new r(this.iNp.getPageContext(), s.iKL);
        this.bky.add(this.iNr);
        this.bky.add(this.iNs);
        cAN();
        this.iNq.addAdapters(this.bky);
    }

    public void setData(ArrayList<q> arrayList) {
        this.iNq.setData(arrayList);
    }

    private void cAN() {
        if (!y.isEmpty(this.bky) && this.iNp != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.iNp.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iNq.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(ab abVar) {
        if (this.bky != null && this.bky.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bky) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(abVar);
                }
            }
        }
    }
}
