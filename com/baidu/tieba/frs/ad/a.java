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
    private FrsADFragment iYT;
    private BdTypeRecyclerView iYU;
    private d iYV;
    private r iYW;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iYT = frsADFragment;
        this.iYU = bdTypeRecyclerView;
        Nt();
    }

    private void Nt() {
        this.iYV = new d(this.iYT.getPageContext(), c.iZj, this.iYT.getUniqueId());
        this.iYW = new r(this.iYT.getPageContext(), s.iWr);
        this.bnf.add(this.iYV);
        this.bnf.add(this.iYW);
        cEG();
        this.iYU.addAdapters(this.bnf);
    }

    public void setData(ArrayList<q> arrayList) {
        this.iYU.setData(arrayList);
    }

    private void cEG() {
        if (!y.isEmpty(this.bnf) && this.iYT != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bnf) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.iYT.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iYU.getAdapter().notifyDataSetChanged();
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
