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
    private List<com.baidu.adp.widget.ListView.a> bhH = new ArrayList();
    private FrsADFragment iuW;
    private BdTypeRecyclerView iuX;
    private d iuY;
    private r iuZ;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iuW = frsADFragment;
        this.iuX = bdTypeRecyclerView;
        Le();
    }

    private void Le() {
        this.iuY = new d(this.iuW.getPageContext(), c.ivm, this.iuW.getUniqueId());
        this.iuZ = new r(this.iuW.getPageContext(), s.iss);
        this.bhH.add(this.iuY);
        this.bhH.add(this.iuZ);
        cvf();
        this.iuX.addAdapters(this.bhH);
    }

    public void setData(ArrayList<q> arrayList) {
        this.iuX.setData(arrayList);
    }

    private void cvf() {
        if (!y.isEmpty(this.bhH) && this.iuW != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.iuW.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iuX.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(ab abVar) {
        if (this.bhH != null && this.bhH.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bhH) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(abVar);
                }
            }
        }
    }
}
