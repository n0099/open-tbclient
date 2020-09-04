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
    private List<com.baidu.adp.widget.ListView.a> bbw = new ArrayList();
    private FrsADFragment hYV;
    private BdTypeRecyclerView hYW;
    private d hYX;
    private r hYY;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hYV = frsADFragment;
        this.hYW = bdTypeRecyclerView;
        Jv();
    }

    private void Jv() {
        this.hYX = new d(this.hYV.getPageContext(), c.hZl, this.hYV.getUniqueId());
        this.hYY = new r(this.hYV.getPageContext(), s.hWr);
        this.bbw.add(this.hYX);
        this.bbw.add(this.hYY);
        cou();
        this.hYW.addAdapters(this.bbw);
    }

    public void setData(ArrayList<q> arrayList) {
        this.hYW.setData(arrayList);
    }

    private void cou() {
        if (!y.isEmpty(this.bbw) && this.hYV != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.hYV.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hYW.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(ab abVar) {
        if (this.bbw != null && this.bbw.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bbw) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(abVar);
                }
            }
        }
    }
}
