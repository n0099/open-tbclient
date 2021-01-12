package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.tbadk.core.util.x;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.r;
import com.baidu.tieba.frs.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> bjZ = new ArrayList();
    private FrsADFragment jgB;
    private BdTypeRecyclerView jgC;
    private d jgD;
    private r jgE;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.jgB = frsADFragment;
        this.jgC = bdTypeRecyclerView;
        IY();
    }

    private void IY() {
        this.jgD = new d(this.jgB.getPageContext(), c.jgR, this.jgB.getUniqueId());
        this.jgE = new r(this.jgB.getPageContext(), s.jdY);
        this.bjZ.add(this.jgD);
        this.bjZ.add(this.jgE);
        cDL();
        this.jgC.addAdapters(this.bjZ);
    }

    public void setData(ArrayList<n> arrayList) {
        this.jgC.setData(arrayList);
    }

    private void cDL() {
        if (!x.isEmpty(this.bjZ) && this.jgB != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.jgB.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.jgC.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(w wVar) {
        if (this.bjZ != null && this.bjZ.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bjZ) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(wVar);
                }
            }
        }
    }
}
