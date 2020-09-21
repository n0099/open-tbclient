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
    private List<com.baidu.adp.widget.ListView.a> bdV = new ArrayList();
    private FrsADFragment ifZ;
    private BdTypeRecyclerView iga;
    private d igb;
    private r igc;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.ifZ = frsADFragment;
        this.iga = bdTypeRecyclerView;
        JZ();
    }

    private void JZ() {
        this.igb = new d(this.ifZ.getPageContext(), c.igp, this.ifZ.getUniqueId());
        this.igc = new r(this.ifZ.getPageContext(), s.idu);
        this.bdV.add(this.igb);
        this.bdV.add(this.igc);
        crH();
        this.iga.addAdapters(this.bdV);
    }

    public void setData(ArrayList<q> arrayList) {
        this.iga.setData(arrayList);
    }

    private void crH() {
        if (!y.isEmpty(this.bdV) && this.ifZ != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar instanceof k) {
                    ((k) aVar).a(this.ifZ.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.iga.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
            if (aVar instanceof k) {
                ((k) aVar).release();
            }
        }
    }

    public void a(ab abVar) {
        if (this.bdV != null && this.bdV.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.bdV) {
                if (aVar != null && (aVar instanceof k)) {
                    aVar.a(abVar);
                }
            }
        }
    }
}
