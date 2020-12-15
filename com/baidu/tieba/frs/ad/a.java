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
    private List<com.baidu.adp.widget.ListView.a> bnf = new ArrayList();
    private FrsADFragment iYV;
    private BdTypeRecyclerView iYW;
    private d iYX;
    private r iYY;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iYV = frsADFragment;
        this.iYW = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.iYX = new d(this.iYV.getPageContext(), c.iZl, this.iYV.getUniqueId());
        this.iYY = new r(this.iYV.getPageContext(), s.iWt);
        this.bnf.add(this.iYX);
        this.bnf.add(this.iYY);
        cEH();
        this.iYW.addAdapters(this.bnf);
    }

    public void setData(ArrayList<q> arrayList) {
        this.iYW.setData(arrayList);
    }

    private void cEH() {
        if (!y.isEmpty(this.bnf) && this.iYV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.iYV.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iYW.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(ab abVar) {
        if (this.bnf != null && this.bnf.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(abVar);
                }
            }
        }
    }
}
