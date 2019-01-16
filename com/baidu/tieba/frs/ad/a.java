package com.baidu.tieba.frs.ad;

import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.n;
import com.baidu.tieba.frs.l;
import com.baidu.tieba.frs.m;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class a {
    private FrsADFragment dPF;
    private BdTypeRecyclerView dPG;
    private d dPH;
    private l dPI;
    private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

    public a(FrsADFragment frsADFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        this.dPF = frsADFragment;
        this.dPG = bdTypeRecyclerView;
        initAdapters();
    }

    private void initAdapters() {
        this.dPH = new d(this.dPF.getPageContext(), c.dPU, this.dPF.getUniqueId());
        this.dPI = new l(this.dPF.getPageContext(), m.dOd);
        this.mAdapters.add(this.dPH);
        this.mAdapters.add(this.dPI);
        this.dPG.addAdapters(this.mAdapters);
    }

    public void setData(ArrayList<h> arrayList) {
        this.dPG.setData(arrayList);
    }

    public void notifyDataSetChanged() {
        this.dPG.getAdapter().notifyDataSetChanged();
    }

    public void onDestory() {
        for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
            if (aVar instanceof com.baidu.tieba.frs.h) {
                ((com.baidu.tieba.frs.h) aVar).release();
            }
        }
    }

    public void setOnAdapterItemClickListener(n nVar) {
        if (this.mAdapters != null && this.mAdapters.size() != 0) {
            for (com.baidu.adp.widget.ListView.a aVar : this.mAdapters) {
                if (aVar != null && (aVar instanceof com.baidu.tieba.frs.h)) {
                    aVar.setOnAdapterItemClickListener(nVar);
                }
            }
        }
    }
}
