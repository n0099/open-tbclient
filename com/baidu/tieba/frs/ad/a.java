package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.frs.j;
import com.baidu.tieba.frs.q;
import com.baidu.tieba.frs.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private List<com.baidu.adp.widget.ListView.a> aUP = new ArrayList();
    private FrsADFragment hEM;
    private BdTypeRecyclerView hEN;
    private d hEO;
    private q hEP;

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.hEM = frsADFragment;
        this.hEN = bdTypeRecyclerView;
        Dz();
    }

    private void Dz() {
        this.hEO = new d(this.hEM.getPageContext(), c.hFc, this.hEM.getUniqueId());
        this.hEP = new q(this.hEM.getPageContext(), r.hCX);
        this.aUP.add(this.hEO);
        this.aUP.add(this.hEP);
        caq();
        this.hEN.addAdapters(this.aUP);
    }

    public void setData(ArrayList<com.baidu.adp.widget.ListView.q> arrayList) {
        this.hEN.setData(arrayList);
    }

    private void caq() {
        if (!w.isEmpty(this.aUP) && this.hEM != null) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar instanceof j) {
                    ((j) aVar).a(this.hEM.getTbPageTag());
                }
            }
        }
    }

    public void notifyDataSetChanged() {
        this.hEN.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
            if (aVar instanceof j) {
                ((j) aVar).release();
            }
        }
    }

    public void a(z zVar) {
        if (this.aUP != null && this.aUP.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.aUP) {
                if (aVar != null && (aVar instanceof j)) {
                    aVar.a(zVar);
                }
            }
        }
    }
}
