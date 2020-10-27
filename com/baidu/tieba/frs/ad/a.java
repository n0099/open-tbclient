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
    private List<com.baidu.adp.widget.ListView.a> bje = new ArrayList();
    private FrsADFragment iHs;
    private BdTypeRecyclerView iHt;
    private d iHu;
    private r iHv;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.iHs = frsADFragment;
        this.iHt = bdTypeRecyclerView;
        Ly();
    }

    private void Ly() {
        this.iHu = new d(this.iHs.getPageContext(), c.iHI, this.iHs.getUniqueId());
        this.iHv = new r(this.iHs.getPageContext(), s.iEO);
        this.bje.add(this.iHu);
        this.bje.add(this.iHv);
        cym();
        this.iHt.addAdapters(this.bje);
    }

    public void setData(ArrayList<q> arrayList) {
        this.iHt.setData(arrayList);
    }

    private void cym() {
        if (!y.isEmpty(this.bje) && this.iHs != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.iHs.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iHt.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(ab abVar) {
        if (this.bje != null && this.bje.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bje) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(abVar);
                }
            }
        }
    }
}
